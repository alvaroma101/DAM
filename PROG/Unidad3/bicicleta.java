public class Bicicleta {

    private String marca;
    private String modelo;
    private int talla;

    //constructor por defecto
    public Bicicleta() {
    }
    //constructor con parámetros
    public Bicicleta(String m, String n, int t) {
        this.marca = m;
        this.modelo = n;
        this.talla = t;
    }
    
    //getters y setters
    public  String getMarca(){
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public long getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

	//métodos
	public void pedalear() {
		System.out.println("Pedaleando");
	}
	
	public  void frenar(){
        System.out.println("Frenando");
	}
		
	public  void girar(int direccion){ // 0 = izquierda; 1 = derecha
		if (direccion == 0) {
			System.out.println("Girando a la izquierda");
		} else if (direccion == 1) {
			System.out.println("Girando a la derecha");
		}
	}

	//toString
	public String toString(){
		return "marca: "+ marca + "\nmodelo" + modelo + "\ntalla: "+ talla;
	}
       
}

