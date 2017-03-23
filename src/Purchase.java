import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class Purchase extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField_cname;
	private JTextField textField_contact;
	private JTextField textField_csname;
	private JTextField textField_address;
	private JDesktopPane desktopPane;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblCatagory;
	private JLabel lblUnit;
	private JLabel lblPrice;
	private JTextField textField_name;
	private JTextField textField_catagory;
	private JTextField textField_unit;
	private JTextField textField_price;
	private JDesktopPane desktopPane_1;
	private JTable table;
	private JScrollPane scrollPane_1;
	private JTextField textSearchProducts;
	private JDesktopPane desktopPane_2;
	public static int billId = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JLabel label;
	/**
	 * Create the frame.
	 */
	public Purchase() {
		setResizable(false);
		connection=sqliteConnection.dbConnector();
		
		try{
			String query1 = "select max(bill_id) from Billpay";
			PreparedStatement pst1 = connection.prepareStatement(query1);
			ResultSet rs1=pst1.executeQuery();
			rs1.next();
			billId = Integer.valueOf(rs1.getString(1));
			billId++;
			pst1.execute();
			pst1.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		setBackground(new Color(204, 102, 51));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 723, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 0));
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPurchasStation = new JLabel("Purchas Station");
		lblPurchasStation.setForeground(new Color(255, 255, 255));
		lblPurchasStation.setIcon(new ImageIcon("Icons\\santa_s_bag.png"));
		lblPurchasStation.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblPurchasStation.setBounds(298, 0, 180, 62);
		contentPane.add(lblPurchasStation);
		
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblName.setBounds(21, 73, 54, 21);
		contentPane.add(lblName);
		
		textField_cname = new JTextField();
		textField_cname.setBounds(75, 74, 70, 20);
		contentPane.add(textField_cname);
		textField_cname.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblContact.setBounds(21, 107, 46, 14);
		contentPane.add(lblContact);
		
		textField_contact = new JTextField();
		textField_contact.setColumns(10);
		textField_contact.setBounds(75, 105, 150, 20);
		contentPane.add(textField_contact);
		
		textField_csname = new JTextField();
		textField_csname.setColumns(10);
		textField_csname.setBounds(155, 74, 70, 20);
		contentPane.add(textField_csname);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		lblAddress.setBounds(21, 143, 46, 14);
		contentPane.add(lblAddress);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(75, 141, 150, 20);
		contentPane.add(textField_address);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new TitledBorder(null, "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 50, 223, 118);
		contentPane.add(desktopPane);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		scrollPane.setBounds(10, 60, 223, 106);
		contentPane.add(scrollPane);
		
		lblCatagory = new JLabel("Catagory");
		lblCatagory.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
		lblCatagory.setBounds(21, 237, 54, 23);
		contentPane.add(lblCatagory);
		
		lblUnit = new JLabel("Unit");
		lblUnit.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
		lblUnit.setBounds(21, 271, 54, 23);
		contentPane.add(lblUnit);
		
		lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
		lblPrice.setBounds(21, 305, 54, 17);
		contentPane.add(lblPrice);
		
		textField_catagory = new JTextField();
		textField_catagory.setColumns(10);
		textField_catagory.setBounds(96, 238, 108, 20);
		contentPane.add(textField_catagory);
		
		textField_unit = new JTextField();
		textField_unit.setColumns(10);
		textField_unit.setBounds(96, 272, 108, 20);
		contentPane.add(textField_unit);
		
		textField_price = new JTextField();
		textField_price.setColumns(10);
		textField_price.setBounds(96, 303, 108, 20);
		contentPane.add(textField_price);
		
		textField_name = new JTextField();
		textField_name.setBounds(96, 208, 108, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 208, 54, 21);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Proxima Nova Rg", Font.PLAIN, 13));
		
		desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new TitledBorder(null, "Product Data", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		desktopPane_1.setBackground(Color.LIGHT_GRAY);
		desktopPane_1.setBounds(10, 189, 223, 157);
		contentPane.add(desktopPane_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(434, 144, 263, 300);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int row = table.getSelectedRow();
					String p_name_=(table.getModel().getValueAt(row, 1)).toString();
					String query = "select * from Product where p_name='"+p_name_+"' ";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					
					while (rs.next())
							{
								
								textField_name.setText(rs.getString("p_name"));
								textField_catagory.setText(rs.getString("p_catagory"));
								textField_price.setText(rs.getString("p_price"));
								textField_unit.setText(rs.getString("p_unit"));
							}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table);
		
		textSearchProducts = new JTextField();
		textSearchProducts.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					String selection= (String)comboBox.getSelectedItem();
					String query = "select *  from Product where "+selection+"=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textSearchProducts.getText());
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		textSearchProducts.setBounds(444, 93, 119, 37);
		contentPane.add(textSearchProducts);
		textSearchProducts.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Malgun Gothic", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"p_id", "p_name", "p_catagory"}));
		comboBox.setBounds(573, 93, 108, 37);
		contentPane.add(comboBox);
		
		JButton btnAddToCurt = new JButton("Add");
		btnAddToCurt.setBackground(Color.WHITE);
		btnAddToCurt.setIcon(new ImageIcon("Icons\\shopping_cart.png"));
		btnAddToCurt.setFont(new Font("Vrinda", Font.BOLD, 15));
		btnAddToCurt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					
					
					System.out.println("Bill id"+billId);
					String query = "insert into Billpay (id,bill_id,c_name,c_sname,c_contact,c_address,p_name,p_catagory,p_unit,p_price) values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					
					pst.setString(1, null);
					pst.setString(2, String.valueOf(billId));
					pst.setString(3, textField_cname.getText());
					pst.setString(4, textField_csname.getText());
					pst.setString(5, textField_contact.getText());
					pst.setString(6, textField_address.getText());
					pst.setString(7, textField_name.getText());
					pst.setString(8, textField_catagory.getText());
					pst.setString(9, textField_unit.getText());
					pst.setString(10, textField_price.getText());
					
					
					pst.execute();
					pst.close();
					
					JOptionPane.showMessageDialog(null, "Added to tha curt!");
					
					} catch (Exception e1) {
					e1.printStackTrace();
					}
				
			}
		});
		btnAddToCurt.setBounds(277, 222, 135, 66);
		contentPane.add(btnAddToCurt);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			
			Purchase frame = Purchase.this;
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				BillPage billPage = new BillPage();
				billPage.setVisible(true);
			}
			
		});
		btnNewButton.setForeground(new Color(0, 204, 0));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setIcon(new ImageIcon("Icons\\shop-icon.png"));
		btnNewButton.setBounds(10, 367, 223, 66);
		contentPane.add(btnNewButton);
		
		desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search Items", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		desktopPane_2.setBackground(UIManager.getColor("Button.shadow"));
		desktopPane_2.setBounds(434, 73, 263, 66);
		contentPane.add(desktopPane_2);
		try {
			String query = "select * from Product";
			PreparedStatement pst = connection.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnLoadProductData = new JButton("Load Products");
			btnLoadProductData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						String query = "select * from Product";
						PreparedStatement pst = connection.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnLoadProductData.setFont(new Font("Segoe Print", Font.BOLD, 12));
			btnLoadProductData.setBounds(562, 17, 135, 45);
			contentPane.add(btnLoadProductData);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon("Icons\\1.jpg"));
			label.setBounds(0, 0, 707, 463);
			contentPane.add(label);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
