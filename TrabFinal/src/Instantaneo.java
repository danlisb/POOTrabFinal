import java.util.List;
import java.util.Scanner;

abstract public class Instantaneo extends Item {
    Scanner sc;
    
    public Instantaneo(String n) {
        super(n);
        sc = new Scanner(System.in);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String toString() {
        return "Instantaneo - ";
    }

    public Jogador getAlvo(Jogador autor, List<Jogador> jogadores) {
        String nomeAlvo;

        System.out.println("\nEscolha o jogador a ser imobilizado: ");
        
        for (Jogador jogador : jogadores) 
            if(!jogador.equals(autor))
                System.out.println(jogador);
            
        System.out.println("\nSua escolha: ");

        nomeAlvo = sc.next();

            for (Jogador alvo : jogadores) 
                if (alvo.getNome().equalsIgnoreCase(nomeAlvo))
                    return alvo;
        
        return null;
    }


    public void usaItem(Jogador jogador, List<Jogador> jogadores, Tabuleiro tabuleiro) {

    }

    
}
