import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class JogoDaExplosao {
    private List <Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Dado dado;
    private Random gerador;
    private boolean sabotado;

    public JogoDaExplosao() {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.dado = new Dado();
        this.gerador = new Random();
        this.sabotado = false;
    }

    public void iniciarJogadores() { // Recebe a quantidade de jogadores e os inicializa, com nomes e suas posicoes iniciais no tabuleiro
        Scanner scanner = new Scanner(System.in);
        String nomeDoJogador;
        int posicaoInicial = 0;
        int quantidadeDeJogadores = 0;

        while(quantidadeDeJogadores < 2 || quantidadeDeJogadores > 4) { // Enquanto colocarem um numero invalido de jogadores a mensagem se repete
            System.out.println("Selecione a quantidade de jogadores:\n2) 2 jogadores\n3) 3 jogadores\n4) 4 jogadores\nSua escolha:");
            quantidadeDeJogadores = scanner.nextInt(); // Le o input do usuario para o numero de jogadores

            if(quantidadeDeJogadores >= 2 && quantidadeDeJogadores <= 4) // Quando se entra com um numero valido de jogadores, entra aqui
                for(int j = 0; j < quantidadeDeJogadores; j++) {
                    System.out.println("\nInsira o nome do jogador " + (j+1) + ": ");
                    nomeDoJogador = scanner.next(); // Le o nome do jogador
                    switch(j) {
                        case 0:
                            posicaoInicial = 0; // Posicao do primeiro jogador
                            break;
                        case 1:
                            posicaoInicial = 10; // Posicao do segundo jogador
                            break;
                        case 2:
                            posicaoInicial = 5; // Posicao do terceiro jogador
                            break;
                        case 3:
                            posicaoInicial = 15; // Posicao do quarto jogador
                            break;
                    }
                    jogadores.add(new Jogador(nomeDoJogador, posicaoInicial));
                } else {
                    System.out.println("Entrada invalida, insira novamente!");
                }
        }
        scanner.close();
    }

    public void listarJogadores() {
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    public static void main(String[] args) throws Exception {
    
        JogoDaExplosao jogo = new JogoDaExplosao();

    }
}
