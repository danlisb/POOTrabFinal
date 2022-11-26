public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;

    // private Item passivo;
    // private Item instantaneo;

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

    public String getNome() {
        return nome;
    }

    public int moverJogador(int numeroDePassos) {
        int posicaoAnterior = this.posicao;

        if(this.posicao + numeroDePassos > 19)
            this.posicao = this.posicao + numeroDePassos - 20;
        else
            this.posicao += numeroDePassos;
            
        return posicaoAnterior;

    }

    public void moverParaProximaTorre() {
        if(this.posicao > 0 && this.posicao < 5)
            this.posicao = 5;
        else if (this.posicao > 5 && this.posicao < 10)
            this.posicao = 10;
        else if (this.posicao > 10 && this.posicao < 15)
            this.posicao = 15;
        else if (this.posicao > 15)
            this.posicao = 0;
    }

    public void moverParaTorreAnterior() {
        if(this.posicao > 0 && this.posicao < 5)
            this.posicao = 0;
        else if (this.posicao > 5 && this.posicao < 10)
            this.posicao = 5;
        else if (this.posicao > 10 && this.posicao < 15)
            this.posicao = 10;
        else if (this.posicao > 15)
            this.posicao = 15;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Posicao: " + posicao;
    }

    /*public String temItemJogador(Jogador jogador, Item item){
        if(AsasDeIcaro == true)
            return "Possui Assas de Icaro\n" + "Item passivo";
        if(Escudo escudo == true)
            return "Possui Escudo\n" + "Item passivo";
        if(Velocidade velocidade == true)
            return "Possui Velocidade\n" + "Item passivo";
        if(Empurrar empurrar == true)
            return "Possui Empurrar\n" + "Item ativo";
        if(Imobilizar imobilizar == true)
            return "Possui Imobilizar\n" + "Item ativo";
        if(Sabotar sabotar == true)
            return "Possui Sabotar\n" + "Item ativo";
        else
            return null;
    } */
}
