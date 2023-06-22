package org.example;

import javax.swing.*;
import java.awt.*;

public class CalcForm extends JFrame {
    private final JTextField textField = new JTextField();
    private final JButton buttonClear = new JButton("Clear");
    private final JButton buttonHistory = new JButton("History");
    private final JButton buttonAdd = new JButton("+");
    private final JButton buttonSub = new JButton("-");
    private final JButton buttonMult = new JButton("*");
    private final JButton buttonDiv = new JButton("/");
    private final JButton buttonSqrt = new JButton("sqrt");
    private final JButton buttonDegree = new JButton("^");
    private final JButton buttonLogE = new JButton("loge");
    private final JButton buttonLog10 = new JButton("log10");
    private final JButton buttonSin = new JButton("sin");
    private final JButton buttonCos = new JButton("cos");
    private final JButton buttonTg = new JButton("tg");
    private final JButton buttonCtg = new JButton("ctg");
    private final JButton buttonComma = new JButton(".");
    private final JButton buttonNeg = new JButton("Negative");
    private final JButton buttonEq = new JButton("=");

    CalcForm() {
        super("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        Store store = new Store(textField);

        buttonClear.addActionListener(new ButtonActionClickListener(store, ButtonType.CLEAR));
        buttonAdd.addActionListener(new ButtonActionClickListener(store, ButtonType.SUM));
        buttonSub.addActionListener(new ButtonActionClickListener(store, ButtonType.SUB));
        buttonMult.addActionListener(new ButtonActionClickListener(store, ButtonType.MULT));
        buttonDiv.addActionListener(new ButtonActionClickListener(store, ButtonType.DIV));
        buttonSqrt.addActionListener(new ButtonActionClickListener(store, ButtonType.SQRT));
        buttonDegree.addActionListener(new ButtonActionClickListener(store, ButtonType.POW));
        buttonLogE.addActionListener(new ButtonActionClickListener(store, ButtonType.LOGE));
        buttonLog10.addActionListener(new ButtonActionClickListener(store, ButtonType.LOG10));
        buttonSin.addActionListener(new ButtonActionClickListener(store, ButtonType.SIN));
        buttonCos.addActionListener(new ButtonActionClickListener(store, ButtonType.COS));
        buttonTg.addActionListener(new ButtonActionClickListener(store, ButtonType.TAN));
        buttonCtg.addActionListener(new ButtonActionClickListener(store, ButtonType.CTAN));
        buttonEq.addActionListener(new ButtonEqualClickListener(store));
        buttonComma.addActionListener(new ButtonNumberClickListener(store, "."));
        buttonNeg.addActionListener(new ButtonNumberClickListener(store, "-"));
        buttonHistory.addActionListener(new ButtonActionClickListener(store, ButtonType.OPEN_HISTORY));

        textField.setText("0");
        textField.setFont(new Font("Serif", Font.BOLD, 32));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setEditable(false);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 1));

        JPanel panelHeader = new JPanel();
        panelHeader.setLayout(new GridLayout(1, 2));

        JPanel panelHeader1 = new JPanel();
        panelHeader1.setLayout(new GridLayout(1, 2));

        panelHeader1.add(buttonClear);
        panelHeader1.add(buttonEq);
        panelHeader1.add(buttonHistory);

        panelHeader.add(textField);
        panelHeader.add(panelHeader1);

        JPanel panelActions = new JPanel();
        panelActions.setLayout(new GridLayout(1, 6));
        panelActions.add(buttonAdd);
        panelActions.add(buttonSub);
        panelActions.add(buttonMult);
        panelActions.add(buttonDiv);
        panelActions.add(buttonSqrt);
        panelActions.add(buttonDegree);

        JPanel panelActions2 = new JPanel();
        panelActions2.setLayout(new GridLayout(1, 6));
        panelActions2.add(buttonLogE);
        panelActions2.add(buttonLog10);
        panelActions2.add(buttonSin);
        panelActions2.add(buttonCos);
        panelActions2.add(buttonTg);
        panelActions2.add(buttonCtg);

        container.add(panelHeader);
        container.add(panelActions);
        container.add(panelActions2);

        //С этого момента рисуются кнопки с цифрами

        JPanel panelNumbers = new JPanel();
        panelNumbers.setLayout(new GridLayout(1, 6));

        for (int i = 0; i < 6; i++) {
            JButton but = new JButton(String.valueOf(i));
            but.addActionListener(new ButtonNumberClickListener(store, String.valueOf(i)));
            panelNumbers.add(but);
        }

        JPanel panelNumbers2 = new JPanel();
        panelNumbers2.setLayout(new GridLayout(1, 6));

        for (int i = 6; i <= 9; i++) {
            JButton but = new JButton(String.valueOf(i));
            but.addActionListener(new ButtonNumberClickListener(store, String.valueOf(i)));
            panelNumbers2.add(but);
        }

        //Добавление кнопок "точка" и "негатив" (добавляет минус в начало числа)
        panelNumbers2.add(buttonComma);
        panelNumbers2.add(buttonNeg);

        container.add(panelNumbers);
        container.add(panelNumbers2);
    }
}
