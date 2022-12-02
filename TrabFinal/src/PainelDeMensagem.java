

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PainelDeMensagem extends JPanel {
    private final JLabel mensagem;
    
    public PainelDeMensagem(String texto) {
        mensagem = new JLabel(texto);
        add(mensagem);
    }
    
    public void alterarTexto(String texto) {
        mensagem.setText(texto);
    }
}
