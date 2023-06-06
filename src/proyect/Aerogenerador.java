package proyect;

public class Aerogenerador{
    private float velocidadPuntaPala, velocidadViento, energiaMecanica, energiaProduct;    
    private int id;
    
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setVelocidadPuntaPala(float velocidadPuntaPala){
        this.velocidadPuntaPala = velocidadPuntaPala;
    }

    public float getVelocidadPuntaPala(){
        return velocidadPuntaPala;
    }

    public void setVelocidadViento(float velocidadViento){
        this.velocidadViento = velocidadViento;
    }

    public float getVelocidadViento(){
        return velocidadViento;
    }

    public void setEnergiaMecanical(float energiaMecanica){
        this.energiaMecanica = energiaMecanica; 
    }

    public float getEnergiaMecanica(){
        return energiaMecanica;
    }
  
    public void setEnergiaProduct(float energiaProduct){
        this.energiaProduct = energiaProduct;
    }

    public float getEnergiaProduct(){
        return energiaProduct;
    }
}