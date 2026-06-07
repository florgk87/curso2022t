package tienda.vistas;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class FormHelper {

	public static JFrame createCategoriaFrame(String title, int width, int height) {
		JFrame frame = new JFrame();
		frame.setTitle(title != null ? title : "Gestion Categorías");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frame;
	}

	public static void addCategoriaFormComponents(Container panel, SpringLayout layout,
			JLabel idLabel, JLabel nombreLabel, JLabel descripcionLabel,
			JTextField idText, JTextField nombreText, JTextField descripcionText,
			JButton aceptarButton, JButton cancelarButton) {

		panel.setLayout(layout);

		panel.add(idLabel);
		panel.add(nombreLabel);
		panel.add(descripcionLabel);
		panel.add(idText);
		panel.add(nombreText);
		panel.add(descripcionText);
		panel.add(aceptarButton);
		panel.add(cancelarButton);
	}
}
