import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class PwCngAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textOldu;
	private JTextField textOldpw;
	private JTextField passwordField_1;
	private JTextField txtUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PwCngAdmin frame = new PwCngAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public PwCngAdmin() {
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Current Username & Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		desktopPane.setBackground(new Color(0, 102, 255));
		desktopPane.setBounds(139, 11, 343, 88);
		contentPane.add(desktopPane);
		
		textOldu = new JTextField();
		textOldu.setColumns(10);
		textOldu.setBounds(10, 24, 150, 31);
		desktopPane.add(textOldu);
		
		textOldpw = new JTextField();
		textOldpw.setColumns(10);
		textOldpw.setBounds(200, 24, 133, 31);
		desktopPane.add(textOldpw);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		label_1.setBounds(10, 54, 105, 23);
		desktopPane.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		label_2.setBounds(200, 54, 105, 23);
		desktopPane.add(label_2);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "New Username & Password", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		desktopPane_1.setBackground(new Color(0, 102, 0));
		desktopPane_1.setBounds(139, 151, 343, 123);
		contentPane.add(desktopPane_1);
		
		passwordField_1 = new JTextField();
		passwordField_1.setColumns(10);
		passwordField_1.setBounds(130, 76, 178, 20);
		desktopPane_1.add(passwordField_1);
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("User Name");
		txtUsername.setColumns(10);
		txtUsername.setBounds(130, 22, 178, 31);
		desktopPane_1.add(txtUsername);
		
		JLabel label_3 = new JLabel("New Password");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		label_3.setBounds(10, 74, 100, 23);
		desktopPane_1.add(label_3);
		
		JLabel label_4 = new JLabel("New Username");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		label_4.setBounds(10, 25, 105, 23);
		desktopPane_1.add(label_4);
		
		PwCngAdmin frame = PwCngAdmin.this;
		
		JButton btnConfirm = new JButton("Change");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from AdminLogin where Username=? and Password=?";
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
						String query1 = "Update AdminLogin set Username='"+txtUsername.getText()+"' , Password='"+passwordField_1.getText()+"' where Username='"+textOldu.getText()+"' ";
						PreparedStatement pst1= connection.prepareStatement (query1);
						pst1.execute();
						JOptionPane.showMessageDialog(null, "Username & Password is Changed...!!!");
						pst1.close();
						
						frame.dispose();
						AdminPage adminpage = new AdminPage();
						adminpage.setVisible(true);
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
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Segoe UI Semilight", Font.BOLD, 15));
		btnConfirm.setBackground(new Color(255, 69, 0));
		btnConfirm.setBounds(253, 296, 121, 43);
		contentPane.add(btnConfirm);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\solid-color-wallpaper-21955-22508-hd-wallpapers.jpg"));
		label.setBounds(0, 0, 648, 366);
		contentPane.add(label);
	}

}
