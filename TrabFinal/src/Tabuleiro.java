import java.util.List;

public class Tabuleiro {

    private int posicaoDoJogador1;
    private int posicaoDoJogador2;
    private int posicaoDoJogador3;
    private int posicaoDoJogador4;
    private int[] ambiente;


    
    public Tabuleiro(List <Jogador> jogadores) {
        this.ambiente = new int[20];

        for(int i = 0; i < 20; i++)
            ambiente[i] = 0; // 0 eh buraco

        ambiente[0] = 2; // 2 eh torre
        ambiente[5] = 2; 
        ambiente[10] = 2; 
        ambiente[15] = 2; 

                        // 1 eh ponte

        switch(jogadores.size()) {
            case 4:
                this.posicaoDoJogador1 = 0;
                this.posicaoDoJogador2 = 10;
                this.posicaoDoJogador3 = 5;
                this.posicaoDoJogador4 = 15;
                break;
            case 3:
                this.posicaoDoJogador1 = 0;
                this.posicaoDoJogador2 = 10;
                this.posicaoDoJogador3 = 5;
                this.posicaoDoJogador4 = -1;
                break;
            case 2:
                this.posicaoDoJogador1 = 0;
                this.posicaoDoJogador2 = 10;
                this.posicaoDoJogador3 = -1;
                this.posicaoDoJogador4 = -1;
                break;
        }
    }

    public int getPosicaoDoJogador(int jogador){
        if(jogador == 1)
            return posicaoDoJogador1;
        
        if(jogador == 2)
            return posicaoDoJogador2;
        
        if(jogador == 3)
            return posicaoDoJogador3;

        if(jogador == 4)
            return posicaoDoJogador4;
        
        return -1;
    }

    public boolean temPonte(int indice) {
        return ambiente[indice] == 1 ? true : false;
    }

    public void colocaPonte(int indice) {
        if(indice == 0)
            ambiente[indice] = 1;
    }

    public void tiraPonte(int indice) {
        if(indice == 1)
            ambiente[indice] = 0;
    }

    public void moveJogador(int jogador, int numeroDePassos){
        if(jogador == 1)
            posicaoDoJogador1 += numeroDePassos;
    }

    public void moverParaUltimaTorre(int jogador){
        
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
