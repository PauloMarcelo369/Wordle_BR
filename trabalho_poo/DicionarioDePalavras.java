import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class DicionarioDePalavras {
    private List<String> palavras;

    public DicionarioDePalavras(){
        palavras = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File("br-utf8.txt"));
            while(sc.hasNextLine()){
                palavras.add(sc.nextLine());
            }
            sc.close();
        }
        catch(FileNotFoundException e){
            System.out.println("caminho de arquivo não encontrado!");
        }
    }

    public String palavraAletoria(){
        long semente = System.currentTimeMillis();
        Random random = new Random(semente);
        int posicaoAleatoria = random.nextInt(palavras.size());
        return palavras.get(posicaoAleatoria);
    }

    public Boolean palavraExiste(String palavra){
        return palavras.contains(palavra);
    }
}