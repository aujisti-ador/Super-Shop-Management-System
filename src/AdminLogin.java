import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField_user;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JPasswordField passwordField;
	private JButton btnResetPassword;
	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		//initialize();
		connection = sqliteConnection.dbConnector();
		setBounds(100, 100, 655, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_user = new JTextField();
		textField_user.setBackground(new Color(153, 255, 51));
		textField_user.setBounds(216, 162, 211, 44);
		contentPane.add(textField_user);
		textField_user.setColumns(10);
		
		AdminLogin frame = AdminLogin.this;
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
		btnLogin.setBackground(new Color(204, 0, 0));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AdminLogin frame = AdminLogin.this;
				try {
					String query = "select * from AdminLogin where Username=? and Password=?";
					PreparedStatement pst= connection.prepareStatement (query);
					pst.setString(1, textField_user.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while (rs.next())
					{
						count = count+1;
					} 
					if (count==1)
					{
						frame.dispose();
						JOptionPane.showMessageDialog(null, "Username & Password is correct");
						AdminPage adminpage = new AdminPage();
						adminpage.setVisible(true);
					}
					else if (count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username & Password\n Try again");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Username & Password is not correct");
					}
					rs.close();
					pst.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnLogin.setBounds(255, 277, 136, 51);
		contentPane.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 102, 51));
		passwordField.setBounds(216, 222, 211, 44);
		contentPane.add(passwordField);
		
		btnResetPassword = new JButton("Reset password");
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PwCngAdmin pwcngadmin = new PwCngAdmin();
				frame.dispose();
				pwcngadmin.setVisible(true);
			}
		});
		btnResetPassword.setBackground(new Color(255, 69, 0));
		btnResetPassword.setForeground(new Color(255, 255, 255));
		btnResetPassword.setBounds(255, 353, 136, 23);
		contentPane.add(btnResetPassword);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\free-login-form-psd.jpg"));
		label.setBounds(0, 0, 646, 448);
		contentPane.add(label);
	}
}
