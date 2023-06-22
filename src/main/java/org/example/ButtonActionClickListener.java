package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Обработчик нажатия клавиш "Действия"
 */
public class ButtonActionClickListener implements ActionListener {
    ButtonType type;
    Store store;

    ButtonActionClickListener(Store store, ButtonType type) {
        this.type = type;
        this.store = store;
    }

    /**
     * Переопределение метода нажатия на кнопку
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (type == ButtonType.OPEN_HISTORY) {
            //Открываем историю
            new CalcHistory(store.history).setVisible(true);
        } else if (type == ButtonType.CLEAR) {
            //Очищаем экран
            store.clear();
        } else {
            //Применяем тип действия и принимает значения чисел
            store.action = type;
            store.setValue();
        }
        //Используем функции, требующие лишь один аргумент
        if (type == ButtonType.SQRT || type == ButtonType.LOGE || type == ButtonType.LOG10 ||
                type == ButtonType.SIN || type == ButtonType.COS || type == ButtonType.TAN ||
                type == ButtonType.CTAN) {
            store.getResult();
        }
    }
}
