package org.example;

/**
 * Класс представляющий математические операции над числами
 */
public class MathEngine {
    /**
     * Суммирование чисел
     *
     * @param a Число 1
     * @param b Число 2
     * @return Сумма
     */
    static double sum(double a, double b) {
        return a + b;
    }

    /**
     * Вычитание чисел
     *
     * @param a Число 1
     * @param b Число 2
     * @return Разность
     */
    static double sub(double a, double b) {
        return a - b;
    }

    /**
     * Умножение чисел
     *
     * @param a Число 1
     * @param b Число 2
     * @return Произведение
     */
    static double mult(double a, double b) {
        return a * b;
    }

    /**
     * Деление чисел
     *
     * @param a Число 1
     * @param b Число 2
     * @return Частное
     * @throws DivisionByZeroException Деление на ноль
     */
    static double div(double a, double b) throws DivisionByZeroException {
        if (b == 0) {
            throw new DivisionByZeroException();
        }
        return a / b;
    }

    /**
     * Извлечение из квадратного корня
     *
     * @param a Число
     * @return Результат извлечения
     * @throws SqrtArgumentException Подкоренное выражение отрицательное
     */
    static double sqrt(double a) throws SqrtArgumentException {
        if (a < 0) {
            throw new SqrtArgumentException();
        }
        return Math.sqrt(a);
    }

    /**
     * Возведение в степень
     *
     * @param a Число 1
     * @param b Число 2
     * @return Число в степени
     * @throws BadArgumentException Аргумент не соответствует ОДЗ функции
     */
    static double degree(double a, double b) throws BadArgumentException {
        if (b <= 0) {
            throw new BadArgumentException();
        }
        return Math.pow(a, b);
    }

    /**
     * Натуральный логарифм
     *
     * @param a Число
     * @return Результат натурального логарифма
     * @throws BadArgumentException Аргумент не соответствует ОДЗ функции
     */
    static double loge(double a) throws BadArgumentException {
        if (a <= 0) {
            throw new BadArgumentException();
        }
        return Math.log(a);
    }

    /**
     * Десятичный логарифм
     *
     * @param a Число
     * @return Результат десятичного логарифма
     * @throws BadArgumentException Аргумент не соответствует ОДЗ функции
     */
    static double log10(double a) throws BadArgumentException {
        if (a <= 0) {
            throw new BadArgumentException();
        }
        return Math.log10(a);
    }

    /**
     * Синус
     *
     * @param a Число
     * @return Синус числа
     */
    static double sin(double a) {
        return Math.sin(a);
    }

    /**
     * Косинус
     *
     * @param a Число
     * @return Косинус числа
     */
    static double cos(double a) {
        return Math.cos(a);
    }

    /**
     * Тангенс
     *
     * @param a Число
     * @return Тангенс числа
     */
    static double tan(double a) {
        return Math.tan(a);
    }

    /**
     * Катангенс
     *
     * @param a Число
     * @return Катангенс числа
     */
    static double ctan(double a) {
        return 1 / Math.tan(a);
    }
}
