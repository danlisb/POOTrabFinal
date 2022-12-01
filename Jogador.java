public class Jogador {
    private String nome;
    private int posicao;
    private int posicaoInicial;
    private int passosDados;
    private boolean imobilizado;
    private boolean sabotado;
    private int idade;

    private Passivo passivo;
    private Instantaneo instantaneo;

    public Jogador(String nome, int posicao, int idade) {
        this.nome = nome;
        this.passosDados = 0;
        this.posicao = posicao;
        this.posicaoInicial = posicao;
        this.passivo = null;
        this.instantaneo = null;
        this.imobilizado = false;
        this.sabotado = false;
        this.idade = idade;
    }

    public boolean getSabotado(){
        return sabotado;
    }

    public void setSabotado(boolean i){
        sabotado = i;
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

    public boolean getImobilizado() {
        return this.imobilizado;
    }

    public void setImobilizado(boolean i) {
        this.imobilizado = i;
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

    public int moverJogador(int numeroDePassos) {
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

    public void moverParaProximaTorre() {
        int posicaoAnterior = this.posicao;

        if (this.posicao > 0 && this.posicao < 5)
            this.posicao = 5;
        else if (this.posicao > 5 && this.posicao < 10)
            this.posicao = 10;
        else if (this.posicao > 10 && this.posicao < 15)
            this.posicao = 15;
        else if (this.posicao > 15)
            this.posicao = 0;

        if (posicaoAnterior < this.posicao)
            this.passosDados += this.posicao - posicaoAnterior;
        else
            this.passosDados += 20 - posicaoAnterior;
    }

    public void moverParaTorreAnterior() {
        int posicaoAnterior = this.posicao;

        if (this.posicao > 0 && this.posicao < 5)
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
