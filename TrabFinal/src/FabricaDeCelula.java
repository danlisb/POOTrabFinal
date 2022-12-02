import java.awt.Color;
import javax.swing.BorderFactory;

public final class FabricaDeCelula {
    public static Celula fabrica(char tipo) {
        switch(tipo) {
            case 'T' :  return FabricaDeCelula.torre();
            case 'P' :  return FabricaDeCelula.ponte();
            case 'V' :  return FabricaDeCelula.vazio();
            case 'B' :  return FabricaDeCelula.buraco();
        }
        return null;
    }
    
    private static Celula torre() {
        Celula celula = new Celula('T');
        celula.setBackground(new Color(0, 0, 255));
	celula.setBorder(BorderFactory.createLineBorder(new Color(134,134,134), 1));
        return celula;
    }

    private static Celula ponte() {
        Celula celula = new Celula('P');
        celula.setBackground(new Color(255,217,102));
	celula.setBorder(BorderFactory.createLineBorder(new Color(134,134,134), 1));
        return celula;
    }
    
    private static Celula vazio() {
        Celula celula = new Celula('V');
        celula.setBackground(new Color(0, 0, 0));
	celula.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1));
        return celula;
    }

    private static Celula buraco() {
        Celula celula = new Celula('B');
        celula.setBackground(new Color(0, 0, 0));
	celula.setBorder(BorderFactory.createLineBorder(new Color(134,134,134), 1));
        return celula;
    }
}
