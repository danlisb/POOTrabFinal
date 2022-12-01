import java.util.Scanner;

abstract public class Item {
    private String nome;

    public Item(String n) {
        this.nome = n;
    }

    public String getNome() {
        return nome;
    }

    public void usaItem(Jogador jogador, Jogador alvo){
        if(alvo.getPassivo() instanceof Escudo){
            Scanner scanner = new Scanner(System.in);
            String escolha;
            System.out.println("O alvo quer usar o escudo?\ns/n?");
            escolha = scanner.next();
            if(escolha.equals("s")){
                System.out.println("O alvo escolhido está protegigo");
                alvo.resetPassivo();
            }
            else;
            scanner.close();
        }
    }
}
