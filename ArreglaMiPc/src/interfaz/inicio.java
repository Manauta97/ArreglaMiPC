package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class inicio extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
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
	public inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new BtnNewButtonMouseListener());
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\registro (1).png"));
		btnNewButton.setBounds(49, 367, 76, 73);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new BtnNewButton_1MouseListener());
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\vender.png"));
		btnNewButton_1.setBounds(180, 367, 97, 73);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\codigo (1).png"));
		lblNewLabel.setBounds(0, 0, 316, 196);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\67e7270116d00627ef4a393e915cd76f.jpg"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 316, 528);
		contentPane.add(lblNewLabel_1);
	}
	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			itfCliente itfc = new itfCliente();
			itfc.setVisible(true);
			dispose();
			
		}
	}
	private class BtnNewButton_1MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			itfarticulos itfa = new itfarticulos();
			itfa.setVisible(true);
			dispose();
		}
	}
}
