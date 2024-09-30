import java.io.*;

public class Main {
    public static void main(String[] args) {
        String mensaje = "Está en casa";

        EscrituraDatos escrituraDatos = new EscrituraDatos();
        escrituraDatos.escribir(mensaje);

        LecturaDatos lecturaDatos = new LecturaDatos();
        lecturaDatos.leer(mensaje);
    }
}


class EscrituraDatos {

    public void escribir(String mensaje) {


        try (
                FileOutputStream fos = new FileOutputStream("/home/dam/Work/Clase/AccesoDatos/PrimitiveUtfChars/text6.txt", true);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos);
        ) {
            System.out.println("writeUTF escribindo: "+mensaje);
            dos.writeUTF(mensaje);
            System.out.println("bytes totais escritos: "+dos.size()+" bytes");

            System.out.println("writeChars escribindo: "+mensaje);
            dos.writeChars(mensaje);
            System.out.println("bytes totais escritos: "+dos.size()+" bytes");

            System.out.println("writeUTF escribindo: "+mensaje);
            dos.writeUTF(mensaje);
            System.out.println("bytes totais escritos: "+dos.size()+" bytes");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class LecturaDatos {

    public void leer(String mensaje) {

        String mensajeChar = "";

        try (
                FileInputStream fis = new FileInputStream("/home/dam/Work/Clase/AccesoDatos/PrimitiveUtfChars/text6.txt");
                BufferedInputStream bis = new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bis);
        ) {
            System.out.println("Bytes totais por ler: "+dis.available()+" bytes");
            System.out.println("Lemos a primeira cadea en UTF: "+dis.readUTF());

            System.out.println("Bytes totais por ler: " + dis.available() + " bytes");
            for (int i=0; i<mensaje.length(); i++){
                mensajeChar+=dis.readChar();
            }
            System.out.println("Lemos a segunda cadea en Chars: " + mensajeChar);

            System.out.println("Bytes totais por ler: "+dis.available()+" bytes");
            System.out.println("Lemos a segunda cadea en UTF: "+dis.readUTF());

            System.out.println("Bytes totais por ler: "+dis.available()+" bytes");
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
