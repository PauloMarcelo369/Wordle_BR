public class ControaladorDeJogo {
    private DicionarioDePalavras dc;
    private Partida partida;

    public ControaladorDeJogo(){
        dc = new DicionarioDePalavras();
        partida = null;
    }

    public Partida getPartidaEmAndamento(){
        return partida;
    }

    private Boolean partidaIniciada(){
        return partida != null;
    }

    public void iniciarPartida() {
        if (!partidaIniciada()){
            partida = new Partida("arara");
        }else{
            throw new JogoEmExecucao("Já existe um jogo em progresso!");
        }
    }

    public String chute(String palavra) throws palavraNaoEncontrada{
        if (!dc.palavraExiste(palavra.toLowerCase())){
            throw new palavraNaoEncontrada("Essa palavra não existe no dicionário de palavras");
        }
        partida.decrementarTentativas();
        return partida.retornarFeedback(palavra.toLowerCase());
    }
}