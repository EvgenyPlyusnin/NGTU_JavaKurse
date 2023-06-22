package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработчик нажатия на клавишу "цифру"
 */
public class ButtonNumberClickListener implements ActionListener {
    String value;
    Store store;

    ButtonNumberClickListener(Store store, String value) {
        this.value = value;
        this.store = store;
    }

    /**
     * Переопределение метода нажатия на кнопку
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        store.showData(value);
    }
}
