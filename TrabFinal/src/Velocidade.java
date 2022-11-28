public class Velocidade extends Instantaneo {
    // Velocidade: duplica o valor tirado no dado.

    
    public Velocidade() {
        super("Velocidade");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

}
