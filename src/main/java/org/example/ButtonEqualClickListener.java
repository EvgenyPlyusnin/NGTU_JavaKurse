package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработчик нажатия клавиши "="
 */
public class ButtonEqualClickListener implements ActionListener {
    Store store;

    ButtonEqualClickListener(Store store) {
        this.store = store;
    }

    /**
     * Переопределение метода нажатия на кнопку
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        store.setValue();
        store.getResult();
    }
}
