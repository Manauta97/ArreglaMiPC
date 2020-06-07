package interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.Clientes;
import clases.IoDatos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

public class itfCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtnombre;
	private JTextField txtdni;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private ArrayList<Clientes> vClientes;
	private JTextArea textArea;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					itfCliente frame = new itfCliente();
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
	public itfCliente() {
		//IoDatos.cargarClientes();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\codigo (1).png"));
		lblNewLabel.setBounds(0, 0, 175, 158);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(176, 22, 56, 28);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("DNI/CIF");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(176, 62, 56, 28);
		contentPane.add(lblNewLabel_2);

		txtnombre = new JTextField();
		txtnombre.setBounds(242, 27, 148, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);

		txtdni = new JTextField();
		txtdni.setColumns(10);
		txtdni.setBounds(242, 67, 148, 20);
		contentPane.add(txtdni);

		btnNewButton = new JButton("Volver");
		btnNewButton.addMouseListener(new BtnNewButtonMouseListener());
		btnNewButton.setBounds(290, 434, 100, 34);
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Dar de Alta");
		btnNewButton_1.addMouseListener(new BtnNewButton_1MouseListener());
		btnNewButton_1.setBounds(270, 111, 120, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Dar de Baja");
		btnNewButton_2.addMouseListener(new BtnNewButton_2MouseListener());
		btnNewButton_2.setBounds(265, 145, 125, 23);
		contentPane.add(btnNewButton_2);

		textArea = new JTextArea();
		textArea.setBounds(10, 194, 378, 219);
		contentPane.add(textArea);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\proyecto BBDD\\img\\67e7270116d00627ef4a393e915cd76f.jpg"));
		lblNewLabel_3.setBounds(0, 0, 398, 479);
		contentPane.add(lblNewLabel_3);

		iniciarjTextArea();
	}

	private class BtnNewButtonMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			inicio ini = new inicio();
			ini.setVisible(true);
			dispose();
		}
	}

	private class BtnNewButton_1MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			String patdni = "dddddddd[A-Z]";
			boolean concuerda = false;

			if (Pattern.matches(patdni, txtdni.getText())) {
				concuerda = true;
			} else {
				JOptionPane.showMessageDialog(null, "Dni mal introducido", "Dni mal introducido", 1);
			}

			Clientes cli = new Clientes(txtnombre.getText(), txtdni.getText());
			IoDatos.guardarPers(vClientes);
			JOptionPane.showMessageDialog(null, "Se Ha Guardado Con Exito", "Guardado Completado", 1);
			txtdni.setText("");
			txtnombre.setText("");
		}
	}

	private class BtnNewButton_2MouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			IoDatos.borrarPers(vClientes, txtnombre.getText(), txtdni.getText());
		}
	}

	private void iniciarjTextArea() {
		String texto = "";

		for (Clientes c : vClientes) {
			if (c != null) {
				texto += c.toString() + "\n";
			}

		}
		textArea.setText(texto);
	}
}
