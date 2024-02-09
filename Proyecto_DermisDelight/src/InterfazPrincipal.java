import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazPrincipal extends JFrame {
    private JButton editarPerfilButton;
    private JButton informacionEnvio;
    private JButton informacionButton;
    private JButton chatButton;

    public InterfazPrincipal() {
        // Configuración de la ventana principal
        setTitle("DermisDelight");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Componente del botón de perfil en la esquina superior izquierda
        JPanel usuarioPanel = new JPanel();
        usuarioPanel.setLayout(new BorderLayout()); // Usar BorderLayout para colocar el botón en la esquina
        editarPerfilButton = new JButton("Jonyys_");
        editarPerfilButton.setBackground(Color.PINK);
        usuarioPanel.add(editarPerfilButton, BorderLayout.WEST); // Colocar el botón en la esquina oeste (izquierda)
        add(usuarioPanel, BorderLayout.NORTH);

        // Componentes de la página principal
        JPanel botonesPanel = new JPanel(new GridBagLayout());
        informacionEnvio = new JButton("Información sobre tu paquete");
        informacionButton = new JButton("Información de Temporada");
        chatButton = new JButton("Chat AI");

        // Cambiar los colores de los botones
        informacionEnvio.setBackground(Color.PINK);
        informacionButton.setBackground(Color.PINK);
        chatButton.setBackground(Color.PINK);

        // Agregar acciones a los botones
        editarPerfilButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana con los datos del usuario
                DatosUsuario datosUsuario = new DatosUsuario();
                datosUsuario.setVisible(true);
            }
        });

        informacionEnvio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar mensaje sobre la información de envío
                JOptionPane.showMessageDialog(null, "Recibirás el paquete dentro de dos días antes de las 18 horas.");
            }
        });

        informacionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de información de temporada
                InformacionTemporada ventanaTemporada = new InformacionTemporada();
                ventanaTemporada.setVisible(true);
            }
        });

        chatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir ventana de chat
                ChatAI chatAI = new ChatAI();
                chatAI.setVisible(true);
            }
        });


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre los botones

        botonesPanel.add(informacionEnvio, gbc);

        gbc.gridy = 1;
        botonesPanel.add(informacionButton, gbc);

        gbc.gridy = 2;
        botonesPanel.add(chatButton, gbc);

        add(botonesPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}