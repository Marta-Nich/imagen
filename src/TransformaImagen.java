import java.io.File;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class TransformaImagen {
    File f = null;

    public TransformaImagen(File fEnt) {
        // Control de existencia del fichero y control de la extensión .bmp (sacar
        // mensajes de error)
        try {
            String file = fEnt.getAbsolutePath();
            if (fEnt.exists() && file.toLowerCase(Locale.ROOT).endsWith(".bmp")) {
                f = fEnt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transformaNegativo() throws IOException {
        // Transformar a negativo y guardar como *_n.bmp
        try (FileOutputStream f_out = new FileOutputStream(getNameFile() + "_n" + ".bmp")) {
            FileInputStream f_in = new FileInputStream(f);
            byte[] metaDatos = new byte[54];
            f_in.read(metaDatos);
            f_out.write(metaDatos);
            int data = 0;
            while (data != -1) {
                data = f_in.read();
                f_out.write(255 - data);
            }
        }
    }


    public void transformaOscuro() throws IOException {
        // Transformar a una imagen más oscura y guardar como *_o.bmp
        try (FileOutputStream f_out = new FileOutputStream(getNameFile() + "_o" + ".bmp")) {
            FileInputStream f_in = new FileInputStream(f);
            byte[] metaDatos = new byte[54];
            f_in.read(metaDatos);
            f_out.write(metaDatos);
            int data = 0;
            while (data != -1) {
                data = f_in.read();
                f_out.write(data / 2);
            }
        }
    }


    public void transformaBlancoNegro() throws IOException {
        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp
        try (FileOutputStream f_out = new FileOutputStream(getNameFile() + "_bn" + ".bmp")) {
            FileInputStream f_in = new FileInputStream(f);
            byte[] metaDatos = new byte[54];
            f_in.read(metaDatos);
            f_out.write(metaDatos);
            int r = 0;
            int g = 0;
            int b = 0;
            while (r != -1) {
                r = f_in.read();
                g = f_in.read();
                b = f_in.read();
                f_out.write((r + g + b) / 3);
                f_out.write((r + g + b) / 3);
                f_out.write((r + g + b) / 3);
            }
        }
    }

    private String getNameFile() {
        String partes[] = f.getAbsolutePath().split(".bmp");
        return partes[0];
    }

}
