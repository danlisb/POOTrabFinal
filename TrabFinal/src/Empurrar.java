public class Empurrar extends Passivo {
    // Empurrar: empurra o adversário que estiver em uma casa (pedaço da ponte) que
    // o jogador passar. Caso haja mais de um adversário na mesma casa, o jogador
    // escolherá qual será empurrado.
    Jogador alvo;
    Jogador jogador;
    public Empurrar() {
        super("Empurrar");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }  

    public void usarItem(Jogador jogador, Jogador alvo){
        super.usaItem(jogador, alvo);

        if(jogador.getPosicao() == alvo.getPosicao()){
        alvo.moverParaTorreAnterior();
        jogador.resetInstantaneo();
        }
        else;
    }
}
