public class Perro {

    private String nombre;
    private long chip;
    private int edad;

    
    
    //constructor por defecto
    public Perro() {
    }
    //constructor con parámetros
    public Perro(String n, long c, int e) {
        this.nombre = n;
        this.chip = c;
        this.edad = e;
    }
    
    //getters y setters
    public  String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getChip() {
        return chip;
    }

    public void setChip(long chip) {
        this.chip = chip;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

//métodos
public void ladrar() {
        System.out.println("Guau guau");
    }
public  void comer(){
        System.out.println("Nan ñan");
}

public  void dormir(){
        System.out.println("Zzzzzz");
}

//toString
public String toString(){
return "nombre: "+ nombre + "\nchip" + chip + "\nedad: "+ edad;
}
       
}

