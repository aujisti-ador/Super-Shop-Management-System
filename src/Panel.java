import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class Panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
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
	public Panel() {
		setResizable(false);
		setType(Type.POPUP);
		setFont(new Font("Lucida Fax", Font.BOLD, 14));
		setTitle("Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 488);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 0, 0);
		contentPane.add(label);
		
		JButton btnNewButton_4 = new JButton("Help");
		btnNewButton_4.setForeground(new Color(128, 0, 0));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(0, 327, 145, 35);
		btnNewButton_4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help help = new Help();
				help.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Purchase");
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(0, 201, 145, 35);
		btnNewButton_2.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase purchase = new Purchase();
				purchase.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Employee List");
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 155, 145, 35);
		btnNewButton_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeInfo einfo = new EmployeeInfo();
				einfo.setVisible(true);
				
			}
		});
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(155, 106, 592, 354);
		label_2.setIcon(new ImageIcon("Icons\\1437265607286.jpg"));
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Product List");
		btnNewButton.setForeground(new Color(102, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 109, 145, 35);
		btnNewButton.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductList pl = new ProductList();
				pl.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Admin Page");
		btnNewButton_3.setForeground(new Color(128, 0, 0));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(0, 242, 145, 35);
		btnNewButton_3.setFont(btnNewButton_3.getFont().deriveFont(btnNewButton_3.getFont().getSize() + 3f));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin adminlogin = new AdminLogin();
				adminlogin.setVisible(true);
			}
		});
		contentPane.add(btnNewButton_3);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Quit");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(Color.RED);
		btnNewButton_5.setBounds(0, 389, 145, 25);
		btnNewButton_5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		contentPane.add(btnNewButton_5);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//frame.dispose();
					PwCngLogin  pwcnglogin = new PwCngLogin();
					pwcnglogin.setVisible(true);
					} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnChangePassword.setForeground(new Color(128, 0, 0));
		btnChangePassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnChangePassword.setBackground(Color.WHITE);
		btnChangePassword.setBounds(0, 288, 145, 35);
		contentPane.add(btnChangePassword);
		
		JLabel label_3 = new JLabel("");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setIcon(new ImageIcon("Icons\\f9ab3cd3d492197df7be5a99026468db.jpg"));
		label_3.setBounds(0, 0, 728, 472);
		contentPane.add(label_3);
	}
}
