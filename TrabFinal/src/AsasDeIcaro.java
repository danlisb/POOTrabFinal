public class AsasDeIcaro extends Passivo {
    // Asas de Ícaro: ao explodir a ponte em que o jogador está, as asas são ativadas.
    // Elas permitem que o jogador voar até a próxima torre.

    public AsasDeIcaro(String n) {
        super(n);
    }

    @Override
    public String toString() {
        return "As asas de ícaro";
    }

    public void temItem(boolean b) {
    }

    /*  public boolean temAsas(Jogador jogador){
        return true;
    }*/
}
