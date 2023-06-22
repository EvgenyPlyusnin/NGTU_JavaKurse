package org.example;

import javax.swing.*;

/**
 * Класс для хранения основной информации (состояния) приложения
 */
public class Store {
    Store(JTextField textField) {
        resultField = textField;
    }

    JTextField resultField;
    double a;
    double b;
    ButtonType action = null;
    private boolean isAEmpty = true;
    HistoryStore history = new HistoryStore();
    boolean hasResult = false;

    /**
     * Очиста введенных ранее данных, подготовка к новым подсчетам
     */
    void clear() {
        a = 0;
        b = 0;
        action = null;
        isAEmpty = true;
        hasResult = false;
        resultField.setText("0");
    }

    /**
     * Отобразить введенный символ на экран, если ввели минус - написать его перед числом
     *
     * @param value введенная строка в текстовое поле
     */
    void showData(String value) {
        if (value.equals("-")) {
            if (resultField.getText().startsWith("-")) {
                resultField.setText(resultField.getText().substring(1));
                a = Double.parseDouble(resultField.getText());
                return;
            }
            resultField.setText(value + resultField.getText());
            //Изменить переменную, если поменялся знак
            try {
                if (isAEmpty) {
                    a = Double.parseDouble(resultField.getText());
                    isAEmpty = false;
                } else {
                    b = Double.parseDouble(resultField.getText());
                    hasResult = false;
                }
            } catch (Exception ignored) {
            }

        } else {
            //Если в текстовом поле "0", то можно игнорировать это значение
            if ((resultField.getText()).equals("0")) {
                resultField.setText(value);
                return;
            }
            resultField.setText(resultField.getText() + value);
            if (hasResult) {
                //Изменить переменную, если дописали число справа
                a = Double.parseDouble(resultField.getText());
            }
        }
    }

    /**
     * Задать значение числу и очистить экран
     */
    void setValue() {
        if (isAEmpty) {
            a = Double.parseDouble(resultField.getText());
            isAEmpty = false;
        } else {
            b = Double.parseDouble(resultField.getText());
            hasResult = false;
        }
        resultField.setText("");
    }

    /**
     * Получить результат операции. После равно или функций, требующий один аргумент
     */
    void getResult() {
        String res = "";
        if (action == null) {
            clear();
            return;
        }
        switch (action) {
            case SUM -> {
                res = String.valueOf(MathEngine.sum(a, b));
                history.add(action, String.valueOf(a), String.valueOf(b));
                a = Double.parseDouble(res);
            }
            case SUB -> {
                res = String.valueOf(MathEngine.sub(a, b));
                history.add(action, String.valueOf(a), String.valueOf(b));
                a = Double.parseDouble(res);
            }
            case MULT -> {
                res = String.valueOf(MathEngine.mult(a, b));
                history.add(action, String.valueOf(a), String.valueOf(b));
                a = Double.parseDouble(res);
            }
            case DIV -> {
                try {
                    res = String.valueOf(MathEngine.div(a, b));
                    history.add(action, String.valueOf(a), String.valueOf(b));
                    a = Double.parseDouble(res);
                } catch (Exception e) {
                    res = "Деление на ноль запрещено!!!";
                    history.add(action, res, "");
                    a = 0;
                }
            }
            case SQRT -> {
                try {
                    res = String.valueOf(MathEngine.sqrt(a));
                    history.add(action, String.valueOf(a), "");
                    a = Double.parseDouble(res);
                } catch (Exception e) {
                    res = "Корень из отрицательного числа!!!";
                    history.add(action, res, "");
                    a = 0;
                }
            }
            case POW -> {
                try {
                    res = String.valueOf(MathEngine.degree(a, b));
                    history.add(action, String.valueOf(a), String.valueOf(b));
                    a = Double.parseDouble(res);
                } catch (Exception e) {
                    res = "Отрицательное число!!!";
                    history.add(action, res, "");
                    a = 0;
                }
            }
            case LOGE -> {
                try {
                    res = String.valueOf(MathEngine.loge(a));
                    history.add(action, String.valueOf(a), "");
                    a = Double.parseDouble(res);
                } catch (Exception e) {
                    res = "Отрицательное число!!!";
                    history.add(action, res, "");
                    a = 0;
                }
            }
            case LOG10 -> {
                try {
                    res = String.valueOf(MathEngine.log10(a));
                    history.add(action, String.valueOf(a), "");
                    a = Double.parseDouble(res);
                } catch (Exception e) {
                    res = "Отрицательное число!!!";
                    history.add(action, res, "");
                    a = 0;
                }
            }
            case SIN -> {
                res = String.valueOf(MathEngine.sin(a));
                history.add(action, String.valueOf(a), "");
                a = Double.parseDouble(res);
            }
            case COS -> {
                res = String.valueOf(MathEngine.cos(a));
                history.add(action, String.valueOf(a), "");
                a = Double.parseDouble(res);
            }
            case TAN -> {
                res = String.valueOf(MathEngine.tan(a));
                history.add(action, String.valueOf(a), "");
                a = Double.parseDouble(res);
            }
            case CTAN -> {
                res = String.valueOf(MathEngine.ctan(a));
                history.add(action, String.valueOf(a), "");
                a = Double.parseDouble(res);
            }
            default -> {
                clear();
            }
        }

        //Очистка данных и отображение результата в текстовом поле
        b = 0;
        action = null;
        hasResult = true;
        if (this.isDouble(res)) {
            resultField.setText(String.valueOf((int) a));
        } else {
            resultField.setText(res);
        }
    }

    /**
     * Проверка является ли число дробью
     *
     * @param num Вводимая строка
     * @return Является ли число дробью
     */
    private boolean isDouble(String num) {
        return num.contains(",0") || num.contains(".0");
    }
}
