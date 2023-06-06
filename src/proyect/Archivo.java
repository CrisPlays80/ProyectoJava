package proyect;

import java.io.*;

import javax.swing.JOptionPane;

public class Archivo{
    public void escribirArchivo(String text){
        File archivo = new File("InfoUser.txt");
        try{
            FileWriter fileWriter = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escribir el contenido nuevo al archivo
            bufferedWriter.write(text);
            bufferedWriter.newLine();

            // Cerrar el BufferedWriter
            bufferedWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            JOptionPane.showMessageDialog(null, "Se ha añadido el usuario...", "Archivo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}