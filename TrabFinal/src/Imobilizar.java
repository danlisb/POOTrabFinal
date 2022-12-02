import java.util.List;
import java.util.Scanner;

public class Imobilizar extends Instantaneo {
    // Imobilizar: um jogador adversário fica uma rodada sem jogar.

    public Imobilizar() {
        super("Imobilizar");
        sc = new Scanner(System.in);
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    public void usaItem(Jogador autor, List<Jogador> jogadores, Tabuleiro tabuleiro) {
        super.usaItem(autor, jogadores, tabuleiro);

        Jogador alvo = this.getAlvo(autor, jogadores);

        alvo.imobilizarJogador();
        autor.resetInstantaneo();
    }
}
