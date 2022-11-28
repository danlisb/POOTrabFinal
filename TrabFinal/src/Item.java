abstract public class Item extends Jogador {
    private String nome;

    public Item(String n) {
        super(n, 5, false);
        this.nome = n;
    }

}
