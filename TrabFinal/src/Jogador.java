import java.util.Random;

public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;
    private int passosDados;
    private boolean imobilizado;

    private Passivo passivo;
    private Instantaneo instantaneo;

    public Jogador(String nome, int posicao) {
        this.nome = nome;
        this.passosDados = 0;
        this.posicao = posicao;
        this.posicaoInicial = posicao;
        this.passivo = null;
        this.instantaneo = null;
        this.imobilizado = false;
    }

    public void ganharPoder(){
        int valor;
        Random gerador = new Random();
        Dado dado = new Dado();

        if(dado.rolar() == 6) {
          valor =  gerador.nextInt(6) + 1; // atualizar para 6 depois
          switch(valor) {
            case 1: 
                this.passivo = new AsasDeIcaro();
                break;
            case 2: 
                this.passivo = new Empurrar();
                break;
            case 3: 
                this.passivo = new Escudo();
                break;
            case 4: 
                this.instantaneo = new Imobilizar();
                break;
            case 5: 
                this.instantaneo = new Sabotar();
                break;
            case 6: 
                this.instantaneo = new Velocidade();             
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
