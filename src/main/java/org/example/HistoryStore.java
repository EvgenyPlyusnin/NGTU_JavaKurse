package org.example;

import java.util.ArrayList;

/**
 * Класс для хранения информации об истории
 */
public class HistoryStore {
    ArrayList<String> history = new ArrayList<>();

    /**
     * Добавить элемент в историю
     *
     * @param type Тип примененной операции
     * @param a    Число 1
     * @param b    Число 2
     */
    void add(ButtonType type, String a, String b) {
        history.add(type + " : " + a + " " + b);
    }

    /**
     * Получить всю историю
     *
     * @return История
     */
    String get() {
        StringBuilder res = new StringBuilder();
        for (String element : history) {
            res.append(element).append("\r\n");
        }
        if (res.toString().equals("")) {
            return "Пока нет данных...";
        }
        return res.toString();
    }
}
