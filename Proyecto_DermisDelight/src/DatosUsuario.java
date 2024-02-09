// Clase para la ventana de datos de usuario
import javax.swing.*;
import java.awt.*;

public class DatosUsuario extends JFrame {
    public DatosUsuario() {
        setTitle("Datos de Usuario");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        // Simulación de datos de usuario
        JLabel nombreLabel = new JLabel("Nombre completo: Jonathan Sánchez");
        JLabel nombreUsuario = new JLabel("Nombre de usuario: Jonnys_");
        JLabel direccionLabel = new JLabel("Dirección: Calle Libra 16, Móstoles");
        JLabel telefonoLabel = new JLabel("Teléfono: 609 118 385");
        JLabel correo = new JLabel("Correo eléctronico: jnysg16@gmail.com");
        JLabel premiumLabel = new JLabel("Suscripción Premium: Sí");

        add(nombreLabel);
        add(direccionLabel);
        add(nombreUsuario);
        add(telefonoLabel);
        add(correo);
        add(premiumLabel);
    }
}
