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

        labelTurn();

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
            if(xo[pos] != "X" && xo[pos] != "O") {
                calculateTurn(pos);
            }
        }
    }

    // Заменяет значения кнопок на str
    void changer(String str) {
        for (int i = 0; i < 9; i++) {
            changerOne(i, str);
        }
    }

    // Заменяет значение кнопки а на str
    void changerOne(int a, String str){
        xo[a] = str;
        btn[a].setText(str);
    }

    // Убирает значения всех кнопок
    void clickReset() {
        changer("");
        playable = true;
        firstPlayerFirst = !firstPlayerFirst;
        firstPlayerTurn = firstPlayerFirst;
        labelTurn();
    }

    // Переключает режим и работает как clickReset()
    void clickMode() {
        changer("");
        playable = true;
        firstPlayerFirst = true;
        versusAI = !versusAI;
        modeBtn.setText(versusAI ? "AI" : "PP");
        labelTurn();
    }

    // Пишет чей сейчас ход
    void labelTurn() {
        label.setText((firstPlayerTurn ? "X" : "O") + " turn!");
    }

    //Проверить на ничью
    boolean draw() {
        for(int i = 0; i < 9; i++) {
            String a = xo[i];
            if((a != "X") && (a != "O")) {
                return false;
            }
        }
        return true;
    }

    // Определение типы игры
    void calculateTurn(int p) {
        ppGame(p);
    }

    // Ходят игроки
    void ppGame(int pInh) {
        changerOne(pInh, firstPlayerTurn ? "X" : "O");
        if(new Check(xo).checkWin()){
            playable = !playable;
            label.setText((firstPlayerTurn ? "X" : "O") + " wins!");
            return;
        }
        System.out.println(draw());
        System.out.println(xo[pInh]);
        if(draw()){
            playable = !playable;
            label.setText("Draw!");
            return;
        }
        firstPlayerTurn = !firstPlayerTurn;
        labelTurn();
    }
}
