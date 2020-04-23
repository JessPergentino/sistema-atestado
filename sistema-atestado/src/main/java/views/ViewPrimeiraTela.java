package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import util.LayoutPersonalizado;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewPrimeiraTela {
	
	private JFrame frame;
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		LayoutPersonalizado.determinarLayoutPersonalizado("Nimbus");
		frame = new JFrame();
		frame.setTitle("Menu");
		frame.setBounds(100, 100, 546, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu menuAtestado = new JMenu("Atestado");
		menuBar.add(menuAtestado);
		
		JMenuItem cadastrarAtestado = new JMenuItem("Cadastrar");
		cadastrarAtestado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarAtestados viewCadastroAtestado = new ViewCadastrarAtestados();
//				frame.setVisible(false);
//				frame.dispose();
				viewCadastroAtestado.initialize(frame);
				
			}
		});
		menuAtestado.add(cadastrarAtestado);
		
		JMenuItem VisualizarAtestado = new JMenuItem("Visualizar");
		menuAtestado.add(VisualizarAtestado);
		
		JMenu menuEmpresa = new JMenu("Empresa");
		menuBar.add(menuEmpresa);
		
		JMenuItem cadastrarEmpresa = new JMenuItem("Cadastrar");
		menuEmpresa.add(cadastrarEmpresa);
		
		cadastrarEmpresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewCadastrarEmpresas viewCadastroEmpresa = new ViewCadastrarEmpresas();
				viewCadastroEmpresa.initialize(frame);
				
			}
		});
		
		JMenuItem visualizarEmpresa = new JMenuItem("Visualizar");
		menuEmpresa.add(visualizarEmpresa);
		
		JMenu menuFuncionrio = new JMenu("Funcion\u00E1rio");
		menuBar.add(menuFuncionrio);
		
		JMenuItem cadastrarFuncionario = new JMenuItem("Cadastrar");
		menuFuncionrio.add(cadastrarFuncionario);
		
		JMenuItem visualizarFuncionario = new JMenuItem("Visualizar");
		menuFuncionrio.add(visualizarFuncionario);
		
		JMenu menuMdico = new JMenu("M\u00E9dico");
		menuBar.add(menuMdico);
		
		JMenuItem cadastrarMedico = new JMenuItem("Cadastrar");
		menuMdico.add(cadastrarMedico);
		
		JMenuItem visualizarMedico = new JMenuItem("Visualizar");
		menuMdico.add(visualizarMedico);
		
		JMenu menuRisco = new JMenu("Risco");
		menuBar.add(menuRisco);
		
		JMenuItem cadastrarRisco = new JMenuItem("Cadastrar");
		menuRisco.add(cadastrarRisco);
		
		JMenuItem visualizarRisco = new JMenuItem("Visualizar");
		menuRisco.add(visualizarRisco);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelecioneUmaOpo = new JLabel("Selecione uma op\u00E7\u00E3o do menu");
		lblSelecioneUmaOpo.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblSelecioneUmaOpo.setBounds(49, 82, 468, 159);
		frame.getContentPane().add(lblSelecioneUmaOpo);
		frame.setVisible(true);
	}

	
}
