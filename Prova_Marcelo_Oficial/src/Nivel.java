import java.util.Scanner;

public class Nivel {
	public int escolheNivel() {
		int tentativas = 0;
		Scanner ler = new Scanner(System.in);
		int opcao;
		
		System.out.println("Escolha o n�vel que voc� deseja jogar: ");
		System.out.println("1 - F�cil");
		System.out.println("2 - M�dio");
		System.out.println("3 - Dif�cil");
		
		opcao = ler.nextInt();
		
		switch(opcao) {
		case 1:
			tentativas = 7;
			break;
		case 2:
			tentativas = 5;
			break;
		case 3:
			tentativas = 3;
			break;
		}
		
		return tentativas;
	}
}
