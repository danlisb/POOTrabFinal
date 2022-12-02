import java.util.List;

public class Sabotar extends Instantaneo {
    // Sabotar: Evita que um adversário acione o mecanismo de explosão.

    public Sabotar() {
        super("Sabotar");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    public void usaItem(Jogador autor, List<Jogador> jogadores, Tabuleiro tabuleiro) {
        super.usaItem(autor, jogadores, tabuleiro);
        Jogador alvo = getAlvo(autor, jogadores);
        alvo.sabotarJogador();
        autor.resetInstantaneo();

        
    }
}
