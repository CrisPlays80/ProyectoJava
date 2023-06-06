package proyect;
import javax.swing.*;

public class User{
    private int idUser;
    private String password;

    public User(int idUser, String password){
        this.idUser = idUser;
        this.password = password;
    }

    public User(){
    }

    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public int getIdUser(){
        return idUser;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void mostrarInfo() {
        System.out.println(" Usuario: " + this.idUser + "\nContraseña: " + this.password);
    }

    public void mostrarInfo(boolean showInfo){
        String text = String.format("""
                Usuario: %d
                Contraseña: %s 
                """, this.idUser, this.password);
        JOptionPane.showMessageDialog(null, text, "Informacion", JOptionPane.INFORMATION_MESSAGE);
    }
}