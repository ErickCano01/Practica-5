package pract5;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		byte poon;
		int op;
		banco cuenta = new banco();
		Scanner tec = new Scanner(System.in);
		do {
			System.out.println("Eliga una opción: ");
			System.out.println("1. Crear cuenta.");
			System.out.println("2. Acceder a cuenta.");
			System.out.println("3. Salir.");
			op = tec.nextInt();
			switch(op) {
				case 1: cuenta.setCuenta(tec); break;
				case 2: poon = cuenta.iniciarSesion(tec);
						if(poon != -1)
							cuenta.lista(poon, tec);
						break;
							
				case 3: System.out.println("Salir"); break;                
			}
		}while(op != 3);	
		tec.close();	
	}
}
