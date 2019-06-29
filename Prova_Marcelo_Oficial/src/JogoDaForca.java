
import java.util.Scanner;



public class JogoDaForca {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String teste;
        System.out.println("Palavra da rodada:");
        teste = ler.nextLine().toUpperCase();
        
        
        //lista de palavras
        String[] palavras = {teste};

        //quantidade de palavras
        int quantPalavras = palavras.length; // length: pega o tamanho do vetor

        //palavra sorteada
        String sorteada = (palavras[0]);

        
        char[] acertos = new char[sorteada.length()];// controlar os acertos do usu�rio... Cada letra im acerto
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

        String letrasUtilizadas = "";

        char letra;
        boolean ganhou = false;

        int tentativas = sorteada.length();

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        for (int i = 0; i < sorteada.length(); i++) {
            if(acertos[i] == 1){ //� um hifen
                System.out.println(" - ");
            }else{
                System.out.print(" _ ");
            }    
            }

                
                do{ // ! n�o  n�o falso = verdadeiro
                    System.out.println("\n"
                            + "Voc� tem " + tentativas + " tentativas"
                            + "\nLetras utilizadas: " + letrasUtilizadas
                            + "\nQual letra? (Voc� pode tentar a palavra)");
                    
                    
                    String digitado = ler.next().toUpperCase();
                    
                    if(digitado.length() > 1){
                        if(digitado.equals(sorteada)){
                            ganhou = true;
                            break;
                        }else{
                            tentativas = 0;
                            break;
                        }
                    } else{
                    
                    
                    letra = digitado.charAt(0); //pega a primeira letra
                    letrasUtilizadas += " " + letra;

                    boolean perdeTentativa = true;
                    for (int i = 0; i < sorteada.length(); i++) {
                        if (letra == sorteada.charAt(i)) { //charAt: ele pega a letra na posi��o i
                            acertos[i] = 1;
                            perdeTentativa = false;
                        }
                    }

                    if (perdeTentativa) { //se perdeTentativa for verdadeiro
                        tentativas--; //executa s� se o usu�rio n�o acertar a letra na rodada
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
                }while (!ganhou && tentativas > 0);
                
                if(tentativas != 0){
                System.out.println("\n\t *** O desgra�ado � um g�nio. Parab�ns ***");
                } else{
                System.out.println("\n\t *** Errroooouuu ***");    
                    System.out.println("\n\t A palavra era: "+ sorteada);
                }
            }
        }
