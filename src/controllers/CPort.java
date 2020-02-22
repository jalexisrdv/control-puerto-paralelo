package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import models.Port;
import views.PanelPort;

/**
 *
 * @author JALEXISRDV
 */
public class CPort implements ActionListener, ItemListener {

    private final Port port;
    private final PanelPort panel;

    public CPort(Port port, PanelPort panel) {
        this.port = port;
        this.panel = panel;
        addEventos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        JCheckBox[] cbxs = panel.getAllCbxs();
        JLabel[] lbs = panel.getAllLbs();
        boolean seleccionado = false;
        switch (boton.getName()) {
            case "btnPrender":
                seleccionado = true;
                port.setAllPin(1);
                break;
            case "btnApagar":
                seleccionado = false;
                port.setAllPin(0);
        }
        for (int i = 0; i < cbxs.length; i++) {
            cbxs[i].setSelected(seleccionado);
            if (seleccionado) {
                lbs[i].setBackground(new Color(35, 138, 187));
            } else {
                lbs[i].setBackground(new Color(255, 143, 50));
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JCheckBox box = (JCheckBox) e.getSource();
        int pin = (Integer.parseInt(box.getText().substring(1, 2))) + 2;
        cambiarEstadoPin(pin, box.isSelected());
        cambiarEstadoLed(box.getText(), box.isSelected());
    }

    private void cambiarEstadoLed(String pin, boolean seleccionado) {
        Color color;
        if(seleccionado) {
            color = new Color(35, 138, 187);
        }else {
            color = new Color(255, 143, 50);
        }
        switch (pin) {
            case "D0":
                panel.getLb0().setBackground(color);
                break;
            case "D1":
                panel.getLb1().setBackground(color);
                break;
            case "D2":
                panel.getLb2().setBackground(color);
                break;
            case "D3":
                panel.getLb3().setBackground(color);
                break;
            case "D4":
                panel.getLb4().setBackground(color);
                break;
            case "D5":
                panel.getLb5().setBackground(color);
                break;
            case "D6":
                panel.getLb6().setBackground(color);
                break;
            case "D7":
                panel.getLb7().setBackground(color);

        }
    }

    private void cambiarEstadoPin(int pin, boolean seleccionado) {
        if (seleccionado) {
            System.out.println("Pin: " + pin + " Bit: " + 1);
            port.setPin(pin, 1);
        } else {
            System.out.println("Pin: " + pin + " Bit: " + 0);
            port.setPin(pin, 0);
        }
    }

    private void addEventos() {
        panel.getCbx0().addItemListener(this);
        panel.getCbx1().addItemListener(this);
        panel.getCbx2().addItemListener(this);
        panel.getCbx3().addItemListener(this);
        panel.getCbx4().addItemListener(this);
        panel.getCbx5().addItemListener(this);
        panel.getCbx6().addItemListener(this);
        panel.getCbx7().addItemListener(this);
        panel.getBtnPrenderTodos().addActionListener(this);
        panel.getBtnApagarTodos().addActionListener(this);
    }

}
