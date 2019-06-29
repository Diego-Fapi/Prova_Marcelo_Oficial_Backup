
public class Resultado {
	public String condicaoResultado(int tentativa, String sorteada) {
		
        
		String mensagem1 = "\n\t *** O desgraçado é um gênio. Parabêns ***";
		String mensagem2 = "\n\t *** Errrooouuuuuu ***"
							+ "\n\t A palavra era: " + sorteada;
		
        if(tentativa != 0){
        	return mensagem1;
        } else{
        	return mensagem2;
        }
    	}
	}
