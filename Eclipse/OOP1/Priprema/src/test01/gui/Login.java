package test01.gui;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;


public class Login extends JFrame {

	private static final long serialVersionUID = -1671775066478081173L;
	private JTextField txtUser;
	private JTextField txtPassword;
	
	public Login() {
		setTitle("Demo application");
		setSize(358, 197);
		setLocation(300, 300);
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{116, 132, 141, 0};
		gridBagLayout.rowHeights = new int[]{61, 63, 197, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.ipady = 10;
		gbc_lblUser.weighty = 0.33;
		gbc_lblUser.anchor = GridBagConstraints.WEST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 0;
		gbc_lblUser.gridy = 0;
		getContentPane().add(lblUser, gbc_lblUser);
		
		txtUser = new JTextField();
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.ipady = 10;
		gbc_txtUser.gridwidth = 3;
		gbc_txtUser.insets = new Insets(0, 0, 5, 0);
		gbc_txtUser.weightx = 2.0;
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 1;
		gbc_txtUser.gridy = 0;
		getContentPane().add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.ipady = 10;
		gbc_lblPassword.weighty = 0.33;
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		getContentPane().add(lblPassword, gbc_lblPassword);
		
		txtPassword = new JTextField();
		GridBagConstraints gbc_txtPassword = new GridBagConstraints();
		gbc_txtPassword.ipady = 10;
		gbc_txtPassword.gridwidth = 2;
		gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassword.gridx = 1;
		gbc_txtPassword.gridy = 1;
		getContentPane().add(txtPassword, gbc_txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.ipady = 10;
		gbc_btnLogin.weighty = 5.0;
		gbc_btnLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogin.anchor = GridBagConstraints.WEST;
		gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
		gbc_btnLogin.gridx = 0;
		gbc_btnLogin.gridy = 2;
		getContentPane().add(btnLogin, gbc_btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Welcome, " + txtUser.getText(), "Welcome", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton btnRegister = new JButton("Register");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.ipady = 10;
		gbc_btnRegister.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegister.weightx = 1.0;
		gbc_btnRegister.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegister.anchor = GridBagConstraints.EAST;
		gbc_btnRegister.gridx = 2;
		gbc_btnRegister.gridy = 2;
		getContentPane().add(btnRegister, gbc_btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Proceed to registration", "Register", JOptionPane.PLAIN_MESSAGE);
			}
		});
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

}
