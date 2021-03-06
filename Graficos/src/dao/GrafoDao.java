package dao;

import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Utilidades.Calculos;
import model.Configuracoes;
import model.Eletrodo;
import model.MatrizAdjacencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class GrafoDao {
	private List<MatrizAdjacencia> listaMatrizAdjacencia;
	private List<Eletrodo> eletrodos;
	public GrafoDao(Configuracoes config) {
		eletrodos = new ArrayList<Eletrodo>();
		for(int i=0;i<config.getNodesNumber();i++)
		eletrodos.add(new Eletrodo());
		if(!config.isFromOpenBCI()) {
			carregarEletrodosDeArquivo(config);
			listaMatrizAdjacencia = converterDadosEmMatrizAdjacencia(config);
		}
	}
	public List<Eletrodo> getEletrodos(){
		return this.eletrodos;
	}
	public List<MatrizAdjacencia> converterDadosEmMatrizAdjacencia(Configuracoes config) {
		List<MatrizAdjacencia> listaMatrizAd = new ArrayList<MatrizAdjacencia>();
		Calculos c = new Calculos();
		for(int inicial=0; inicial< eletrodos.get(0).getValores().size();inicial=inicial+config.getRegistrosPorAtualizacao()) {
			int fim = (inicial+(config.getRegistrosPorGrafo()-1) >= eletrodos.get(0).getValores().size())?eletrodos.get(0).getValores().size():inicial+(config.getRegistrosPorGrafo()-1);
		//inicia matriz
			double [][] matriz = new double[config.getNodesNumber()][config.getNodesNumber()];// estava iniciado tudo com 0
			//System.out.println("Inicio Matriz");
			for(int i = 0; i< eletrodos.size();i++) {
				// inicia linha
				double[] linha = new double[config.getNodesNumber()];
				//System.out.println("Inicio Linha");
				for(int z = 0;z < eletrodos.size();z++) {
					linha[z] = c.correlacaoDePearson(eletrodos.get(i).pegarValores(inicial, fim), eletrodos.get(z).pegarValores(inicial, fim), config);
				}
				matriz[i]=linha;
				//System.out.println("Fim Linha");
			}
			MatrizAdjacencia matrizAd = new MatrizAdjacencia();
			matrizAd.setDados(matriz);
			listaMatrizAd.add(matrizAd);
			//System.out.println("Fim Matriz");
		}
		return listaMatrizAd;
	}
	private String[] calcularCARFilter(String[] linha, int tamanho) {
		double media = 0.0;
		String[] retorno = new String[tamanho];
		retorno[0] = "0";
		for(String coluna: linha) {
			media += Double.parseDouble(coluna);
		}
		media = media/linha.length;
		for(int i = 0; i< linha.length; i++) {
			retorno[i+1] = ""+(Double.parseDouble(linha[i]) - media);
		}
		
		return retorno;
	}
	public void carregarEletrodosDeArquivo(Configuracoes config) {
		
		try {
			
			
		      FileReader arq = new FileReader(config.getArquivoLeitura());
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      String linha = lerArq.readLine(); // l� a primeira linha
		// a vari�vel "linha" recebe o valor "null" quando o processo
		// de repeti��o atingir o final do arquivo texto
		     while (linha != null) {
		        String[] arrayLinha = linha.split(",");
		       
		        System.out.println(linha);
		        if(arrayLinha.length>=config.getNodesNumber()+1) {
		        	for(int i = 0; i < config.getNodesNumber()+1; i++) {//tratando casos onde o registro vem "-"
		        		if(arrayLinha[i].equals(" -"))
		    			arrayLinha[i]="0";
		    		}
		        	if(config.isCARfilter()) {
		        		arrayLinha = this.calcularCARFilter(Arrays.copyOfRange(arrayLinha, 1, config.getNodesNumber()+1), config.getNodesNumber()+1);
				     }
		    		System.out.println(java.util.Arrays.toString(arrayLinha));
		    		
		    		for(int i = 0; i<config.getNodesNumber();i++) {
		    			eletrodos.get(i).adicionarValor(Double.parseDouble(arrayLinha[i+1]));
		    		}
		        }
		        linha = lerArq.readLine(); // l� da segunda at� a �ltima linha

		      }
		      //System.out.println(linha);
		      arq.close();
		    
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Error: Can not open file:\n"+e.getMessage());
		    }
	}
	
	public MatrizAdjacencia geMatrizAdjacencia() throws IndexOutOfBoundsException{	
	MatrizAdjacencia matriz =  this.listaMatrizAdjacencia.get(0);
	this.listaMatrizAdjacencia.remove(0);
	return matriz;
	}
	
	public void carregarEletrodosFromJson(Configuracoes config) {
		this.eletrodos = new ArrayList<Eletrodo>();
		for(int i=0;i<config.getNodesNumber();i++)
		this.eletrodos.add(new Eletrodo());
		  try {

	            URL url = new URL("http://localhost:3000/api/data/"+config.getRegistrosPorGrafo());//your url i.e fetch data from .
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.setRequestProperty("Accept", "application/json");
	            if (conn.getResponseCode() != 200) {
	                throw new RuntimeException("Failed : HTTP Error code : "
	                        + conn.getResponseCode());
	            }
	            InputStreamReader in = new InputStreamReader(conn.getInputStream());
	            BufferedReader br = new BufferedReader(in);
	            String output;
	            while ((output = br.readLine()) != null) {
	            	
	                System.out.println(output);
	                JSONParser jsonParser = new JSONParser();
	                JSONObject jsonObject = (JSONObject) jsonParser.parse(output);
	                JSONArray arrayRegistros= (JSONArray) jsonObject.get("data");
	                for(int i=0; i<arrayRegistros.size(); i++){
	                	 JSONArray arrayEletrodos = (JSONArray) arrayRegistros.get(i);
	                	 
	                	 String[] arrayLinha = new String[config.getNodesNumber()+1];
	                	 arrayLinha[0] = "0";
	                	 for(int z=0; z<config.getNodesNumber(); z++){
	                		 arrayLinha[z+1] = (String) arrayEletrodos.get(z+1);
	                		 if(arrayLinha[z+1].equals(" -"))
	                			 arrayLinha[z+1]="0";
		                }
	                	 
	                	 if(config.isCARfilter()) {
	                		 arrayLinha = this.calcularCARFilter(Arrays.copyOfRange(arrayLinha, 1, config.getNodesNumber()+1), config.getNodesNumber()+1);
	 				     }
	                	 for(int z=0; z<config.getNodesNumber(); z++){
	                		 //colocar car filter
	                		 Double valorDouble = Double.parseDouble(arrayLinha[z+1]);
	                		 this.eletrodos.get(z).adicionarValor(valorDouble);
		                }
	                }
	            }
	            
	            conn.disconnect();
	            List<MatrizAdjacencia> listaMatrizAd = new ArrayList<MatrizAdjacencia>();
	            double [][] matriz = new double[config.getNodesNumber()][config.getNodesNumber()];
	            for(int i = 0; i< eletrodos.size();i++) {
					// inicia linha
					double[] linha = new double[config.getNodesNumber()];
					//System.out.println("Inicio Linha");
					for(int z = 0;z < eletrodos.size();z++) {
						Calculos c = new Calculos();
						linha[z] = c.correlacaoDePearson(eletrodos.get(i).pegarValores(0, eletrodos.get(i).getValores().size()-1), eletrodos.get(z).pegarValores(0, eletrodos.get(z).getValores().size()-1), config);
					}
					matriz[i]=linha;
					//System.out.println("Fim Linha");
				}
				MatrizAdjacencia matrizAd = new MatrizAdjacencia();
				matrizAd.setDados(matriz);
				listaMatrizAd.add(matrizAd);
				this.listaMatrizAdjacencia = listaMatrizAd;
	        } catch (Exception e) {
	            System.out.println("Exception in NetClientGet:- " + e);
	        }
	}
}
