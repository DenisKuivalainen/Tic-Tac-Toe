package com.kuivalainen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Field extends JFrame implements ActionListener {
    JLabel label;
    JButton[] btn = new JButton[9];
    JButton resetBtn;
    JButton modeBtn;
    JPanel panel;

    String[] xo = new String[9];
    boolean playable = true;
    boolean firstPlayerFirst = true;
    boolean versusAI = true;
    boolean firstPlayerTurn = true;

    Field() {
        super("X! O!");
        this.setSize(235,310);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        label = new JLabel("");
        label.setBounds(10, 10, 60, 30);
        labelTurn();


        resetBtn = new JButton("RST");
        resetBtn.setBounds(80, 10, 60, 30);
        resetBtn.addActionListener(this);

        modeBtn = new JButton("AI");
        modeBtn.setBounds(150, 10, 60, 30);
        modeBtn.addActionListener(this);

        btn[0] = new JButton("");
        btn[0].setBounds(10, 60, 60, 60);

        btn[1] = new JButton("");
        btn[1].setBounds(80, 60, 60, 60);

        btn[2] = new JButton("");
        btn[2].setBounds(150, 60, 60, 60);

        btn[3] = new JButton("");
        btn[3].setBounds(10, 130, 60, 60);

        btn[4] = new JButton("");
        btn[4].setBounds(80, 130, 60, 60);

        btn[5] = new JButton("");
        btn[5].setBounds(150, 130, 60, 60);

        btn[6] = new JButton("");
        btn[6].setBounds(10, 200, 60, 60);

        btn[7] = new JButton("");
        btn[7].setBounds(80, 200, 60, 60);

        btn[8] = new JButton("");
        btn[8].setBounds(150, 200, 60, 60);


        panel.add(label);
        panel.add(resetBtn);
        panel.add(modeBtn);
        for(int i = 0; i < 9; i++){
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }

        this.add(panel);
    }

    public void actionPerformed(ActionEvent e) {
        int pos = 0;

        if(e.getActionCommand().equals("RST")) {
            clickReset();
        } else if(e.getActionCommand().equals("PP") || e.getActionCommand().equals("AI")) {
            clickMode();
        } else if(playable) {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == btn[i]) {
                    pos = i;
                }
            }
            changerOne(pos ,firstPlayerTurn ? "X" : "O");
            firstPlayerTurn = !firstPlayerTurn;
            labelTurn();
        }
    }

    void changer(String str) {
        for (int i = 0; i < 9; i++) {
            xo[i] = str;
            btn[i].setText(str);
        }
    }

    void changerOne(int a, String str){
        xo[a] = str;
        btn[a].setText(str);
    }

    void clickReset() {
        changer("");
        playable = true;
        firstPlayerFirst = !firstPlayerFirst;
        firstPlayerTurn = firstPlayerFirst;
        labelTurn();
    }

    void clickMode() {
        changer("");
        playable = true;
        firstPlayerFirst = true;
        versusAI = !versusAI;
        modeBtn.setText(versusAI ? "AI" : "PP");
        labelTurn();
    }

    void labelTurn() {
        label.setText((firstPlayerTurn ? "X" : "O") + " turn!");
    }
}
