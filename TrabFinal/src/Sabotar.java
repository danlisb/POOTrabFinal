public class Sabotar extends Instantaneo {
    // Sabotar: Evita que um adversário acione o mecanismo de explosão.

    public Sabotar() {
        super("Sabotar");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }
}
