import java.util.Scanner;

public class Jogador {
	Scanner ler = new Scanner(System.in);
	String nome;
	
	
	public String inserirNome() {
		System.out.println("Antes de come�armos, digite o seu nome: ");
		nome = ler.nextLine();
		
		return nome;
	}
	
}
