import java.util.List;
import java.util.Random;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class Tabuleiro extends JPanel{
    public static final int NUMERO_DE_CASAS = 20;
    private Celula[] tabuleiro;
    private Random gerador;

    public Tabuleiro()  {
        this.gerador = new Random();
        tabuleiro = new Celula[NUMERO_DE_CASAS];

        setLayout(new GridLayout(6,6));

        criarTabuleiro();
    }


    private void criarTabuleiro() {
        // Linha 1 ---
        int i;

        tabuleiro[0] = FabricaDeCelula.fabrica('T');
        add(tabuleiro[0]);

        for(i = 1; i < 5; i++){
            tabuleiro[i] = FabricaDeCelula.fabrica('B');
            add(tabuleiro[i]);
        }

        tabuleiro[5] = FabricaDeCelula.fabrica('T');
        add(tabuleiro[5]);

        int k = 13;
        for(i = 19; i >= 16; i--){
            tabuleiro[i] = FabricaDeCelula.fabrica('B');
            add(tabuleiro[i]);

            for(int j = 0; j < 4; j++)
                add(FabricaDeCelula.fabrica('V'));

            tabuleiro[i-k] = FabricaDeCelula.fabrica('B');
            add(tabuleiro[i-k]);
            k = k - 2;
        }

        tabuleiro[15] = FabricaDeCelula.fabrica('T');
        add(tabuleiro[15]);

        for(i = 14; i > 10; i--){
            tabuleiro[i] = FabricaDeCelula.fabrica('B');
            add(tabuleiro[i]);
        }

        tabuleiro[10] = FabricaDeCelula.fabrica('T');
        add(tabuleiro[10]);
    }

    public void mudaCelula(int i) {
        tabuleiro[i].colocaPonte();
    }


    public boolean temPonte(int indice) {
        return tabuleiro[indice].tipo() == 'P' ? true : false;
    }

    public boolean ehBuraco(int indice) {
        return tabuleiro[indice].tipo() == 'B' ? true : false;
    }

    public void adicionarJogadores(List<Jogador> jogadores) {
        for(Jogador j : jogadores) {
            tabuleiro[j.getPosicao()].adicionaJogador(j);
        }
    }

    public int moverJogador(Jogador j, int valor) {
        tabuleiro[j.getPosicao()].removerJogador(j);
        int posicaoAnterior = j.mover(valor);
        tabuleiro[j.getPosicao()].adicionaJogador(j);
        return posicaoAnterior;
    }

    public void colocaPonte(int posicaoAnterior, int posicaoDoJogador) {
        if(posicaoAnterior < posicaoDoJogador){
            for(int i = posicaoAnterior + 1; i <= posicaoDoJogador; i++)

                if(!temPonte(i) && ehBuraco(i)) 
                    tabuleiro[i].colocaPonte();
                
        } else {

            for(int i = posicaoAnterior + 1; i < 20; i++)
                if(!temPonte(i) && ehBuraco(i)) 
                    tabuleiro[i].colocaPonte();
                
            for(int i = 0; i <= posicaoDoJogador; i++)
                if(!temPonte(i) && ehBuraco(i)) 
                    tabuleiro[i].colocaPonte();
                
        }
    }

    public void explodirPonte(List <Jogador> jogadores) {
        int lado = gerador.nextInt(4)+1;
        
        switch(lado) {
            case 1: // cima
                for(int i = 1; i < 5; i++)
                    tabuleiro[i].tiraPonte();
                    System.out.println("A ponte superior caiu!\n");
                break;
            case 2: // direita
                for(int i = 6; i < 10; i++)
                    tabuleiro[i].tiraPonte();
                    System.out.println("A ponte lateral direita caiu!\n");
                break;
            case 3: // baixo
                for(int i = 11; i < 15; i++)
                    tabuleiro[i].tiraPonte();
                    System.out.println("A ponte inferior caiu!\n");
                break;
            case 4: // esquerda
                for(int i = 16; i < 20; i++)
                    tabuleiro[i].tiraPonte();
                    System.out.println("A ponte lateral esquerda caiu!\n");
                break;
            }

        for (Jogador jogador : jogadores) 
            if(tabuleiro[jogador.getPosicao()].tipo() == 'B' && jogador.getPassivo() instanceof AsasDeIcaro){
                this.moverJogador(jogador, jogador.moverParaProximaTorre());
                jogador.resetPassivo();
                System.out.println("Jogador " + jogador.getNome() + " salvo pelas Asas de Icaro!\n");
                }
                else if(tabuleiro[jogador.getPosicao()].tipo() == 'B' && jogador.getPassivo() instanceof AsasDeIcaro == false) {
                    this.moverJogador(jogador, jogador.moverParaTorreAnterior());
                    System.out.println("Jogador " + jogador.getNome() + " caiu e voltou a torre anterior!\n");
                }

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
