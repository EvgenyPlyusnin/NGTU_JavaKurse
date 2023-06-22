package org.example;

import javax.swing.*;

public class CalcHistory extends JFrame {
    private final JTextArea textField = new JTextArea();

    CalcHistory(HistoryStore historyStore) {
        super("Calculator History");
        this.setSize(300, 500);

        this.add(textField);

        textField.setEditable(false);
        textField.setAutoscrolls(true);
        textField.setText(historyStore.get());
    }
}
