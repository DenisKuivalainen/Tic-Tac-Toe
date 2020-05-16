package com.kuivalainen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class Field extends JFrame implements ActionListener {
    JLabel label;
    // As I add, remove and rewrite elements, I supposed to use Arrays instead ArrayList or LinkedList, despite their adventures
    // As swing does not support ID for elements, I use array for this purpose
    JButton[][] btn = new JButton[5][5];
    JButton resetBtn;
    JButton modeBtn;
    JPanel panel;

    String[] xo = new String[25];
    boolean playable = true;
    boolean firstPlayerFirst = true;
    boolean versusAI = true;
    boolean firstPlayerTurn = true;
    Check check;

    Field() {
        super("X! O! Super!");
        this.setSize(378,448);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);

        label = new JLabel("");
        label.setBounds(80, 10, 60, 30);

        resetBtn = new JButton("RST");
        resetBtn.setBounds(220, 10, 60, 30);
        resetBtn.addActionListener(this);


        modeBtn = new JButton("AI");
        modeBtn.setBounds(290, 10, 60, 30);
        modeBtn.addActionListener(this);

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                btn[i][j] = new JButton("");
                btn[i][j].setBounds(10 + j * 70, 60 + i * 70, 60, 60);
                btn[i][j].addActionListener(this);
                panel.add(btn[i][j]);
            }
        }

        labelTurn();

        panel.add(label);
        panel.add(resetBtn);
        panel.add(modeBtn);
        this.add(panel);
    }

    // Button pressed listener
    public void actionPerformed(ActionEvent e) {
        int pos = 0;
        check = new Check(xo);

        if(e.getActionCommand().equals("RST")) {
            clickReset();
        } else if(e.getActionCommand().equals("PP") || e.getActionCommand().equals("AI")) {
            clickMode();
        } else if(playable) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if (e.getSource() == btn[i][j]) {
                        pos = i * 5 + j;
                    }
                }
            }
            if(xo[pos] != "X" && xo[pos] != "O") {
                calculateTurn(pos);
            }
        }
    }

    // Заменяет значения кнопок на str
    // Change ALL buttons' text value
    void changer(String str) {
        for (int i = 0; i < 25; i++) {
            changerOne(i, str);
        }
    }

    // Заменяет значение кнопки а на str
    // Change button text value
    void changerOne(int a, String str){
        int i = (int) (Math.floor(a / 5));
        int j = a % 5;
        xo[a] = str;
        btn[i][j].setText(str);
    }

    // Убирает значения всех кнопок
    // Remove all buttons' text value
    void clickReset() {
        changer("");
        playable = true;
        firstPlayerFirst = !firstPlayerFirst;
        firstPlayerTurn = firstPlayerFirst;
        labelTurn();

        // Если компьютер ходит первым
        // If game starts with code turn
        if(!firstPlayerFirst && versusAI) {
            aiPlays();
        }
    }

    // Переключает режим и работает как clickReset()
    // Change game mode (similar to clickReset())
    void clickMode() {
        changer("");
        playable = true;
        firstPlayerFirst = true;
        versusAI = !versusAI;
        modeBtn.setText(versusAI ? "AI" : "PP");
        labelTurn();
    }

    // Пишет чей сейчас ход
    // Set whos turn it is now
    void labelTurn() {
        label.setText((firstPlayerTurn ? "X" : "O") + " turn!");
    }

    // Определение типы игры
    // Define type of game
    void calculateTurn(int p) {
        if(versusAI) {
            aiSecond(p);
        } else {
            ppGame(p);
        }
    }

    // Ходят игроки
    // PP mode - player vs player
    void ppGame(int pInh) {
        changerOne(pInh, firstPlayerTurn ? "X" : "O");
        if(new Check(xo).checkWin()){
            playable = !playable;
            label.setText((firstPlayerTurn ? "X" : "O") + " wins!");
            return;
        }

        if(check.draw()){
            playable = !playable;
            label.setText("Draw!");
            return;
        }
        firstPlayerTurn = !firstPlayerTurn;
        labelTurn();
    }

    // Игра против компа
    // AI mode - player vs code
    // AI play only after player
    void aiSecond(int pInh) {
        changerOne(pInh, "X");
        if(new Check(xo).checkWin()){
            playable = !playable;
            label.setText((firstPlayerTurn ? "X" : "O") + " wins!");
            return;
        }
        if(check.draw()){
            playable = !playable;
            label.setText("Draw!");
            return;
        }
        firstPlayerTurn = !firstPlayerTurn;
        labelTurn();
        playable = false;
        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                aiPlays();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timertask, 500);
    }

    // Логика хода компьютера
    // Logic of code turn
    void aiPlays() {
        CompMind mind = new CompMind(xo);
        changerOne(mind.getValue(), "O");

        if(new Check(xo).checkWin()){
            playable = false;
            label.setText((firstPlayerTurn ? "X" : "O") + " wins!");
            return;
        } else if(check.draw()){
            playable = false;
            label.setText("Draw!");
            return;
        } else {
            firstPlayerTurn = !firstPlayerTurn;
            labelTurn();
            playable = true;
        }
    }
}
