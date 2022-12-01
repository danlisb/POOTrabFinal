public class Imobilizar extends Instantaneo {
    // Imobilizar: um jogador adversário fica uma rodada sem jogar.

    public Imobilizar() {
        super("Imobilizar");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

   public void usaItem(Jogador jogador, Jogador alvo){
        super.usaItem(jogador, alvo);
        alvo.setImobilizado(true);
        jogador.resetInstantaneo();
   }
}
