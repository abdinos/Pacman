package gameengine.graphicEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {

    private JButton exit_btn = new JButton("Exit");
    private JButton pause_btn = new JButton("Pause");
    private JButton TimeLeft_btn = new JButton("TimeLeft");
    private JLabel labelTimer;
    private JLabel labelscore = new JLabel("score : 0");

    protected JButton getPause_btn() {
        return pause_btn;
    }

    protected JButton getExit_btn() {
        return exit_btn;
    }

    protected JLabel getLabelscore() {
        return labelscore;
    }

    protected JLabel getlabeTimer() {
        return labelTimer;
    }


    protected JLabel getLabelTimer() {
        return labelTimer;
    }


    protected MenuPanel(JButton TimeLeft_btn) {

        super();


        this.add(labelscore);
        this.add(labelTimer);
        this.add(exit_btn);
        this.add(pause_btn);

        this.setLayout(new GridLayout(1, 5));
        this.labelTimer = new JLabel("Timer");


    }
}






















