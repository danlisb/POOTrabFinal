import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List <Jogador> jogadores = new ArrayList<>();

        Jogador p1 = new Jogador("Ferrao", 0, false);
        Jogador p2 = new Jogador("Daniel", 18, false);

        jogadores.add(p1);
        jogadores.add(p2);

        Dado d = new Dado();

        int posicaoAnterior = jogadores.get(0).moverJogador(19);

        Tabuleiro t = new Tabuleiro();

        t.colocaPonte(posicaoAnterior, jogadores.get(0).getPosicao());

        posicaoAnterior = jogadores.get(0).moverJogador(4);

        t.colocaPonte(posicaoAnterior, jogadores.get(0).getPosicao());

        t.explodirPonte(jogadores);

        System.out.println("Posicao p1:" + jogadores.get(0).getPosicao());

    }
}
