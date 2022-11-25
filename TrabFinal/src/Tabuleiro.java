import java.util.List;
import java.util.Random;

public class Tabuleiro {

    private int[] ambiente;
    private Random gerador;

    public Tabuleiro() {
        this.gerador = new Random();
        this.ambiente = new int[20];

        for(int i = 0; i < 20; i++)
            ambiente[i] = 0; // 0 eh buraco

        ambiente[0] = 2; // 2 eh torre
        ambiente[5] = 2; 
        ambiente[10] = 2; 
        ambiente[15] = 2; 
                        // 1 eh ponte
    }



    public boolean temPonte(int indice) {
        return ambiente[indice] == 1 ? true : false;
    }

    public void colocaPonte(int posicaoAnterior, int posicaoDoJogador) {
        if(posicaoAnterior < posicaoDoJogador){
            for(int i = posicaoAnterior; i <= posicaoDoJogador; i++)
                if(!temPonte(i))
                    ambiente[i] = 1;
        } else {
            for(int i = posicaoAnterior; i < 20; i++)
                if(!temPonte(i))
                    ambiente[i] = 1;
            for(int i = 1; i < posicaoDoJogador; i++)
                if(!temPonte(i))
                    ambiente[i] = 1;
        }
    }

    public void tiraPonte(int indice) {
        if(indice == 1)
            ambiente[indice] = 0;
    }

    public void explodirPonte(List <Jogador> jogadores) {
        int lado = gerador.nextInt(4)+1;

        switch(lado) {
            case 1: // cima
                for(int i = 1; i < 5; i++)
                    tiraPonte(i);
                break;
            case 2: // direita
                for(int i = 6; i < 10; i++)
                    tiraPonte(i);
                break;
            case 3: // baixo
                for(int i = 11; i < 15; i++)
                    tiraPonte(i);
                break;
            case 4: // esquerda
                for(int i = 16; i < 20; i++)
                    tiraPonte(i);
                break;
            }

        for (Jogador jogador : jogadores) 
            if(ambiente[jogador.getPosicao()] == 0)
                jogador.moverParaTorreAnterior();
        
        
        
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
