import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class AdminPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldsrch;
	private JTextField textField_id;
	private JTextField textField_name;
	private JTextField textField_sname;
	private JTextField textField_contact;
	private JTextField textField_address;
	private JDesktopPane desktopPane;
	private JTextField textField_date;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection connection = null;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblAdminPanel;
	private JLabel label_2;
	//private JTextField textFieldsss1;

	/**
	 * Create the frame.
	 */
	public void refreshTable ()
	{
		try {
			String query = "select * from Billpay";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public AdminPage() {
		connection = sqliteConnection.dbConnector();
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\anyone.png"));
		setTitle("Admin Panel");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 734, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(266, 118, 442, 327);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int row = table.getSelectedRow();
					String id_=(table.getModel().getValueAt(row, 0)).toString();
					String query = "select * from Billpay where id='"+id_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while (rs.next())
							{
						textField_date.setText(rs.getString("date"));
						textField_id.setText(rs.getString("bill_id"));
						textField_name.setText(rs.getString("c_name"));
						textField_sname.setText(rs.getString("c_sname"));
						textField_contact.setText(rs.getString("c_contact"));
						textField_address.setText(rs.getString("c_address"));
							}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		textFieldsrch = new JTextField();
		textFieldsrch.setBackground(new Color(204, 255, 255));
		textFieldsrch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection= (String)comboBox.getSelectedItem();
					String query = "select *  from Billpay where "+selection+"=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textFieldsrch.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textFieldsrch.setBounds(526, 57, 182, 42);
		contentPane.add(textFieldsrch);
		textFieldsrch.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Microsoft YaHei", Font.BOLD, 13));
		comboBox.setForeground(new Color(153, 0, 0));
		comboBox.setBackground(new Color(153, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"bill_id", "c_name", "c_contact", "p_catagory", "date"}));
		comboBox.setBounds(599, 11, 109, 42);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Bill ID");
		lblNewLabel.setBounds(10, 136, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCustomerName = new JLabel("Name");
		lblCustomerName.setBounds(10, 175, 46, 14);
		contentPane.add(lblCustomerName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(10, 214, 46, 14);
		contentPane.add(lblSurname);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(10, 251, 46, 14);
		contentPane.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 292, 46, 14);
		contentPane.add(lblAddress);
		
		textField_id = new JTextField();
		textField_id.setBounds(85, 133, 86, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(85, 175, 86, 20);
		contentPane.add(textField_name);
		
		textField_sname = new JTextField();
		textField_sname.setColumns(10);
		textField_sname.setBounds(85, 211, 86, 20);
		contentPane.add(textField_sname);
		
		textField_contact = new JTextField();
		textField_contact.setColumns(10);
		textField_contact.setBounds(85, 248, 160, 20);
		contentPane.add(textField_contact);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(85, 289, 160, 47);
		contentPane.add(textField_address);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 165, 0));
		desktopPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Info", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane.setBounds(0, 116, 262, 232);
		contentPane.add(desktopPane);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 153, 255));
		btnNewButton.setFont(new Font("Levenim MT", Font.BOLD, 13));
		btnNewButton.setIcon(new ImageIcon("Icons\\edit.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query1 = "Update Billpay set bill_id='"+textField_id.getText()+"', c_name='"+textField_name.getText()+"' , c_sname='"+textField_sname.getText()+"' , c_contact='"+textField_contact.getText()+"', c_address='"+textField_address.getText()+"' where bill_id='"+textField_id.getText()+"' ";
					PreparedStatement pst = connection.prepareStatement(query1);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Edited");
					pst.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				refreshTable();
			}
		});
		btnNewButton.setBounds(10, 359, 113, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setIcon(new ImageIcon("Icons\\deletered.png"));
		btnNewButton_1.setFont(new Font("Levenim MT", Font.BOLD, 13));
		btnNewButton_1.setBackground(new Color(0, 153, 255));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Delete from Billpay where bill_id='"+textField_id.getText()+"'";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.execute();
					JOptionPane.showMessageDialog(null, "Data Deleted");
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				refreshTable();
			}
		});
		btnNewButton_1.setBounds(133, 359, 123, 42);
		contentPane.add(btnNewButton_1);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 255, 51)));
		desktopPane_1.setBackground(new Color(0, 102, 51));
		desktopPane_1.setBounds(0, 57, 182, 47);
		contentPane.add(desktopPane_1);
		
		textField_date = new JTextField();
		textField_date.setBounds(73, 11, 99, 20);
		desktopPane_1.add(textField_date);
		textField_date.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Euphemia", Font.BOLD, 13));
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setBounds(10, 9, 68, 24);
		desktopPane_1.add(lblDate);
		
		try {
			String query = "select * from Billpay";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("Icons\\man_brown.png"));
			label_1.setBounds(177, 0, 109, 116);
			contentPane.add(label_1);
			
			lblAdminPanel = new JLabel("Admin Panel");
			lblAdminPanel.setForeground(new Color(255, 255, 255));
			lblAdminPanel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
			lblAdminPanel.setBounds(286, 0, 197, 53);
			contentPane.add(lblAdminPanel);
			
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon("Icons\\find.png"));
			label_2.setBounds(522, 11, 67, 42);
			contentPane.add(label_2);
			
			label = new JLabel("");
			label.setVerticalAlignment(SwingConstants.BOTTOM);
			label.setIcon(new ImageIcon("Icons\\green-wallpaper-17318-17874-hd-wallpapers.jpg"));
			label.setBounds(0, 0, 718, 445);
			contentPane.add(label);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
}
