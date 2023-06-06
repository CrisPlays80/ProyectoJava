package proyect;
import javax.swing.*;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame{
    JPanel principal = new JPanel();
    ArrayList<Aerogenerador> aero = new ArrayList<Aerogenerador>();
    ArrayList<User> user = new ArrayList<User>();
    ArrayList<JTextField> camposRegistro = new ArrayList<JTextField>();
    ArrayList<JTextField> camposLogin = new ArrayList<JTextField>();
    private int cant_aero = 1;
    CardLayout cardLayout = new CardLayout();
    JLabel cantAero = new JLabel("Aerogenerador " + cant_aero);
    JPanel panel = new JPanel();
    JPanel loginPanel = new JPanel();
    JPanel results = new JPanel();

    public App(){
        principal.setLayout(cardLayout);
        principal.add(login(), "Login");
        principal.add(registroAerogenerador(), "Aerogeneradores");
        principal.add(results(), "Resultados");
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        cardLayout.show(principal, "Login");
        setContentPane(principal);
    }

    public JPanel registroAerogenerador(){

        JButton regButton = new JButton("Registro");
        regButton.setBounds(50, 440, 470, 80);
        regButton.setBackground(new Color(250, 193, 114));
        panel.setLayout(null);
        panel.setBackground(new Color(137, 213, 201));
        JLabel title = new JLabel("Sistema de control de Jepirachi");
            title.setBounds(180, 10, 1000, 72);
            title.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            title.setForeground(new Color(226, 91, 69));
        JLabel label1 = new JLabel("Id del aerogenerador ->");
            label1.setBounds(50, 110, 250, 20);
            label1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        JLabel label2 = new JLabel("Velocidad Punta de pala ->");
            label2.setBounds(50, 200, 250, 20);
            label2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        JLabel label3 = new JLabel("Velocidad del viento ->");
            label3.setBounds(50, 290, 250, 20);
            label3.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        JLabel label4 = new JLabel("Cantidad de energia mecanica ->");
            label4.setBounds(50, 380, 250, 20);
            label4.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        cantAero.setBounds(220, 70, 250, 20);
        cantAero.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            
        int y = 105;
        for (int i = 0; i < 4; i++) {
            JTextField textField1 = new JTextField();
            textField1.setBounds(320, y, 200, 30);
            textField1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            textField1.setBackground(new Color(177, 233, 231));
            camposRegistro.add(textField1);   
            panel.add(textField1); 
            y+=90;
        }
        
        camposLlenos(regButton);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        panel.add(title);
        panel.add(regButton);
        panel.add(cantAero);

        return panel;
    }
    
    
    public void camposLlenos(JButton regButton){
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean todosLlenos = true;
                //Pasa por cada campo y revisa si esta vacio, y si lo esta el booleano pasa a ser falso
                for (JTextField textField : camposRegistro) {
                    if (textField.getText().isEmpty()) {
                        todosLlenos = false;
                        break;
                    }
                }

                //Si no estan todos llenos sale un aviso de que debe completar todos los campos
                if (!todosLlenos) {
                    JOptionPane.showMessageDialog(App.this,
                            "Debe completar todos los campos",
                            "Campos vacíos",
                            JOptionPane.WARNING_MESSAGE);
                } 
                //Y si todos los campos estan llenos lanza una advertencia donde se confirmara si desea el usuario hacer el registro
                else {
                    int confirm = JOptionPane.showConfirmDialog(App.this,
                        "¿Estás seguro que deseas registrar el aerogenerador?",
                        "Confirmación de registro",
                        JOptionPane.YES_NO_OPTION);
                    //Si el usuario pone yes se hace el registro
                    if (confirm == JOptionPane.YES_OPTION) {
                        //Crea un nuevo registro y añade cada uno de sus datos
                        Aerogenerador n = new Aerogenerador();
                        n.setId(Integer.parseInt(camposRegistro.get(0).getText()));
                        n.setVelocidadPuntaPala(Float.parseFloat(camposRegistro.get(1).getText()));
                        n.setVelocidadViento(Float.parseFloat(camposRegistro.get(2).getText()));
                        n.setEnergiaMecanical(Float.parseFloat(camposRegistro.get(3).getText()));
                        float energiaProducto = (float) (Float.parseFloat(camposRegistro.get(3).getText()) * 0.375);
                        n.setEnergiaProduct(energiaProducto);

                        //Luego lo agrega en la lista de registros ya que se pueden guardar varios usuarios
                        aero.add(n);
                        JOptionPane.showMessageDialog(App.this,
                        "El aerogenerador id "+ camposRegistro.get(0).getText() + " ha sido registrado",
                        "Registrado",
                        JOptionPane.INFORMATION_MESSAGE);

                        cant_aero++;
                        if(cant_aero == 5){
                            cardLayout.show(principal, "Resultados");
                        }
                        cantAero.setText("Aerogenerador " + cant_aero);
                        for (JTextField textField : camposRegistro) {
                            textField.setText("");
                        }
                    }
                    //Si el usuario pone que NO quiere registrar el usuario pues solo le avisa que no se agrego
                    else{
                        JOptionPane.showMessageDialog(App.this,
                        "No se registro el aerogenerador",
                        "Registro no completado",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }  
        };
        regButton.addActionListener(l);   
    }

    public void camposLlenos(boolean process, JButton regButton){
        ActionListener l = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean todosLlenos = true;
                //Pasa por cada campo y revisa si esta vacio, y si lo esta el booleano pasa a ser falso
                for (JTextField textField : camposLogin) {
                    if (textField.getText().isEmpty()) {
                        todosLlenos = false;
                        break;
                    }
                }

                //Si no estan todos llenos sale un aviso de que debe completar todos los campos
                if (!todosLlenos) {
                    JOptionPane.showMessageDialog(App.this,
                            "Debe completar todos los campos",
                            "Campos vacíos",
                            JOptionPane.WARNING_MESSAGE);
                } 
                //Y si todos los campos estan llenos lanza una advertencia donde se confirmara si desea el usuario hacer el registro
                else {
                    int confirm = JOptionPane.showConfirmDialog(App.this,
                        "¿Estás seguro que deseas registrar el Usuario?",
                        "Confirmación de registro",
                        JOptionPane.YES_NO_OPTION);
                    //Si el usuario pone yes se hace el registro
                    if (confirm == JOptionPane.YES_OPTION) {
                        //Crea un nuevo registro y añade cada uno de sus datos
                        User n = new User(Integer.parseInt(camposLogin.get(0).getText()), camposLogin.get(1).getText());
                        Archivo a = new Archivo();
                        a.escribirArchivo(camposLogin.get(0).getText() + " " +camposLogin.get(1).getText());
                        //Luego lo agrega en la lista de registros ya que se pueden guardar varios usuarios
                        user.add(n);
                        
                        n.mostrarInfo(process);

                        cardLayout.show(principal, "Aerogeneradores");
                    }
                    //Si el usuario pone que NO quiere registrar el usuario pues solo le avisa que no se agrego
                    else{
                        JOptionPane.showMessageDialog(App.this,
                        "No se registro del usuario",
                        "Registro no completado",
                        JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }  
        };
        regButton.addActionListener(l);   
    }

    public JPanel login(){
        JButton regButton = new JButton("Register");
        loginPanel.setLayout(null);

        JLabel title = new JLabel("Sistema de control de Jepirachi");
            title.setBounds(180, 10, 1000, 72);
            title.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            title.setForeground(new Color(226, 91, 69));
        JLabel label1 = new JLabel("Digite su usuario ->");
            label1.setBounds(50, 160, 250, 20);
            label1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        JLabel label2 = new JLabel("Digite su contraseña ->");
            label2.setBounds(50, 310, 250, 20);
            label2.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
        
        regButton.setBounds(50, 420, 470, 80);
        regButton.setBackground(new Color(250, 193, 114));
        
        int y = 150;
        for (int i = 0; i < 2; i++) {
            JTextField textField1 = new JTextField();
            textField1.setBounds(320, y, 200, 30);
            textField1.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            textField1.setBackground(new Color(177, 233, 231));
            camposLogin.add(textField1);   
            loginPanel.add(textField1); 
            y+=150;
        }

        camposLlenos(true, regButton);
        loginPanel.add(regButton);
        loginPanel.add(label1); 
        loginPanel.add(label2);
        loginPanel.add(title);

        return loginPanel; 
    }
    String[] opciones = {"Mostrar info aerogeneradores", "Reporte de produccion", "Mayor aerogenerador que produjo", "Reparticion energetica"};
    JComboBox<String> comboBox = new JComboBox<String>(opciones);
    public JPanel results(){
        results.setLayout(null);
        results.setBackground(new Color(137, 213, 201));
        
        JLabel desc = new JLabel("En esta parte del programa usted podra ver los diferentes resultados, ");
            desc.setBounds(20, 50, 1000, 72);
            desc.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            desc.setForeground(Color.black);
        JLabel nextLine = new JLabel();
            nextLine.setText("que se generan por haber llenado los datos de cada aerogenerador");
            nextLine.setBounds(20, 65, 1100, 100);
            nextLine.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            nextLine.setForeground(Color.black);
        JLabel title = new JLabel("Sistema de control de Jepirachi");
            title.setBounds(180, 10, 1000, 72);
            title.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
            title.setForeground(new Color(226, 91, 69));

        
        comboBox.setBounds(20, 150, 250, 30);
        comboBox.setBackground(new Color(250, 193, 114));

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Resultados r = new Resultados();
                results.removeAll();
                results.revalidate();
                results.repaint();
                results.add(comboBox);
                results.add(title);
                results.add(desc);
                results.add(nextLine);
    
                int selectedIndex = comboBox.getSelectedIndex();
                switch (selectedIndex) {
                    case 0:
                        results.add(r.mostrarInfo(aero));
                        break;
                    case 1:
                        results.add(r.reporte(aero));
                        break;
                    case 2:
                        results.add(r.mayor(aero));
                        break;
                    case 3:
                        results.add(r.compute(aero));
                        break;
                    default:
                        break;
                }
            }
        });
    
        results.add(comboBox);
        results.add(title);
        results.add(desc);
        results.add(nextLine);
    
        return results;
    }

    public static void main(String[] args) throws Exception {
        App cambioDePanel = new App();
        cambioDePanel.setVisible(true);
    }
}
