import java.util.Random;

public class Dado extends JogoDaExplosao {
    private int valor;
    private Random gerador;

    public Dado() {
        valor = 0;
        gerador = new Random();
    }

    public int rolar(){
        valor = gerador.nextInt(3) + 1; // atualizar para 6 depois
        System.out.println(toString());
        return valor;
    }

    @Override
    public String toString() {
        switch(valor) {
            case 1:
              return "Voce rolou o dado e tirou 1.";
            case 2:
                return "Voce rolou o dado e tirou 2.";
            case 3:
                return "Voce rolou o dado e tirou 3.";
            // case 4:
            //     return "Voce rolou o dado e tirou uma bomba.";
            // case 5:
            //     return "Voce rolou o dado e tirou uma bomba."; 
            // case 6:
            //     return "Voce rolou o dado e ganhou um item!.";
          }
        return "";
    }
}
