public class Escudo extends Passivo {
    // Escudo: o escudo previne qualquer tipo de infortúnio causado por um item ao
    // jogador que o detém.

    public Escudo() {
        super("Escudo");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }  
}
