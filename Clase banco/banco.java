package pract5;

import java.util.Scanner;

public class banco {
	private String Nombre; 
	private double Dinero;
	private short pin; 
	private static byte i = 0; 
	private cuenta[] usu = new cuenta[10]; 
	
	public void setCuenta(Scanner tec) {
		if(i == 10) {
			System.out.println("Ya tiene el limite de cuentas");
			return;
		}
		tec.nextLine();
		System.out.println("Ingrese su nombre: ");
		Nombre = tec.nextLine();
		do {
			System.out.println("Ingrese la cantidad de dinero para abrir su cuenta: ");
			Dinero = tec.nextDouble();
		}while(Dinero <= 0);
		do {
			System.out.println("Ingrese su PIN (4 dígitos): ");
			pin = tec.nextShort();
		}while(pin < 1000 || pin > 9999);		
		usu[i++] = new cuenta(Nombre, Dinero, pin); 
	}
	public byte iniciarSesion(Scanner tec) {
		if(i == 0) {
			System.out.println("No se ha creado ninguna cuenta.");
			return -1;
		}
		boolean cuentaExiste = false; 
		byte j = -1;
		tec.nextLine();
		System.out.println("Ingresar su nombre: ");
		Nombre = tec.nextLine();
		System.out.println("Ingrese su PIN: ");
		pin = tec.nextShort();
		while(!cuentaExiste && ++j != i) {
			if(pin == usu[j].getPin())
				cuentaExiste = true;
		}
		if( cuentaExiste && Nombre.equals(usu[j].getNombre()) ) 
			return j;
		else System.out.println("Intente nuevamente.");
		return -1; 
	}
	public void lista(byte poon, Scanner tec) {
		int op; 		
		do {
			System.out.println("Cuenta:" + usu[poon].getNombre());
			System.out.println("1. Depósito.");
			System.out.println("2. Retiro.");
			System.out.println("3. Estado de cuenta.");
			System.out.println("4. Cerrar sesión.");
			op = tec.nextInt();
			switch(op) {
				case 1: System.out.println("Cantidad a depositar: ");
						Dinero = tec.nextDouble();
						usu[poon].setDeposito(Dinero);
						break;
				case 2: System.out.println("Ingresa la cantidad a retirar: ");
						Dinero = tec.nextDouble();
						usu[poon].setRetiro(Dinero);
						break;
				
				case 3: getCuenta(poon);
			}
		}while(op != 4);
	}
	private void getCuenta(byte poon) {
		System.out.println("Nombre: " + usu[poon].getNombre());
		System.out.println("Dinero: $" + usu[poon].getDinero());
		System.out.println("PIN: " + usu[poon].getPin());
	}
}
