public class AsasDeIcaro extends Passivo {
    // Asas de icaro: ao explodir a ponte em que o jogador está, as asas são ativadas.
    // Elas permitem ao jogador voar até a próxima torre.

    public AsasDeIcaro() {
        super("Asas De Icaro");
    }

    @Override
    public String toString() {
        return super.toString() + super.getNome();
    }

}
