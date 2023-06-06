package proyect;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Resultados{
    JLabel aeroLabel = new JLabel();
    JLabel velocidadPuntaPala = new JLabel();
    JLabel velocidadViento = new JLabel();
    JLabel energiaMecanica = new JLabel();
    JPanel resultados = new JPanel();

    public Resultados(){    
        resultados.setLayout(null);
        resultados.setBounds(0,100,600,600);
        resultados.setBackground(new Color(137, 213, 201));
        
    }

    public Container mostrarInfo(ArrayList<Aerogenerador> aeros){
        String[] opciones = {"Aerogenerador 1", "Aerogenerador 2", "Aerogenerador 3", "Aerogenerador 4"};

        JComboBox<String> aeroBox = new JComboBox<String>(opciones);
        aeroBox.setBounds(90, 90, 180, 20);
        resultados.add(aeroBox);

        aeroBox.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedIndex = aeroBox.getSelectedIndex();
                Aerogenerador selectedAero = aeros.get(selectedIndex);
                aeroLabel.setText("ID: "+Integer.toString(selectedAero.getId()));
                aeroLabel.setBounds(20, 120, 1000, 100);
                aeroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

                velocidadPuntaPala.setText("Velocidad Punta de Pala: " + Float.toString(selectedAero.getVelocidadPuntaPala()));
                velocidadPuntaPala.setBounds(20, 150, 1000, 100);
                velocidadPuntaPala.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

                velocidadViento.setText("Velocidad Viento: " + Float.toString(selectedAero.getVelocidadViento()));
                velocidadViento.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
                velocidadViento.setBounds(20, 180, 1000, 100);

                energiaMecanica.setText("Energia Producida apartir de la energia mecanica: " + Float.toString(selectedAero.getEnergiaProduct()));
                energiaMecanica.setBounds(20, 210, 1000, 100);
                energiaMecanica.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

                resultados.add(aeroLabel);
                resultados.add(velocidadPuntaPala);
                resultados.add(velocidadViento);
                resultados.add(energiaMecanica);
            }
        });
        
        return resultados;
    }

    public JPanel reporte(ArrayList<Aerogenerador> aeros){
        String[] opciones = {"Aerogenerador 1", "Aerogenerador 2", "Aerogenerador 3", "Aerogenerador 4"};

        JComboBox<String> aeroBox = new JComboBox<String>(opciones);
        aeroBox.setBounds(90, 90, 180, 20);
        resultados.add(aeroBox);

        aeroBox.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int selectedIndex = aeroBox.getSelectedIndex();
                Aerogenerador selectedAero = aeros.get(selectedIndex);

                aeroLabel.setText("Se produjo un total de " + selectedAero.getEnergiaProduct());
                aeroLabel.setBounds(20, 120, 1100, 100);
                aeroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

                resultados.add(aeroLabel);

            }
        });


        return resultados;
    }

    public JPanel mayor(ArrayList<Aerogenerador> aeros){
        float maximo = Float.MIN_VALUE;
        int id = 0;
        JLabel nextLine = new JLabel();
        for (Aerogenerador numero : aeros) {
            if (numero.getEnergiaProduct() > maximo) {
                maximo = numero.getEnergiaProduct();
                id = numero.getId();
            }
        }
        aeroLabel.setText("El aerogenerado de mayor produccion energetica es el " + id);
        aeroLabel.setBounds(20, 120, 1100, 100);
        aeroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        nextLine.setText("Con una produccion de "+ maximo + " J");
        nextLine.setBounds(20, 160, 1100, 100);
        nextLine.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

        resultados.add(aeroLabel);
        resultados.add(nextLine);

        return resultados;
    }

    public JPanel compute(ArrayList<Aerogenerador> aeros){
        float total = 0;
        JLabel nextLine1 = new JLabel();
        JLabel nextLine2 = new JLabel();
        JLabel nextLine3 = new JLabel();
        JLabel nextLine4 = new JLabel();
        JLabel nextLine5 = new JLabel();

        for (Aerogenerador aerogenerador : aeros) {
            total += aerogenerador.getEnergiaProduct();
        }

        nextLine1.setText("Los 4 aerogenerdores en su produccion energetica generaron: " + total);
        nextLine1.setBounds(20, 120, 1100, 100);
        nextLine1.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

        nextLine2.setText("Se tiene ciertos porcentajes de reparticion ");
        nextLine2.setBounds(20, 160, 1100, 100);
        nextLine2.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        
        nextLine5.setText("casas(55%), alumbrados(25%), edificaciones publicas(20%)");
        nextLine5.setBounds(20, 200, 1100, 100);
        nextLine5.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        
        aeroLabel.setText("Para las casas de la Guajira es de: " + total*0.55);
        aeroLabel.setBounds(20, 240, 1100, 100);
        aeroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        
        nextLine3.setText("Para los alumbrados es de: "+ total * 0.25);
        nextLine3.setBounds(20, 280, 1100, 100);
        nextLine3.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        
        nextLine4.setText("Para edificaciones publicas es de: "+ total * 0.20);
        nextLine4.setBounds(20, 320, 1100, 100);
        nextLine4.setFont(new Font("Yu Gothic", Font.PLAIN, 20));

        resultados.add(aeroLabel);
        resultados.add(nextLine1);
        resultados.add(nextLine2);
        resultados.add(nextLine3);
        resultados.add(nextLine4);
        resultados.add(nextLine5);

        return resultados;
    }
}