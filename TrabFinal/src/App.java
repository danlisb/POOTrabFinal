public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Bem-Vindo!");

        JogoDaExplosao jogo = new JogoDaExplosao();
        jogo.iniciarJogadores();
        jogo.rodada();
    }
}
