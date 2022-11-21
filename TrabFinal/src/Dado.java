import java.util.Random;

public class Dado extends JogoDaExplosao {
    private int valor;
    private Random gerador;

    Dado() {
        valor = 0;
        gerador = new Random();
    }

    public int rolar(){
        valor = gerador.nextInt(5);
        return valor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
