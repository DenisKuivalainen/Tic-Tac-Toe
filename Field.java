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
    JButton[] btn = new JButton[25];
    JButton resetBtn;
    JButton modeBtn;
    JPanel panel;

    String[] xo = new String[25];
    boolean playable = true;
    boolean firstPlayerFirst = true;
    boolean versusAI = true;
    boolean firstPlayerTurn = true;

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

        btn[0] = new JButton("");
        btn[0].setBounds(10, 60, 60, 60);

        btn[1] = new JButton("");
        btn[1].setBounds(80, 60, 60, 60);

        btn[2] = new JButton("");
        btn[2].setBounds(150, 60, 60, 60);

        btn[3] = new JButton("");
        btn[3].setBounds(220, 60, 60, 60);

        btn[4] = new JButton("");
        btn[4].setBounds(290, 60, 60, 60);

        btn[5] = new JButton("");
        btn[5].setBounds(10, 130, 60, 60);

        btn[6] = new JButton("");
        btn[6].setBounds(80, 130, 60, 60);

        btn[7] = new JButton("");
        btn[7].setBounds(150, 130, 60, 60);

        btn[8] = new JButton("");
        btn[8].setBounds(220, 130, 60, 60);

        btn[9] = new JButton("");
        btn[9].setBounds(290, 130, 60, 60);

        btn[10] = new JButton("");
        btn[10].setBounds(10, 200, 60, 60);

        btn[11] = new JButton("");
        btn[11].setBounds(80, 200, 60, 60);

        btn[12] = new JButton("");
        btn[12].setBounds(150, 200, 60, 60);

        btn[13] = new JButton("");
        btn[13].setBounds(220, 200, 60, 60);

        btn[14] = new JButton("");
        btn[14].setBounds(290, 200, 60, 60);

        btn[15] = new JButton("");
        btn[15].setBounds(10, 270, 60, 60);

        btn[16] = new JButton("");
        btn[16].setBounds(80, 270, 60, 60);

        btn[17] = new JButton("");
        btn[17].setBounds(150, 270, 60, 60);

        btn[18] = new JButton("");
        btn[18].setBounds(220, 270, 60, 60);

        btn[19] = new JButton("");
        btn[19].setBounds(290, 270, 60, 60);

        btn[20] = new JButton("");
        btn[20].setBounds(10, 340, 60, 60);

        btn[21] = new JButton("");
        btn[21].setBounds(80, 340, 60, 60);

        btn[22] = new JButton("");
        btn[22].setBounds(150, 340, 60, 60);

        btn[23] = new JButton("");
        btn[23].setBounds(220, 340, 60, 60);

        btn[24] = new JButton("");
        btn[24].setBounds(290, 340, 60, 60);



        labelTurn();

        panel.add(label);
        panel.add(resetBtn);
        panel.add(modeBtn);
        for(int i = 0; i < 25; i++){
            btn[i].addActionListener(this);
            panel.add(btn[i]);
        }
        this.add(panel);
    }

    // Button pressed listener
    public void actionPerformed(ActionEvent e) {
        int pos = 0;

        if(e.getActionCommand().equals("RST")) {
            clickReset();
        } else if(e.getActionCommand().equals("PP") || e.getActionCommand().equals("AI")) {
            clickMode();
        } else if(playable) {
            for (int i = 0; i < 25; i++) {
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
    // Change ALL buttons' text value
    void changer(String str) {
        for (int i = 0; i < 25; i++) {
            changerOne(i, str);
        }
    }

    // Заменяет значение кнопки а на str
    // Change button text value
    void changerOne(int a, String str){
        xo[a] = str;
        btn[a].setText(str);
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

    // Проверить на ничью
    // Check if the game is ended with draw
    boolean draw() {
        for(int i = 0; i < 25; i++) {
            String a = xo[i];
            if((a != "X") && (a != "O")) {
                return false;
            }
        }
        return true;
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

        if(draw()){
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
        if(draw()){
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
        } else if(draw()){
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
