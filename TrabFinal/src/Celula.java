import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.Color;

public class Celula extends JPanel {
    private final Set<Jogador> jogadores;
    private char tipo;
    
    public Celula(char t) {
        jogadores = new HashSet<>();
        tipo = t;
    }
    
    public void adicionaJogador(Jogador j) {
        jogadores.add(j);
        add(j);
        repaint();
    }
    
    public void removerJogador(Jogador j) {
        jogadores.remove(j);
        remove(j);
        repaint();
    }
    
    public char tipo() {
        return tipo;
    }
 
    public void atualizaVisual() {
        switch(tipo) {
            case 'P':
                this.setBackground(new Color(255,217,102));
                this.setBorder(BorderFactory.createLineBorder(new Color(134,134,134), 1));
                break;
            case 'B':
                this.setBackground(new Color(0, 0, 0));
                this.setBorder(BorderFactory.createLineBorder(new Color(134,134,134), 1));
                break;
        }
    }

    public void colocaPonte() {
        if(tipo != 'T' && tipo != 'V') {
            tipo = 'P';
            atualizaVisual();
        }
        
    }

    public void tiraPonte() {
        if(tipo == 'P') {
            tipo = 'B';
            atualizaVisual();
        }
    }
}
