import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;

public class PwCngLogin extends JFrame {
	private JTextField txtUsername;
	private JLabel lblUsername;
	private JLabel lblNewPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwCngLogin frame = new PwCngLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField textOldu;
	private JTextField passwordField_1;
	private JTextField textOldpw;

	/**
	 * Create the frame.
	 */
	public PwCngLogin() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		connection=sqliteConnection.dbConnector();
		setTitle("Reset Password");
		setBounds(100, 100, 622, 401);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		PwCngLogin frame = PwCngLogin.this;
		
		JButton btnConfirm = new JButton("Change");
		btnConfirm.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		btnConfirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String query = "select * from Login where Username=? and Password=?";
					PreparedStatement pst= connection.prepareStatement (query);
					pst.setString(1, textOldu.getText());
					pst.setString(2, textOldpw.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while (rs.next())
					{
						count = count+1;
					} 
					if (count==1)
					{	
						String query1 = "Update Login set Username='"+txtUsername.getText()+"' , Password='"+passwordField_1.getText()+"' where Username='"+textOldu.getText()+"' ";
						PreparedStatement pst1= connection.prepareStatement (query1);
						pst1.execute();
						JOptionPane.showMessageDialog(null, "Username & Password is Changed...!!!");
						pst1.close();
						frame.dispose();
					}
					else if (count>1)
					{
						JOptionPane.showMessageDialog(null, "Duplicate Username & Password...!\n Try again");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Username and Password is Wrong...!!!");
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnConfirm.setBackground(new Color(255, 69, 0));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBounds(241, 263, 121, 43);
		getContentPane().add(btnConfirm);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 102, 255));
		desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Current Username & Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		desktopPane.setBounds(117, 11, 343, 88);
		getContentPane().add(desktopPane);
		
		textOldu = new JTextField();
		textOldu.setBounds(10, 24, 150, 31);
		desktopPane.add(textOldu);
		textOldu.setColumns(10);
		
		textOldpw = new JTextField();
		textOldpw.setBounds(200, 24, 133, 31);
		desktopPane.add(textOldpw);
		textOldpw.setColumns(10);
		
		JLabel lblCurrentusername = new JLabel("Username");
		lblCurrentusername.setForeground(Color.WHITE);
		lblCurrentusername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblCurrentusername.setBounds(10, 54, 105, 23);
		desktopPane.add(lblCurrentusername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblPassword.setBounds(200, 54, 105, 23);
		desktopPane.add(lblPassword);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "New Username & Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		desktopPane_1.setBackground(new Color(0, 102, 0));
		desktopPane_1.setBounds(117, 129, 343, 123);
		getContentPane().add(desktopPane_1);
		
		passwordField_1 = new JTextField();
		passwordField_1.setBounds(130, 76, 178, 20);
		desktopPane_1.add(passwordField_1);
		passwordField_1.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(130, 22, 178, 31);
		desktopPane_1.add(txtUsername);
		txtUsername.setToolTipText("User Name");
		txtUsername.setColumns(10);
		
		lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(10, 74, 100, 23);
		desktopPane_1.add(lblNewPassword);
		lblNewPassword.setForeground(Color.WHITE);
		lblNewPassword.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		lblUsername = new JLabel("New Username");
		lblUsername.setBounds(10, 25, 105, 23);
		desktopPane_1.add(lblUsername);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		
		JLabel label = new JLabel("");
		label.setForeground(new Color(0, 0, 0));
		label.setIcon(new ImageIcon("Icons\\Dark_Red_Background_by_Vik_for_Stuff.png"));
		label.setBounds(0, 0, 616, 373);
		getContentPane().add(label);

	}
}
