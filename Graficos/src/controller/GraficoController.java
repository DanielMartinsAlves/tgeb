package controller;

import org.jfree.data.category.DefaultCategoryDataset;

import model.Configuracoes;

public class GraficoController {
	
	public GraficoController() {
		
	}
	public void atualizarGrafico(DefaultCategoryDataset ds, Configuracoes config, double[] dados ) {
		int valorFinal = 0;
		if (ds.getColumnCount() > 0) {
			String valorNumero = String.valueOf(ds.getColumnKey(ds.getColumnCount()-1)).replace("instante ", "");
			valorFinal = Integer.parseInt(valorNumero);
		}
		for(int i = 0; i< dados.length; i++) {
			
			ds.addValue(dados[i], "eletrode "+i, ""+(valorFinal+1));
		}
		if(ds.getColumnCount()>20) {
			ds.removeColumn(0);
		}
		
	}
}
