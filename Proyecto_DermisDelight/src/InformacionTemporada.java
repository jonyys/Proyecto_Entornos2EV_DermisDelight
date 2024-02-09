import javax.swing.*;
import java.awt.*;
import java.io.File;

public class InformacionTemporada extends JFrame {
    public InformacionTemporada() {
        setTitle("Información de Temporada");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear un JTextPane para mostrar la información
        JTextPane informacionText = new JTextPane();
        informacionText.setEditable(false);
        informacionText.setContentType("text/html"); // Establecer el tipo de contenido HTML

        // Texto con formato HTML para mostrar la información
        String informacion = "<html><body>" +
                "<b>Información sobre productos de temporada:</b><br><br>" +
                "<b>- Crema Ve:</b> La Crema Hidratante CeraVe es una crema hidratante rica, no grasa y de rápida absorción para pieles Secas a muy secas del rostro y el cuerpo. Formuladcon tres ceramidas esenciales y Ácido Hialurónico, actúa para retener la humedad y ayudar a mantener la barrera protectora de la piel. Desarrollada con dermatólogos, esta crema cuenta con la Tecnología patentada MVE que mantiene la piel hidratada durante 24 horas. Apta para piel seca a muy seca, piel irritada, Con picor, o Con tendencia atópica.<br><br>" +
                "<b>- Base NYX:</b> ideal para conseguir una piel suave y unificada. Es de fácil aplicación y deja a la piel una apariencia suave y más difuminada. Su textura es ligera y no grasa, con lo que ayuda a controlar el brillo, ofreciendo una cobertura media modulable con un acabado mate, difuminado, que te proporcionará 12 horas de hidratación.<br><br>" +
                "<b>- Pack especial:</b> Pack especial de maquillaje de larga duración. Es completamente personalizable, elige tus productos favoritos y hazte un look a tu manera." +
                "</body></html>";

        informacionText.setText(informacion);

        // Colocar el JTextPane en un JScrollPane para permitir el desplazamiento
        JScrollPane scrollPane = new JScrollPane(informacionText);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Agregar el JScrollPane al centro de la ventana
        add(scrollPane, BorderLayout.CENTER);

        JPanel imagenesPanel = new JPanel();
        imagenesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Obtener la ruta de la carpeta de imágenes
        String carpetaImagenes = "imagenes" + File.separator;

        // Cargar imágenes
        ImageIcon iconoProducto1 = new ImageIcon(carpetaImagenes + "crema.jpg");
        ImageIcon iconoProducto2 = new ImageIcon(carpetaImagenes + "nyx.jpg");
        ImageIcon iconoProducto3 = new ImageIcon(carpetaImagenes + "pack.jpg");

        // Crear JLabels para las imágenes
        JLabel labelProducto1 = new JLabel(iconoProducto1);
        JLabel labelProducto2 = new JLabel(iconoProducto2);
        JLabel labelProducto3 = new JLabel(iconoProducto3);

        // Agregar los JLabels al panel de imágenes
        imagenesPanel.add(labelProducto1);
        imagenesPanel.add(labelProducto2);
        imagenesPanel.add(labelProducto3);

        // Agregar el panel de imágenes al sur de la ventana
        add(imagenesPanel, BorderLayout.SOUTH);
    }
}
