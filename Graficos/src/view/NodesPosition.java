package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utilidades.RoundButton;
import javax.swing.JTextField;
import java.awt.Font;

public class NodesPosition extends JFrame {

	private JPanel contentPane;
	private JTextField txtNodesPositions;
	private JPrincipal janelaPai;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NodesPosition frame = new NodesPosition(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NodesPosition(JPrincipal janelaPai) {
		setTitle("New Layout");
		this.janelaPai = janelaPai;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 844);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNodesPositions.getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Please, before select the nodes positions");
				}else {
				
					PrintWriter writer = null;
					try {
						String nameLayout = JOptionPane.showInputDialog(contentPane, "Enter with the name of the new layout");
						FileWriter fw = new FileWriter("layouts.txt", true);
					    BufferedWriter bw = new BufferedWriter(fw);
						writer = new PrintWriter(bw);
						writer.println(nameLayout+";"+txtNodesPositions.getText());
						
						JOptionPane.showMessageDialog(contentPane, "New layout created!");
					} catch (FileNotFoundException | UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						writer.close();
					}
					janelaPai.atualizarCampoLayouts();
				}
			}
		});
		
		btnNewButton.setBounds(408, 58, 136, 23);
		contentPane.add(btnNewButton);
		
		RoundButton rndbtnFpz = new RoundButton((String) null);
		rndbtnFpz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnFpz.setText("Nz");
		rndbtnFpz.setBounds(386, 118, 52, 51);
		contentPane.add(rndbtnFpz);
		
		RoundButton roundButton = new RoundButton((String) null);
		roundButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		roundButton.setText("Fpz");
		roundButton.setBounds(386, 180, 52, 51);
		contentPane.add(roundButton);
		
		
		RoundButton rndbtnAfz = new RoundButton((String) null);
		rndbtnAfz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnAfz.setText("AFz");
		rndbtnAfz.setBounds(386, 242, 52, 51);
		contentPane.add(rndbtnAfz);
		
		
		RoundButton rndbtnFz = new RoundButton((String) null);
		rndbtnFz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFz.setText("Fz");
		rndbtnFz.setBounds(386, 304, 52, 51);
		contentPane.add(rndbtnFz);
		
		
		RoundButton rndbtnFcz = new RoundButton((String) null);
		rndbtnFcz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFcz.setText("FCz");
		rndbtnFcz.setBounds(386, 366, 52, 51);
		contentPane.add(rndbtnFcz);
		
		RoundButton rndbtnCz = new RoundButton((String) null);
		rndbtnCz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCz.setText("Cz");
		rndbtnCz.setBounds(386, 428, 52, 51);
		contentPane.add(rndbtnCz);
		
		RoundButton rndbtnCpz = new RoundButton((String) null);
		rndbtnCpz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCpz.setText("CPz");
		rndbtnCpz.setBounds(386, 490, 52, 51);
		contentPane.add(rndbtnCpz);
		
		
		RoundButton rndbtnPz = new RoundButton((String) null);
		rndbtnPz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPz.setText("Pz");
		rndbtnPz.setBounds(386, 552, 52, 51);
		contentPane.add(rndbtnPz);
		
		
		RoundButton rndbtnPoz = new RoundButton((String) null);
		rndbtnPoz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPoz.setText("POz");
		rndbtnPoz.setBounds(386, 614, 52, 51);
		contentPane.add(rndbtnPoz);
		
		
		RoundButton rndbtnOz = new RoundButton((String) null);
		rndbtnOz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnOz.setText("Oz");
		rndbtnOz.setBounds(386, 676, 52, 51);
		contentPane.add(rndbtnOz);
		
		
		RoundButton rndbtnIz = new RoundButton((String) null);
		rndbtnIz.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnIz.setText("Iz");
		rndbtnIz.setBounds(386, 738, 52, 51);
		contentPane.add(rndbtnIz);
		
		
		RoundButton rndbtnC_3 = new RoundButton((String) null);
		rndbtnC_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC_3.setText("C1");
		rndbtnC_3.setBounds(324, 428, 52, 51);
		contentPane.add(rndbtnC_3);
		
		
		RoundButton rndbtnC_4 = new RoundButton((String) null);
		rndbtnC_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC_4.setText("C3");
		rndbtnC_4.setBounds(262, 428, 52, 51);
		contentPane.add(rndbtnC_4);
		
		RoundButton rndbtnC_5 = new RoundButton((String) null);
		rndbtnC_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC_5.setText("C5");
		rndbtnC_5.setBounds(200, 428, 52, 51);
		contentPane.add(rndbtnC_5);
		
		
		RoundButton rndbtnT_2 = new RoundButton((String) null);
		rndbtnT_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnT_2.setText("T7");
		rndbtnT_2.setBounds(138, 428, 52, 51);
		contentPane.add(rndbtnT_2);
		
		
		RoundButton rndbtnT_3 = new RoundButton((String) null);
		rndbtnT_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnT_3.setText("T9");
		rndbtnT_3.setBounds(76, 428, 52, 51);
		contentPane.add(rndbtnT_3);
		
		
		RoundButton rndbtnA_1 = new RoundButton((String) null);
		rndbtnA_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnA_1.setText("A1");
		rndbtnA_1.setBounds(14, 428, 52, 51);
		contentPane.add(rndbtnA_1);
		
		
		RoundButton rndbtnC = new RoundButton((String) null);
		rndbtnC.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC.setText("C2");
		rndbtnC.setBounds(448, 428, 52, 51);
		contentPane.add(rndbtnC);
		
		RoundButton rndbtnC_1 = new RoundButton((String) null);
		rndbtnC_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC_1.setText("C4");
		rndbtnC_1.setBounds(510, 428, 52, 51);
		contentPane.add(rndbtnC_1);
		
		
		RoundButton rndbtnC_2 = new RoundButton((String) null);
		rndbtnC_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnC_2.setText("C6");
		rndbtnC_2.setBounds(572, 428, 52, 51);
		contentPane.add(rndbtnC_2);
		
		
		RoundButton rndbtnT = new RoundButton((String) null);
		rndbtnT.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnT.setText("T8");
		rndbtnT.setBounds(634, 428, 52, 51);
		contentPane.add(rndbtnT);
		
		RoundButton rndbtnT_1 = new RoundButton((String) null);
		rndbtnT_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnT_1.setText("T10");
		rndbtnT_1.setBounds(696, 428, 52, 51);
		contentPane.add(rndbtnT_1);
		
		RoundButton rndbtnA = new RoundButton((String) null);
		rndbtnA.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnA.setText("A2");
		rndbtnA.setBounds(758, 428, 52, 51);
		contentPane.add(rndbtnA);
		
		
		RoundButton rndbtnFc = new RoundButton((String) null);
		rndbtnFc.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc.setText("FC2");
		rndbtnFc.setBounds(442, 366, 52, 51);
		contentPane.add(rndbtnFc);
		
		
		RoundButton rndbtnFc_3 = new RoundButton((String) null);
		rndbtnFc_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc_3.setText("FC1");
		rndbtnFc_3.setBounds(328, 366, 52, 51);
		contentPane.add(rndbtnFc_3);
		
		
		RoundButton rndbtnFc_4 = new RoundButton((String) null);
		rndbtnFc_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc_4.setText("FC3");
		rndbtnFc_4.setBounds(270, 363, 52, 51);
		contentPane.add(rndbtnFc_4);
		
		
		RoundButton rndbtnFc_5 = new RoundButton((String) null);
		rndbtnFc_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc_5.setText("FC5");
		rndbtnFc_5.setBounds(210, 360, 52, 51);
		contentPane.add(rndbtnFc_5);
		
		
		RoundButton rndbtnFt_2 = new RoundButton((String) null);
		rndbtnFt_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFt_2.setText("FT7");
		rndbtnFt_2.setBounds(150, 357, 52, 51);
		contentPane.add(rndbtnFt_2);
		
		
		RoundButton rndbtnFt_3 = new RoundButton((String) null);
		rndbtnFt_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFt_3.setText("FT9");
		rndbtnFt_3.setBounds(90, 350, 52, 51);
		contentPane.add(rndbtnFt_3);
		
		
		RoundButton rndbtnF_5 = new RoundButton((String) null);
		rndbtnF_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_5.setText("F1");
		rndbtnF_5.setBounds(335, 302, 52, 51);
		contentPane.add(rndbtnF_5);
		
		
		RoundButton rndbtnF_6 = new RoundButton((String) null);
		rndbtnF_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_6.setText("F3");
		rndbtnF_6.setBounds(284, 299, 52, 51);
		contentPane.add(rndbtnF_6);
		
		
		RoundButton rndbtnF_7 = new RoundButton((String) null);
		rndbtnF_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_7.setText("F5");
		rndbtnF_7.setBounds(232, 295, 52, 51);
		contentPane.add(rndbtnF_7);
		
		
		RoundButton rndbtnF_8 = new RoundButton((String) null);
		rndbtnF_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnF_8.setText("F7");
		rndbtnF_8.setBounds(181, 285, 52, 51);
		contentPane.add(rndbtnF_8);
		
		RoundButton rndbtnF_9 = new RoundButton((String) null);
		rndbtnF_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnF_9.setText("F9");
		rndbtnF_9.setBounds(124, 270, 52, 51);
		contentPane.add(rndbtnF_9);
		
		RoundButton rndbtnAf_2 = new RoundButton((String) null);
		rndbtnAf_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnAf_2.setText("AF3");
		rndbtnAf_2.setBounds(296, 243, 52, 51);
		contentPane.add(rndbtnAf_2);
		
		RoundButton rndbtnAf_3 = new RoundButton((String) null);
		rndbtnAf_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnAf_3.setText("AF7");
		rndbtnAf_3.setBounds(240, 228, 52, 51);
		contentPane.add(rndbtnAf_3);
		
		RoundButton rndbtnFp = new RoundButton((String) null);
		rndbtnFp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnFp.setText("Fp1");
		rndbtnFp.setBounds(304, 193, 52, 51);
		contentPane.add(rndbtnFp);
		
		RoundButton rndbtnCp_4 = new RoundButton((String) null);
		rndbtnCp_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_4.setText("TP9");
		rndbtnCp_4.setBounds(90, 505, 52, 51);
		contentPane.add(rndbtnCp_4);
		
		
		RoundButton rndbtnP_9 = new RoundButton((String) null);
		rndbtnP_9.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_9.setText("P9");
		rndbtnP_9.setBounds(124, 580, 52, 51);
		contentPane.add(rndbtnP_9);
		
		
		RoundButton rndbtnCp_3 = new RoundButton((String) null);
		rndbtnCp_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_3.setText("TP7");
		rndbtnCp_3.setBounds(150, 500, 52, 51);
		contentPane.add(rndbtnCp_3);
		
		
		RoundButton rndbtnCp_2 = new RoundButton((String) null);
		rndbtnCp_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_2.setText("CP5");
		rndbtnCp_2.setBounds(210, 495, 52, 51);
		contentPane.add(rndbtnCp_2);
		
		
		RoundButton rndbtnCp_1 = new RoundButton((String) null);
		rndbtnCp_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_1.setText("CP3");
		rndbtnCp_1.setBounds(272, 493, 52, 51);
		contentPane.add(rndbtnCp_1);
		
		
		RoundButton rndbtnCp = new RoundButton((String) null);
		rndbtnCp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp.setText("CP1");
		rndbtnCp.setBounds(328, 490, 52, 51);
		contentPane.add(rndbtnCp);
		
		
		RoundButton rndbtnP_8 = new RoundButton((String) null);
		rndbtnP_8.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_8.setText("P7");
		rndbtnP_8.setBounds(181, 570, 52, 51);
		contentPane.add(rndbtnP_8);
		
		
		RoundButton rndbtnP_7 = new RoundButton((String) null);
		rndbtnP_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_7.setText("P5");
		rndbtnP_7.setBounds(232, 558, 52, 51);
		contentPane.add(rndbtnP_7);
		
		
		RoundButton rndbtnP_6 = new RoundButton((String) null);
		rndbtnP_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_6.setText("P3");
		rndbtnP_6.setBounds(284, 554, 52, 51);
		contentPane.add(rndbtnP_6);
		
		
		RoundButton rndbtnP_5 = new RoundButton((String) null);
		rndbtnP_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_5.setText("P1");
		rndbtnP_5.setBounds(335, 553, 52, 51);
		contentPane.add(rndbtnP_5);
		
		
		RoundButton rndbtnPo_2 = new RoundButton((String) null);
		rndbtnPo_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPo_2.setText("PO3");
		rndbtnPo_2.setBounds(296, 614, 52, 51);
		contentPane.add(rndbtnPo_2);
		
		
		RoundButton rndbtnO = new RoundButton((String) null);
		rndbtnO.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnO.setText("O1");
		rndbtnO.setBounds(304, 666, 52, 51);
		contentPane.add(rndbtnO);
		
		
		RoundButton rndbtnPo_3 = new RoundButton((String) null);
		rndbtnPo_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPo_3.setText("PO7");
		rndbtnPo_3.setBounds(230, 630, 52, 51);
		contentPane.add(rndbtnPo_3);
		
		
		RoundButton rndbtnO_1 = new RoundButton((String) null);
		rndbtnO_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnO_1.setText("O2");
		rndbtnO_1.setBounds(464, 666, 52, 51);
		contentPane.add(rndbtnO_1);
		
		
		RoundButton rndbtnPo_1 = new RoundButton((String) null);
		rndbtnPo_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPo_1.setText("PO8");
		rndbtnPo_1.setBounds(534, 630, 52, 51);
		contentPane.add(rndbtnPo_1);
		
		
		RoundButton rndbtnP_3 = new RoundButton((String) null);
		rndbtnP_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_3.setText("P8");
		rndbtnP_3.setBounds(591, 570, 52, 51);
		contentPane.add(rndbtnP_3);
		
		
		RoundButton rndbtnTp = new RoundButton((String) null);
		rndbtnTp.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnTp.setText("TP8");
		rndbtnTp.setBounds(625, 500, 52, 51);
		contentPane.add(rndbtnTp);
		
		
		RoundButton rndbtnFt = new RoundButton((String) null);
		rndbtnFt.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFt.setText("FT8");
		rndbtnFt.setBounds(625, 357, 52, 51);
		contentPane.add(rndbtnFt);
		
		
		RoundButton rndbtnF_3 = new RoundButton((String) null);
		rndbtnF_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_3.setText("F8");
		rndbtnF_3.setBounds(591, 285, 52, 51);
		contentPane.add(rndbtnF_3);
		
		
		RoundButton rndbtnAf_1 = new RoundButton((String) null);
		rndbtnAf_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnAf_1.setText("AF8");
		rndbtnAf_1.setBounds(534, 228, 52, 51);
		contentPane.add(rndbtnAf_1);
		
		RoundButton rndbtnFp_1 = new RoundButton((String) null);
		rndbtnFp_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnFp_1.setText("Fp2");
		rndbtnFp_1.setBounds(464, 193, 52, 51);
		contentPane.add(rndbtnFp_1);
		
		RoundButton rndbtnPo = new RoundButton((String) null);
		rndbtnPo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnPo.setText("PO4");
		rndbtnPo.setBounds(475, 614, 52, 51);
		contentPane.add(rndbtnPo);
		
		RoundButton rndbtnP = new RoundButton((String) null);
		rndbtnP.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP.setText("P2");
		rndbtnP.setBounds(438, 552, 52, 51);
		contentPane.add(rndbtnP);
		
		RoundButton rndbtnP_1 = new RoundButton((String) null);
		rndbtnP_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_1.setText("P4");
		rndbtnP_1.setBounds(489, 554, 52, 51);
		contentPane.add(rndbtnP_1);
		
		
		RoundButton rndbtnP_2 = new RoundButton((String) null);
		rndbtnP_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_2.setText("P6");
		rndbtnP_2.setBounds(540, 560, 52, 51);
		contentPane.add(rndbtnP_2);
		
		
		RoundButton rndbtnCp_5 = new RoundButton((String) null);
		rndbtnCp_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_5.setText("CP2");
		rndbtnCp_5.setBounds(442, 490, 52, 51);
		contentPane.add(rndbtnCp_5);
		
		
		RoundButton rndbtnCp_6 = new RoundButton((String) null);
		rndbtnCp_6.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_6.setText("CP4");
		rndbtnCp_6.setBounds(502, 493, 52, 51);
		contentPane.add(rndbtnCp_6);
		
		RoundButton rndbtnCp_7 = new RoundButton((String) null);
		rndbtnCp_7.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnCp_7.setText("CP6");
		rndbtnCp_7.setBounds(563, 495, 52, 51);
		contentPane.add(rndbtnCp_7);
		
		
		RoundButton rndbtnP_4 = new RoundButton((String) null);
		rndbtnP_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnP_4.setText("P10");
		rndbtnP_4.setBounds(653, 580, 52, 51);
		contentPane.add(rndbtnP_4);
		
		
		RoundButton rndbtnTp_1 = new RoundButton((String) null);
		rndbtnTp_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnTp_1.setText("TP10");
		rndbtnTp_1.setBounds(687, 505, 52, 51);
		contentPane.add(rndbtnTp_1);
		
		
		RoundButton rndbtnFt_1 = new RoundButton((String) null);
		rndbtnFt_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFt_1.setText("FT10");
		rndbtnFt_1.setBounds(687, 350, 52, 51);
		contentPane.add(rndbtnFt_1);
		
		
		RoundButton rndbtnF_4 = new RoundButton((String) null);
		rndbtnF_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_4.setText("F10");
		rndbtnF_4.setBounds(653, 270, 52, 51);
		contentPane.add(rndbtnF_4);
		
		
		RoundButton rndbtnFc_1 = new RoundButton((String) null);
		rndbtnFc_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc_1.setText("FC4");
		rndbtnFc_1.setBounds(502, 363, 52, 51);
		contentPane.add(rndbtnFc_1);
		
		
		RoundButton rndbtnFc_2 = new RoundButton((String) null);
		rndbtnFc_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnFc_2.setText("FC6");
		rndbtnFc_2.setBounds(563, 360, 52, 51);
		contentPane.add(rndbtnFc_2);
		
		
		RoundButton rndbtnF = new RoundButton((String) null);
		rndbtnF.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF.setText("F2");
		rndbtnF.setBounds(438, 302, 52, 51);
		contentPane.add(rndbtnF);
		
		
		RoundButton rndbtnF_1 = new RoundButton((String) null);
		rndbtnF_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_1.setText("F4");
		rndbtnF_1.setBounds(489, 298, 52, 51);
		contentPane.add(rndbtnF_1);
		
		RoundButton rndbtnF_2 = new RoundButton((String) null);
		rndbtnF_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		rndbtnF_2.setText("F6");
		rndbtnF_2.setBounds(540, 295, 52, 51);
		contentPane.add(rndbtnF_2);
		
		
		RoundButton rndbtnAf = new RoundButton((String) null);
		rndbtnAf.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		rndbtnAf.setText("AF4");
		rndbtnAf.setBounds(470, 242, 52, 51);
		contentPane.add(rndbtnAf);
		JButton btnClean = new JButton("Clean");
		btnClean.setBounds(262, 58, 136, 23);
		contentPane.add(btnClean);
		
		txtNodesPositions = new JTextField();
		txtNodesPositions.setEditable(false);
		txtNodesPositions.setBounds(14, 32, 806, 20);
		contentPane.add(txtNodesPositions);
		txtNodesPositions.setColumns(10);
		
		Component[] listaComponentes = this.getContentPane().getComponents();
		for(Component cp : listaComponentes) {
			if(cp instanceof RoundButton) {
				RoundButton rb = (RoundButton) cp;
				rb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						rb.setBackground(Color.GREEN);
						if(txtNodesPositions.getText().equals(""))
							txtNodesPositions.setText(rb.getText());
						else
							txtNodesPositions.setText(txtNodesPositions.getText()+";"+rb.getText());
						
					}
				});
			}
				
		}
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Component cp : listaComponentes) {
					if(cp instanceof RoundButton) {
						RoundButton rb = (RoundButton) cp;
						cp.setBackground(Color.LIGHT_GRAY);
						txtNodesPositions.setText("");
					}
						
				}
				
			}
		});
	}
}
