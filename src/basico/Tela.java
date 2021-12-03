package basico;

import java.util.Scanner;

public class Tela {

	protected  Scanner scan;
	
	public final Scanner abrirScan() {
		this.scan = new Scanner(System.in);
		return this.scan;
	}
	
	public final void print(String texto) {
		System.out.println(texto);
	}
	
	public Integer lerInt() {
		String texto = scan.nextLine();
		return Integer.parseInt(texto.trim());
	}
	
	public final Double lerDouble() {
		String texto = scan.nextLine();
		return Double.parseDouble(texto.trim());
	}
	
}
