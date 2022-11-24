public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;

    private Item passivo;
    private Item instantaneo;

    public Jogador(String nome, int posicao) {
        this.nome = nome;
        this.posicao = posicao;
        this.posicaoInicial = posicao;

    }

    public int getPosicao() {
        return posicao;
    }

    public int getPosicaoInicial() {
        return posicaoInicial;
    }

    public void moverJogador(int numeroDePassos) {
        if(this.posicao + numeroDePassos > 19)
            this.posicao = 0;
        this.posicao += numeroDePassos;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
