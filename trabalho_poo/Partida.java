import java.util.Set;
import java.util.HashSet;

public class Partida {
    private String palavraSecreta;
    private Integer tentativas;

    public Partida(String palavraSecreta){
        tentativas = 6;
        this.palavraSecreta = palavraSecreta;
    }

    public String getPalavraSecreta(){
        return palavraSecreta;
    }

    public Boolean PalavraEncontrada(String palavra){
        return palavraSecreta.equals(palavra);
    }   

    public void decrementarTentativas(){
        tentativas--;
    }

    public Integer getTentativas(){
        return tentativas;
    }

    public Boolean fimDeJogo(){
        return tentativas == 0;
    }

    public String retornarFeedback(String chute){
        StringBuilder sb = new StringBuilder("*****");
        Set<String> ocorrencias = new HashSet<>();
        for (int i = 0; i < 5; i++){
            if (chute.charAt(i) == palavraSecreta.charAt(i)){
                sb.setCharAt(i, '+');
                ocorrencias.add(String.valueOf(chute.charAt(i)));
            }
        }
        for (int i = 0; i < 5; i++){
            if (palavraSecreta.contains(String.valueOf(chute.charAt(i))) 
            && !ocorrencias.contains(String.valueOf(chute.charAt(i)))){ // irá contabilizar apenas a primeira ocorrência da letra
                sb.setCharAt(i, '-');
                ocorrencias.add(String.valueOf(chute.charAt(i)));
            }
        }
        return sb.toString();
    }
}
