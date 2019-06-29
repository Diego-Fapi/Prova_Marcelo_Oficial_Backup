
import java.util.Scanner;



public class JogoDaForca{

	
	
    public static void main(String[] args) {
    	Scanner ler = new Scanner(System.in);
    	Jogador jogador = new Jogador();
    	Nivel nivel = new Nivel();
    	Resultado resultado = new Resultado();
    	String palavraRodada;
    	String letrasUtilizadas = "";
    	char letra;
        boolean ganhou = false;
        int tentativa;
    	
    	
        
        
        
        jogador.inserirNome();
        
        
        System.out.println("Palavra da rodada:");
       	palavraRodada = ler.nextLine().toUpperCase(); //Pega a palavra da rodada e coloca ela em caixa alta
        
        String[] palavras = {palavraRodada}; //lista de palavras
        
        String sorteada = (palavras[0]); //Pega a palavra que o jogador digitou no indice zero

        char[] acertos = new char[sorteada.length()];// controlar os acertos do usu�rio... Cada letra um acerto
        //B A N A N A -> palavra
        //0 1 2 3 4 5 -> posi��o
        //digitei A
        //0 1 0 1 0 1 -> acerto
        for (int i = 0; i < acertos.length; i++) {
            acertos[i] = 0;
            if(sorteada.charAt(i) == '-'){
                acertos[i] = 1;
            }
        }

        

        tentativa = nivel.escolheNivel();
        System.out.print(tentativa);
        
		
        for (int i = 0; i < sorteada.length(); i++) {
            if(acertos[i] == 1){ //� um hifen
                System.out.println(" - ");
            }else{
                System.out.print(" _ ");
            	}    
            }

                
                do{
                    System.out.println("\n"
                            + "Voc� tem " + tentativa + " tentativas"
                            + "\nLetras utilizadas: " + letrasUtilizadas
                            + "\nQual letra? (Voc� pode tentar a palavra)");
                    
                    String digitado = ler.next().toUpperCase(); //Aqui � caso o jogador queira digitar a palavra inteira
                    
                    if(digitado.equals("0")) {
                    	System.out.println("Sabe o que falta em voc�? Coragem para continuar o jogo");
                    	System.exit(0);
                    }
                    
                    if(digitado.length() > 1){
                        if(digitado.equals(sorteada)){ //Caso a palavra digitada seja igual a palavra da rodada, 
                            ganhou = true; //Eu ganho o jogo
                            break;
                        }else{
                            tentativa = 0; //Sen�o eu perco
                            break;
                        }
                    } else{
                    
                    
                    letra = digitado.charAt(0); //pega a primeira letra ---- � aqui que eu recebo as letras que eu digito
                    	
                    letrasUtilizadas += " " + letra; // Aqui mostra as letras j� utilizadas
                    
                    

                    boolean perdeTentativa = true; //Come�a como se eu estivesse perdido uma rodada
                    for (int i = 0; i < sorteada.length(); i++) {
                        if (letra == sorteada.charAt(i)) { //charAt: ele pega a letra na posi��o i
                            acertos[i] = 1;
                            perdeTentativa = false; //Acertei a letra, ent�o n�o perdi nenhuma tentativa
                        }
                    }

                    if (perdeTentativa) { //se perdeTentativa for verdadeiro, ou seja, errei uma letra
                        tentativa--; //executa s� se o usu�rio n�o acertar a letra na rodada
                    }

                    System.out.print("\n");
                    ganhou = true; //digo que o usu�rio pode ter ganho
                    for (int i = 0; i < sorteada.length(); i++) {
                        if (acertos[i] == 0) {
                            System.out.print(" _ ");
                            ganhou = false; //se existir algum acerto[i] == 0 (alguma letra que n�o acertou)
                                            //eu digo que ele n�o ganhou
                        } else {
                            System.out.print(" " + sorteada.charAt(i) + "");
                        }
                    }
                  }
                    
                    System.out.print("\n");
                }while (!ganhou && tentativa > 0);
                
                
                
                System.out.println(resultado.condicaoResultado(tentativa,sorteada)); //Mostra se eu ganhei eu perdi
        }
}
