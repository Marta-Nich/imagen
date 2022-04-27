import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TransformaImagen {
    File f = null;

    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        try {
            boolean extension = false;
            String[] partes = fEnt.getAbsolutePath().split(".");
            if (partes[1].equals("bmp")) {
                extension = true;
            }
            if (fEnt.exists() && extension) {
                f = fEnt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
        try (FileInputStream f_in = new FileInputStream(f)) {
            FileOutputStream f_out = new FileOutputStream(f);
            byte[] metaDatos = new byte[54];
            int byt = f_in.read(metaDatos);
            while (byt != -1) {

            }
        }
    }

    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp

    }

    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
    }

    private String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        return "";
    }

}
