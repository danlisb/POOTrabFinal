import java.util.List;
import java.util.Random;

public class Velocidade extends Instantaneo {
    // Velocidade: duplica o valor tirado no dado.
    private Random gerador;

    
    public Velocidade() {
        super("Velocidade");
        this.gerador = new Random();
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    
    public void usaItem(Jogador autor, List<Jogador> jogadores, Tabuleiro tabuleiro){
        super.usaItem(autor, jogadores, tabuleiro);
        int d;
        d = gerador.nextInt(3) + 1;
        d *= 2;
        int posicaoAnterior = tabuleiro.moverJogador(autor, d);
        
        System.out.println("O jogador usou velocidade e andou " + d + " casas");

        autor.resetInstantaneo();
        tabuleiro.colocaPonte(posicaoAnterior, autor.getPosicao());
        
    }
}
