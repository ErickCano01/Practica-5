package pract5;

public class cuenta {
	private String Nombre; 
	private double Dinero;
	private short pin;
	
	public cuenta(String Nombre, double Dinero, short pin) {
		this.Nombre = Nombre;
		this.Dinero = Dinero;
		this.pin = pin;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public void setDinero(double Dinero) {
		this.Dinero = Dinero;
	}
	public void setPin(short pin) {
		this.pin = pin;
	}
	public String getNombre() {
		return Nombre;
	}
	public double getDinero() {
		return Dinero;
	}
	public short getPin() {
		return pin;
	}
	
	public void setDeposito(double deposito) {
		if(deposito > 0)
			Dinero += deposito;
		else System.out.println("No es valido.");
	}
	public void setRetiro(double retiro) {
		if(retiro <= Dinero)
			Dinero -= retiro;
		else System.out.println("No es valido.");
	}
}
