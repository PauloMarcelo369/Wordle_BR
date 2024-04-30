import java.util.Scanner;

public class LetrecoApp {
    public void jogar(){
        System.out.println("=====================");
        System.out.println("BEM-VINDO AO LETREXTO");
        System.out.println("=====================");
        System.out.println("Instruções:");
        System.out.println("- O computador escolherá uma palavra aleatória de cinco letras.");
        System.out.println("- Você tem seis tentativas para adivinhar a palavra.");
        System.out.println("- Após cada palpite, você receberá feedback sobre o seu palpite:");
        System.out.println("  - Um '+' indica uma letra correta na posição correta.");
        System.out.println("  - Um '-' indica uma letra correta na posição errada.");
        System.out.println("  - Um '*' indica uma letra incorreta.");
        System.out.println();
        System.out.println("Vamos começar!");
        System.out.println();
        ControaladorDeJogo letreco = new ControaladorDeJogo();
        letreco.iniciarPartida();
        Scanner sc = new Scanner(System.in);
        Boolean resultado = false;

        while(!letreco.getPartidaEmAndamento().fimDeJogo()){
            try{
                System.out.print("Tentativa #" + letreco.getPartidaEmAndamento().getTentativas() + ": " );
                String palavra = sc.next();
                System.out.println();
                String feedBack = letreco.chute(palavra);
                System.out.println("Palpite: " + palavra);
                System.out.println("Resultado: " + feedBack);
                System.out.println();

                if (letreco.getPartidaEmAndamento().PalavraEncontrada(palavra)) {
                    resultado = true;
                    break;
                }
            }
            catch(palavraNaoEncontrada e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        if (resultado){
            System.out.println();
            System.out.println("Parabens, voce acertou a palavra: " + letreco.getPartidaEmAndamento().getPalavraSecreta());
            System.out.println();
        }else {
            System.out.println();
            System.out.println("Você perdeu! a palavra era: " + letreco.getPartidaEmAndamento().getPalavraSecreta());
            System.out.println();
        }
        System.out.println("Obrigado por jogar Letreco!");
        sc.close();
    }
}