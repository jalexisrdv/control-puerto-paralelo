package pport;

import controllers.CPort;
import javax.swing.JFrame;
import models.Port;
import views.PanelPort;

/**
 *
 * @author JALEXISRDV
 */
public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame("Lenguajes de Interfaz");
        f.setBounds(100, 100, 500, 300);
        Port port = new Port();//Model
        PanelPort panel = new PanelPort();//View
        CPort cPort = new CPort(port, panel);//Controller
        f.add(panel);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
