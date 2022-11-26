import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class JogoDaExplosao {
    private List <Jogador> jogadores = new ArrayList<>();
    private Tabuleiro tabuleiro;
    private Dado dado;
    private Random gerador;
    private Item asasDeIcaro;


    public JogoDaExplosao(){
        
    }
    

    public void iniciarJogadores() { // Recebe a quantidade de jogadores e os inicializa, com nomes e suas posicoes iniciais no tabuleiro
        Scanner scanner = new Scanner(System.in);
        String nomeDoJogador;
        int posicaoInicial = 0;
        int quantidadeDeJogadores = 0;
        while(quantidadeDeJogadores < 2 || quantidadeDeJogadores > 4){
            System.out.println("Selecione a quantidade de jogadores:\n2) 2 jogadores\n3) 3 jogadores\n4) 4 jogadores\nSua escolha:");
            quantidadeDeJogadores = scanner.nextInt();
            if(quantidadeDeJogadores >= 2 && quantidadeDeJogadores <= 4)
                for(int j = 0; j < quantidadeDeJogadores; j++) {
                    System.out.println("\nInsira o nome do jogador " + (j+1) + ": ");
                    nomeDoJogador = scanner.next();
                    switch(j){
                        case 0:
                            posicaoInicial = 0;
                            break;
                        case 1:
                            posicaoInicial = 10;
                            break;
                        case 2:
                            posicaoInicial = 5;
                            break;
                        case 3:
                            posicaoInicial = 15;
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

    /*public void ganharPoder(Jogador jogador){
        int valor;
        gerador  = new Random();
        if(dado.rolar() == 6){
          valor =  gerador.nextInt(6) + 1; // atualizar para 6 depois
          switch(valor) {
            case 1: // AsasDeIcaro

                break;
            case 2: // Empurrar
                
                break;
            case 3: // Escudo
                
                break;
            case 4: // Imobilizar
                
                break;
            case 5: // Sabotar

                break;
            case 6: // Velocidade

                break;
            }
        }
    }*/
}
