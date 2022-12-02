import java.util.Random;

public class Velocidade extends Instantaneo {
    // Velocidade: duplica o valor tirado no dado.
    private Random gerador;

    
    public Velocidade() {
        super("Velocidade");
        this.gerador = new Random();
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

    public void usaItem(Jogador jogador){
        super.usaItem(jogador, jogador);
        int d;
        d = gerador.nextInt(3) + 1;
        d *= 2;
        // jogador.moverJogador(d);
        
        System.out.println("O jogador usou velocidade e andou " + d + " casas");
    }
}
