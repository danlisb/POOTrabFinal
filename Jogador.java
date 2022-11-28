import java.util.Random;

public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;
    private int passosDados;
    private boolean asasDeIcaro;
    private boolean velocidade;
    private boolean escudo;
    private boolean empurra;
    private boolean sabotar;
    private boolean imobilizar;

    // private Item passivo;
    // private Item instantaneo;

    public Jogador(String nome, int posicao, boolean tem) {
        this.nome = nome;
        this.passosDados = 0;
        this.posicao = posicao;
        this.posicaoInicial = posicao;
        this.asasDeIcaro = tem;
        this.velocidade = tem;
        this.escudo = tem;
        this.empurra = tem;
        this.sabotar = tem;
        this.imobilizar = tem;

    }

    public void ganharPoder(Jogador jogador){
        int valor;
        Random gerador = new Random();
        Dado dado = new Dado();
        if(dado.rolar() == 6){
          valor =  gerador.nextInt(6) + 1; // atualizar para 6 depois
          switch(valor) {
            case 1: // AsasDeIcaro
                this.asasDeIcaro = true;
                break;
            case 2: // Empurrar
                this.empurra = true;
                break;
            case 3: // Escudo
                this.escudo = true;
                break;
            case 4: // Imobilizar
                this.imobilizar = true;
                break;
            case 5: // Sabotar
                this.sabotar = true;
                break;
            case 6: // Velocidade
                this.velocidade = true;                
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

        if(asasDeIcaro == true)
            moverParaProximaTorre();
        else if(this.posicao > 0 && this.posicao < 5)
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

    public String temItem(boolean item){
        if(asasDeIcaro == true)
            return "Possui Assas de Icaro\n" + "Item passivo";
        else if(escudo == true)
            return "Possui Escudo\n" + "Item passivo";
        else if(velocidade == true)
            return "Possui Velocidade\n" + "Item passivo";
         else if(empurra == true)
            return "Possui Empurrar\n" + "Item ativo";
        else if(imobilizar == true)
            return "Possui Imobilizar\n" + "Item ativo";
        else if(sabotar == true)
            return "Possui Sabotar\n" + "Item ativo";
        else
            return "Não possui itens";
    } 
}
