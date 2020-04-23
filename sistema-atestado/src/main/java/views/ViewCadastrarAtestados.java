package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enumeracoes.TipoExameEnum;

public class ViewCadastrarAtestados {

	private JFrame frame;
	private JTextField inputFuncionario;
	private JTextField inputMedico;

	

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(JFrame frameAnterior) {
		frameAnterior.setVisible(false);
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 500);
		frame.setTitle("Cadastrar Atestado");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTipoExame = new JLabel(" Tipo Exame:");
		lblTipoExame.setBounds(31, 24, 141, 14);
		frame.getContentPane().add(lblTipoExame);
		
		JComboBox comboBoxTipoExame = new JComboBox();
		comboBoxTipoExame.setModel(new DefaultComboBoxModel(TipoExameEnum.values()));
		comboBoxTipoExame.setBounds(31, 49, 234, 20);
		frame.getContentPane().add(comboBoxTipoExame);
		
		JLabel lblAptidao = new JLabel("Aptid\u00E3o:");
		lblAptidao.setBounds(31, 304, 46, 14);
		frame.getContentPane().add(lblAptidao);
		
		JRadioButton rdbtnApto = new JRadioButton("Apto");
		rdbtnApto.setBounds(31, 325, 60, 23);
		frame.getContentPane().add(rdbtnApto);
		
		JRadioButton rdbtnNaoApto = new JRadioButton("N\u00E3o Apto");
		rdbtnNaoApto.setBounds(125, 325, 109, 23);
		frame.getContentPane().add(rdbtnNaoApto);
		
		JLabel lblFuncionrio = new JLabel("Funcion\u00E1rio:");
		lblFuncionrio.setBounds(31, 85, 141, 14);
		frame.getContentPane().add(lblFuncionrio);
		
		inputFuncionario = new JTextField();
		inputFuncionario.setBounds(31, 110, 234, 30);
		frame.getContentPane().add(inputFuncionario);
		inputFuncionario.setColumns(10);
		
		JCheckBox chckbxFisicos = new JCheckBox("F\u00EDsicos");
		chckbxFisicos.setBounds(31, 252, 97, 23);
		frame.getContentPane().add(chckbxFisicos);
		
		JCheckBox chckbxBiologicos = new JCheckBox("Biol\u00F3gicos");
		chckbxBiologicos.setBounds(125, 252, 97, 23);
		frame.getContentPane().add(chckbxBiologicos);
		
		JCheckBox chckbxAcidentes = new JCheckBox("Acidentes");
		chckbxAcidentes.setBounds(224, 252, 97, 23);
		frame.getContentPane().add(chckbxAcidentes);
		
		JCheckBox chckbxQuimicos = new JCheckBox("Qu\u00EDmicos");
		chckbxQuimicos.setBounds(323, 252, 97, 23);
		frame.getContentPane().add(chckbxQuimicos);
		
		JCheckBox chckbxErgonomicos = new JCheckBox("Ergon\u00F4micos");
		chckbxErgonomicos.setBounds(422, 252, 97, 23);
		frame.getContentPane().add(chckbxErgonomicos);
		
		JLabel lblRiscos = new JLabel("Riscos:");
		lblRiscos.setBounds(31, 231, 46, 14);
		frame.getContentPane().add(lblRiscos);
		
		JLabel lblMedico = new JLabel("M\u00E9dico:");
		lblMedico.setBounds(31, 161, 46, 14);
		frame.getContentPane().add(lblMedico);
		
		inputMedico = new JTextField();
		inputMedico.setBounds(31, 186, 234, 30);
		frame.getContentPane().add(inputMedico);
		inputMedico.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Atestado cancelado...");
				frame.setVisible(false);
				frameAnterior.setVisible(true);
			}
		});
		btnCancelar.setBounds(124, 392, 141, 30);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(303, 392, 141, 30);
		frame.getContentPane().add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Atestado salvo com sucesso!");
				frame.setVisible(false);
				frameAnterior.setVisible(true);
			}
		});
		frame.setVisible(true);
	}
}
