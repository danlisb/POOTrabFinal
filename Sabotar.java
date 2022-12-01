public class Sabotar extends Instantaneo {
    // Sabotar: Evita que um adversário acione o mecanismo de explosão.

    public Sabotar() {
        super("Sabotar");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    public void usaItem(Jogador jogador, Jogador alvo) {
        super.usaItem(jogador, alvo);
        alvo.setSabotado(true);
    }
}
