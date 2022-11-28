import java.util.Random;

public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;
    private int passosDados;

    // private Item passivo;
    // private Item instantaneo;

    public Jogador(String nome, int posicao, boolean tem) {
        this.nome = nome;
        this.passosDados = 0;
        this.posicao = posicao;
        this.posicaoInicial = posicao;

    }

    public void ganharPoder(){
        int valor;
        Random gerador = new Random();
        Dado dado = new Dado();
        if(dado.rolar() == 6){
          valor =  gerador.nextInt(6) + 1; // atualizar para 6 depois
          switch(valor) {
            case 1: // AsasDeIcaro
                AsasDeIcaro a = new AsasDeIcaro("asasDeIcaro");
                a.temItem(true);
                break;
            case 2: // Empurrar
                Empurrar e = new Empurrar("empurrar");
                e.temItem(true);
                break;
            case 3: // Escudo
                Escudo s = new Escudo("escudo");
                s.temItem(true);
                break;
            case 4: // Imobilizar
                Imobilizar i = new Imobilizar("imobilizar");
                i.temItem(true);
                break;
            case 5: // Sabotar
                Sabotar sa = new Sabotar("sabotar");
                sa.temItem(true);
                break;
            case 6: // Velocidade
                Velocidade v = new Velocidade("velocidade");
                v.temItem(true);              
                break;
            }
        }
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
            
        this.passosDados += numeroDePassos;

        return posicaoAnterior;

    }

    public boolean venceu() {
        return passosDados >= 20;
    }

    public void moverParaProximaTorre() {
        int posicaoAnterior = this.posicao;

        if(this.posicao > 0 && this.posicao < 5)
            this.posicao = 5;
        else if (this.posicao > 5 && this.posicao < 10)
            this.posicao = 10;
        else if (this.posicao > 10 && this.posicao < 15)
            this.posicao = 15;
        else if (this.posicao > 15)
            this.posicao = 0;

        if(posicaoAnterior < this.posicao)
            this.passosDados += this.posicao - posicaoAnterior;
        else
            this.passosDados += 20 - posicaoAnterior;
    }

    public void moverParaTorreAnterior() {
        int posicaoAnterior = this.posicao;

        //if( == true)
        //    moverParaProximaTorre();
        if(this.posicao > 0 && this.posicao < 5)
            this.posicao = 0;
        else if (this.posicao > 5 && this.posicao < 10)
            this.posicao = 5;
        else if (this.posicao > 10 && this.posicao < 15)
            this.posicao = 10;
        else if (this.posicao > 15)
            this.posicao = 15;

        
        this.passosDados -= posicaoAnterior - this.posicao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Posicao: " + posicao;
    }

}
