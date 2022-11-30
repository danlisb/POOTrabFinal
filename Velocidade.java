public class Velocidade extends Instantaneo {
    // Velocidade: duplica o valor tirado no dado.

    
    public Velocidade() {
        super("Velocidade");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    public void usaItem(Jogador jogador, Jogador alvo){
        super.usaItem(jogador, alvo);
        Dado dado = new Dado();
        int d = dado.rolar() + 1;
        switch(d) {
            case 1: // cima
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
                break;
            case 2: // direita
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
                break;
            case 3: // baixo
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
                break;
            case 4: // esquerda
                d = 1;
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
                break;
            case 5:
                d = 2;
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
            break;
            case 6:
                d = 3;
                jogador.moverJogador(d * 2);
                jogador.resetInstantaneo();
            break;
        }
    }
}
