package clases;

/*
* @author Raul Manauta
* @version 1.0
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class IoDatos {

	/*
	 * conexion a la base de datos
	 */
	private final String URL = "jdbc:mysql://localhost:3306/arreglapc";
	private final String USUARIO = "root";
	private final String PASSWORD = "castelseras";
	private Connection con;

	private void conectar() {
		try {
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void desconectar() {
		try {
			con.close();
			con = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void guardarClienteBBDD(Clientes vClientes) {
		conectar();
		PreparedStatement pt = null;

		try {

			pt = con.prepareStatement("INSERT INTO Clientes(nombre, dni) VALUES (?,?);");
			pt.setString(1, vClientes.getNombre());
			pt.setString(2, vClientes.getDni());

			pt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		desconectar();
	}

	public void guardarventaBBDD(Clientes vClientes, Articulos[] vArticulos) {

		conectar();
		PreparedStatement pt = null;

		try {

			pt = con.prepareStatement("INSERT INTO Ventas(nombre, codigo, coste) VALUES (?,?);");
			pt.setString(1, ((Clientes) vClientes).getNombre());
			pt.setString(2, vArticulos.toString());
			

			pt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		desconectar();
	}

	public static void guardarPers(ArrayList<Clientes> vClientes) {

		File f = new File("./datos/personas.dat");

		FileOutputStream fos = null;
		ObjectOutputStream os = null;

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				fos = new FileOutputStream(f);
				os = new ObjectOutputStream(fos);

				os.writeObject(vClientes);

			} catch (FileNotFoundException e) {
				// e.printStackTrace();
			} catch (IOException e) {
				// e.printStackTrace();
			} finally {
				try {
					os.close();
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public static void borrarPers(ArrayList<Clientes> vClientes, String nombre, String dni) {

		for (Clientes clientes : vClientes) {
			if (clientes.getNombre().equalsIgnoreCase(nombre) && clientes.getDni().equalsIgnoreCase(dni)) {

				clientes.setNombre("");
				clientes.setDni("");
			}
		}

	}

	public static Articulos[] cargarArticulos() {

		Articulos vArticulos[] = new Articulos[20];

		vArticulos[0] = new Articulos("A1-peine", 5);
		vArticulos[1] = new Articulos("A2-Tarjeta Grafica 4GB", 250);

		return vArticulos;

	}

	public static ArrayList<Clientes> cargarClientes(ArrayList<Clientes> vClientes) {

		File file = new File("./datos/personas.dat");

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vClientes;
		}
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
//				ois.readObject();
			vClientes = (ArrayList<Clientes>) ois.readObject();

		} catch (FileNotFoundException e) {
			// e.printStackTrace();
		} catch (IOException e) {
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}

		return vClientes;
	}
}
