package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Articulos;
import clases.IoDatos;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class itfarticulos extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox;
	private JComboBox comboBox_A;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private DefaultComboBoxModel listaArticulos;
	private Articulos[] vArticulos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itfarticulos frame = new itfarticulos();
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
	public itfarticulos() {
		IoDatos.cargarArticulos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\codigo (1).png"));
		lblNewLabel.setBounds(0, 0, 342, 160);
		contentPane.add(lblNewLabel);

		btnNewButton = new JButton("Aceptar compra");
		btnNewButton.setBounds(162, 366, 132, 34);
		contentPane.add(btnNewButton);

		lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(52, 199, 56, 28);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Articulo");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(52, 264, 56, 28);
		contentPane.add(lblNewLabel_2);

		comboBox = new JComboBox();
		comboBox.setBounds(142, 204, 152, 20);
		contentPane.add(comboBox);

		comboBox_A = new JComboBox();
		comboBox_A.addMouseListener(new ComboBox_AMouseListener());
		listaArticulos = new DefaultComboBoxModel<>();
		comboBox_A.setModel(listaArticulos);
		comboBox_A.setBounds(142, 269, 152, 20);
		contentPane.add(comboBox_A);

		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addMouseListener(new BtnNewButton_1MouseListener());
		btnNewButton_1.setBounds(205, 432, 89, 23);
		contentPane.add(btnNewButton_1);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\67e7270116d00627ef4a393e915cd76f.jpg"));
		lblNewLabel_3.setBounds(0, 0, 325, 498);
		contentPane.add(lblNewLabel_3);
		
	}

	private class BtnNewButton_1MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			inicio ini = new inicio();
			ini.setVisible(true);
			dispose();
		}
	}

	private class ComboBox_AMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			for (Articulos ar : vArticulos) {
				if (ar != null) {
					listaArticulos.addElement(ar.getCodigoArticulo());
				}
			}

		}
	}

}
