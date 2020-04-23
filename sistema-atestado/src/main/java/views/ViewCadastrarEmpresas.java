package views;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCadastrarEmpresas {

	private JFrame frmCadastrarEmpresa;
	private JTextField textField;


	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize(JFrame frameAnterior) {
		frameAnterior.setVisible(false);
		frmCadastrarEmpresa = new JFrame();
		frmCadastrarEmpresa.setTitle("Cadastrar Empresa");
		frmCadastrarEmpresa.setBounds(100, 100, 670, 500);
		frmCadastrarEmpresa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastrarEmpresa.setLocationRelativeTo(null);
		frmCadastrarEmpresa.setResizable(false);
		frmCadastrarEmpresa.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 77, 46, 14);
		frmCadastrarEmpresa.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(10, 102, 221, 30);
		frmCadastrarEmpresa.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(10, 239, 46, 14);
		frmCadastrarEmpresa.getContentPane().add(lblCnpj);
		
		JFormattedTextField formattedTextField;
		try {
			formattedTextField = new JFormattedTextField(new MaskFormatter("##.###.###/####-##"));
			formattedTextField.setBounds(10, 264, 221, 30);
			frmCadastrarEmpresa.getContentPane().add(formattedTextField);
			
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(100, 395, 133, 23);
			frmCadastrarEmpresa.getContentPane().add(btnCancelar);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Empresa cancelada...");
					frmCadastrarEmpresa.setVisible(false);
					frameAnterior.setVisible(true);
				}
			});
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(386, 395, 133, 23);
			frmCadastrarEmpresa.getContentPane().add(btnConfirmar);
			btnConfirmar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Empresa salva com sucesso!");
					frmCadastrarEmpresa.setVisible(false);
					frameAnterior.setVisible(true);					
				}
			});
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frmCadastrarEmpresa.setVisible(true);
	}
}
