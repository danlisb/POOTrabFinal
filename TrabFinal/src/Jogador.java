import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;

public class Jogador extends JPanel{
    private String nome;
    private int posicao;
    private int posicaoInicial;
    private int passosDados;
    private boolean imobilizado;
    private boolean sabotado;

    private Passivo passivo;
    private Instantaneo instantaneo;

    public Jogador(String nome, int posicao, Color cor) {
        this.nome = nome;
        this.passosDados = 0;
        this.posicao = posicao;
        this.posicaoInicial = posicao;
        this.passivo = null;
        this.instantaneo = null;
        this.imobilizado = false;
        this.sabotado = false;

        setPreferredSize(new Dimension(20, 20));
        setBackground(cor);
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
    }

    public boolean getSabotado(){
        return sabotado;
    }

    public void sabotarJogador() {
        if(this.passivo instanceof Escudo) {
            System.out.println(this.nome + " tinha escudo e se defendeu de Sabotar");
            this.passivo = null;
        } else 
            this.sabotado = true;
    }

    public void resetSabotado() {
        this.sabotado = false;
    }


    public boolean getImobilizado() {
        return this.imobilizado;
    }

    public void imobilizarJogador() {
        if(this.passivo instanceof Escudo) {
            System.out.println(this.nome + " tinha escudo e se defendeu de Imobilizar");
            this.passivo = null;
        } else 
            this.imobilizado = true;
    }

    public void resetImobilizado() {
        this.imobilizado = false;
    }


    public Passivo getPassivo() {
        return this.passivo;
    }

    public void resetPassivo() {
        this.passivo = null;
    }

    public Instantaneo getInstantaneo() {
        return instantaneo;
    }

    public void resetInstantaneo() {
        this.instantaneo = null;
    }

    public void ganharItem() {
        int valor;
        Dado dado = new Dado();

        valor = dado.rolagem(); // atualizar para 6 depois
        switch (valor) {
            case 1:
                if (passivo != null)
                    System.out.println("Você já possui um item!" + passivo.getNome() + "será substituido.\n");

                passivo = new AsasDeIcaro();
                System.out.println("Ganhou " + passivo.getNome());

                break;
            case 2:
                if (passivo != null)
                    System.out.println("Você já possui um item!" + passivo.getNome() + "será substituido.\n");

                passivo = new Empurrar();
                System.out.println("Ganhou " + passivo.getNome());

                break;
            case 3:
                if (passivo != null)
                    System.out.println("Você já possui um item!" + passivo.getNome() + "será substituido.\n");

                passivo = new Escudo();
                System.out.println("Ganhou " + passivo.getNome());

                break;
            case 4:
                if (instantaneo != null)
                    System.out.println("Você já possui um item!" + instantaneo.getNome() + "será substituido.\n");

                instantaneo = new Imobilizar();
                System.out.println("Ganhou " + instantaneo.getNome());

                break;
            case 5:
                if (instantaneo != null)
                    System.out.println("Você já possui um item!" + instantaneo.getNome() + "será substituido.\n");

                instantaneo = new Sabotar();
                System.out.println("Ganhou " + instantaneo.getNome());

                break;
            case 6:
                if (instantaneo != null)
                    System.out.println("Você já possui um item!" + instantaneo.getNome() + "será substituido.\n");
                instantaneo = new Velocidade();
                System.out.println("Ganhou " + instantaneo.getNome());

                break;
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

    public int mover(int numeroDePassos) {
        int posicaoAnterior = this.posicao;

        if (this.posicao + numeroDePassos > 19)
            this.posicao = this.posicao + numeroDePassos - 20;
        else
            this.posicao += numeroDePassos;

        this.passosDados += numeroDePassos;

        return posicaoAnterior;

    }

    public boolean venceu() {
        return passosDados >= 20;
    }

    public int moverParaProximaTorre() {
        int posicaoAnterior = this.posicao;
        int proximaTorre = 0;

        if (this.posicao > 0 && this.posicao < 5)
            proximaTorre = 5;
        else if (this.posicao > 5 && this.posicao < 10)
            proximaTorre = 10;
        else if (this.posicao > 10 && this.posicao < 15)
            proximaTorre = 15;
        else if (this.posicao > 15)
            proximaTorre = 0;

        if (proximaTorre > posicaoAnterior){
            return proximaTorre - this.posicao;
        }
        else
            return 20 - this.posicao;
    }

    public int moverParaTorreAnterior() {
        int torreAnterior = 0;

        if (this.posicao > 0 && this.posicao < 5)
            torreAnterior = 0;
        else if (this.posicao > 5 && this.posicao < 10)
            torreAnterior = 5;
        else if (this.posicao > 10 && this.posicao < 15)
            torreAnterior = 10;
        else if (this.posicao > 15)
            torreAnterior = 15;

        return torreAnterior - this.posicao;
    }

    public void usaItem(Jogador jogador, List<Jogador> jogadores, Tabuleiro tabuleiro) {

        Jogador autor = jogador;

        if (instantaneo == null)
            return;
        else 
            instantaneo.usaItem(autor, jogadores, tabuleiro);

    }

    @Override
    public String toString() {
        String nInstantaneo = "N/A";
        String nPassivo = "N/A";

        if(this.instantaneo != null)
            nInstantaneo = instantaneo.getNome();

            if(this.passivo != null)
            nPassivo = passivo.getNome();


        return "Nome: " + nome + " | Posicao: " + posicao + 
        "| Item instaneo: " + nInstantaneo + " | " +
        "Item passivo: " + nPassivo;
    }

}
