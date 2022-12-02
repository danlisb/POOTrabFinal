import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class JogoDaExplosao extends JFrame {
    private final PainelDeMensagem pMensagem;
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private Dado dado;
    private Scanner scanner = new Scanner(System.in);
    private static final Random gerador = new Random();
    private static final Color[] coresDosJogadores = {
            new Color(0, 0, 255),
            new Color(34, 139, 34),
            new Color(255, 140, 0),
            new Color(139, 0, 139) };

    public JogoDaExplosao() {
        this.jogadores = new ArrayList<>();
        this.tabuleiro = new Tabuleiro();
        this.dado = new Dado();
        this.pMensagem = new PainelDeMensagem("Bem-vindo ao Jogo de Tabuleiro!");
    }

    private void criarJanela() {
        // Caracteristicas da Janela Principal
        // ############################################
        setTitle("Jogo de Tabuleiro");
        setSize(520, 560);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Definição dos paineis ---------------------------
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // -- Painel Superior ----------------------------------
        JPanel pSuperior = new JPanel();

        pSuperior.setLayout(new GridBagLayout());
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.8;
        c.weighty = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        pSuperior.add(pMensagem, c);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        add(pSuperior, c);

        // -- Tabuleiro --------------------------------------
        c.weightx = 1.0;
        c.weighty = 0.9;
        c.gridx = 0;
        c.gridy = 1;
        add(tabuleiro, c);

        setVisible(true);
    }

    public void iniciarJogadores() { // Recebe a quantidade de jogadores e os inicializa, com nomes e suas posicoes
                                     // iniciais no tabuleiro

        String nomeDoJogador;
        int posicaoInicial = 0;
        int quantidadeDeJogadores = 0;

        while (quantidadeDeJogadores < 2 || quantidadeDeJogadores > 4) {

            System.out.println(
                    "Selecione a quantidade de jogadores:\n2) 2 jogadores\n3) 3 jogadores\n4) 4 jogadores\nSua escolha:");
            quantidadeDeJogadores = this.scanner.nextInt();
            if (quantidadeDeJogadores >= 2 && quantidadeDeJogadores <= 4)

                for (int j = 0; j < quantidadeDeJogadores; j++) {
                    System.out.println("\nInsira o nome do jogador " + (j + 1) + ": ");
                    nomeDoJogador = this.scanner.next(); // Le o nome do jogador

                    switch (j) {
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
                    jogadores.add(new Jogador(nomeDoJogador, posicaoInicial, coresDosJogadores[j]));
                }
            else {
                System.out.println("Entrada invalida, insira novamente!");
            }
        }
        tabuleiro.adicionarJogadores(jogadores);

    }

    public Jogador existeVencedor() {
        for (Jogador jogador : jogadores) {
            if (jogador.venceu() == true)
                return jogador;
        }

        return null;
    }

    public void listarPosicaoJogadores() {
        for (Jogador player : jogadores) {
            System.out.println("Posições de " + player.getNome() + ": " + player.getPosicao() + "\n");
        }
    }

    public void atualizaMensagem() {
        String jogadoresInfo = "<html><body>";

        for (Jogador jog : jogadores) {
            jogadoresInfo += jog + "<br>";   
        }

        jogadoresInfo += "<html><body>";

        pMensagem.alterarTexto(jogadoresInfo);
    }

    public void rodada() {
        String nomeAlvo;
        int num;
        int escolha;
        Jogador jogador;

        while (existeVencedor() == null) {

            System.out.println("---------------------------------");

            listarPosicaoJogadores();

            for (int j = 0; j < jogadores.size(); j++) {
                atualizaMensagem();
                jogador = jogadores.get(j);

                if (jogador.getImobilizado() == true) {
                    System.out.println(
                            "O jogador " + jogador.getNome() + " está imobilizado, por isso não jogará essa rodada.\n");
                    jogador.setImobilizado(false);
                } else {
                    System.out.println("Vez do jogador " + jogador.getNome() + "\n");
                    System.out.println("Escolha sua opção: \n1)Jogar dado. \n2)Usar item.\n");
                }
                escolha = this.scanner.nextInt();
                if (escolha == 1) {
                    num = dado.rolar();
                    if (num <= 3) {
                        int posicaoAnterior = tabuleiro.moverJogador(jogador, num);
                        // System.out.println("Posção atual: " + jogador.getPosicao() + "\n");
                        tabuleiro.colocaPonte(posicaoAnterior, jogador.getPosicao());
                    } else if (num == 4 || num == 5) {
                        if (jogador.getSabotado() == false)
                            this.tabuleiro.explodirPonte(jogadores);
                        else {
                            System.out.println("Este jogador está sabotado, a explosão nao ocorrerá!");
                            jogador.setSabotado(false);
                        }
                    } else if (num == 6) {
                        jogador.ganharItem();

                    }

                } else if (escolha == 2 && jogador.getInstantaneo() != null) {
                    System.out.println("Escolha o alvo do item: ");
                    nomeAlvo = this.scanner.next();

                    for (Jogador alvo : jogadores) {
                        if (alvo.getNome().equalsIgnoreCase(nomeAlvo))
                            jogador.getInstantaneo().usaItem(jogador, alvo);

                        else
                            System.out.println("Jogador alvo inválido!\n");
                    }
                } else if (escolha == 2 && jogador.getInstantaneo() == null) {
                    System.out.println("Você não possui itens instantaneos!\n");
                    j--;

                }
                atualizaMensagem();

                if (jogador.venceu() == true) {
                    System.out.println("O jogo acabou! Parabéns " + jogador.getNome() + "!!!!!");
                    break;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        JogoDaExplosao jogo = new JogoDaExplosao();
        jogo.iniciarJogadores();
        jogo.criarJanela();

        jogo.rodada();
    }
}
