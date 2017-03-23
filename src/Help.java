import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

public class Help extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help frame = new Help();
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
	public Help() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Icons\\Administrator-icon.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 741, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Icons\\rsz_1texture_288_by_sirius_sdz-d5cdbsb_copy_copy.jpg"));
		label_1.setBounds(10, 128, 219, 178);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Icons\\LadyHoldingHELPsign.jpg"));
		label.setBounds(207, 0, 392, 122);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Developer", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBounds(273, 146, 266, 108);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtrFazleRabbiAdor = new JTextArea();
		txtrFazleRabbiAdor.setEditable(false);
		txtrFazleRabbiAdor.setBounds(6, 16, 241, 78);
		panel.add(txtrFazleRabbiAdor);
		txtrFazleRabbiAdor.setFont(new Font("Century Gothic", Font.BOLD, 13));
		txtrFazleRabbiAdor.setText("Fazle Rabbi Ador\r\nEmail: aujisti.ador@gmail.com\r\nDepartment of CSE.\r\nDaffodil International University.");
		
		JLabel lblName = new JLabel("imageback");
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setIcon(new ImageIcon("Icons\\Green-Grass-On-White-Background.-Matte-Channel..jpg"));
		lblName.setBounds(0, 0, 725, 439);
		contentPane.add(lblName);
	}
}
