import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.awt.event.*;

public class ChatAI extends JFrame {
    private JEditorPane chatArea;
    private JTextField mensajeField;

    public ChatAI() {
        setTitle("Chat AI");
        setSize(500, 500); // Aumentamos el tamaño verticalmente
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de chat (donde se mostrarán los mensajes)
        chatArea = new JEditorPane();
        chatArea.setEditable(false);
        chatArea.setContentType("text/html");
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Campo para escribir mensaje
        mensajeField = new JTextField("Escribe aquí tu mensaje");
        mensajeField.setPreferredSize(new Dimension(0, 50)); // Ajustamos la altura del JTextField
        mensajeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (mensajeField.getText().equals("Escribe aquí tu mensaje")) {
                    mensajeField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (mensajeField.getText().isEmpty()) {
                    mensajeField.setText("Escribe aquí tu mensaje");
                }
            }
        });
        mensajeField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enviarMensaje();
            }
        });
        JPanel messagePanel = new JPanel(new GridBagLayout()); // Creamos un panel para el JTextField
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        messagePanel.add(mensajeField, gbc);
        add(messagePanel, BorderLayout.SOUTH);
    }

    private void enviarMensaje() {
        String mensaje = mensajeField.getText();
        if (!mensaje.isEmpty() && !mensaje.equals("Escribe aquí tu mensaje")) {
            appendToPane(chatArea, "<b><font face=\"Arial\" size=\"3\" color=\"black\">TU:</font></b> " + mensaje + "<br>", Color.BLACK);
            mensajeField.setText("");
            responder(mensaje); // Pasar el mensaje al método responder
        }
    }

    private void responder(String mensaje) {
        String respuesta = obtenerRespuesta(mensaje);
        if (!respuesta.isEmpty()) {
            appendToPane(chatArea, "<b><font face=\"Arial\" size=\"5\" color=\"blue\">AI:</font></b> " + respuesta + "<br>", Color.BLUE);
        }
    }

    private String obtenerRespuesta(String mensaje) {
        // Ejemplo de respuestas basadas en reglas simples
        if (mensaje.contains("hola")) {
            return "¡Hola! ¿En qué puedo ayudarte?";
        } else if (mensaje.contains("cuando llegara el siguiente paquete")) {
            return "Recibirás tu paquete dentro de 2 días hábiles. Recibirás un SMS cuando esté de reparto.";
        } else if (mensaje.contains("como puedo cancelar mi cuenta")) {
            return "Si deseas cancelar tu cuenta puedes enviar un correo a la dirección atenciondermisdeligh@gmail.com";
        } else if (mensaje.contains("como puedo aprobar todas las asignaturas sin estudiar")) {
            return "Es fácil! ¡Sólo tendrás que regalar una pata de jamón a cada profesor!";
        } else {
            return "Lo siento, no entiendo tu pregunta.";
        }
    }

    private void appendToPane(JEditorPane pane, String msg, Color c) {
        HTMLDocument doc = (HTMLDocument) pane.getDocument();
        try {
            doc.insertAfterEnd(doc.getCharacterElement(doc.getLength()), "<font face=\"Arial\" size=\"5\" color=\"" + toHexString(c) + "\">" + msg + "</font>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toHexString(Color c) {
        return String.format("#%06x", c.getRGB() & 0xFFFFFF);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatAI().setVisible(true);
            }
        });
    }
}
