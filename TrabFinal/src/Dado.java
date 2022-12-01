import java.util.Random;

public class Dado{
    private int valor;
    private Random gerador;

    public Dado() {
        valor = 0;
        gerador = new Random();
    }

    public int rolar(){
        valor = gerador.nextInt(6) + 1; // atualizar para 6 depois
        System.out.println(toString());
        return valor;
    }
    
    public int rolagem(){
        valor = gerador.nextInt(6) + 1; // atualizar para 6 depois
        return valor;
    }

    @Override
    public String toString() {
        switch(valor) {
            case 1:
              return "Voce rolou o dado e tirou 1.\n";
            case 2:
                return "Voce rolou o dado e tirou 2.\n";
            case 3:
                return "Voce rolou o dado e tirou 3.\n";
             case 4:
                 return "Voce rolou o dado e tirou uma bomba.\n";
             case 5:
                 return "Voce rolou o dado e tirou uma bomba.\n"; 
             case 6:
                 return "Voce rolou o dado e ganhou um item!.\n";
          }
        return "";
    }
}
