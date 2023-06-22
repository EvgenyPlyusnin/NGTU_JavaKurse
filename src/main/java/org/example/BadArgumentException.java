package org.example;

/**
 * Класс пользовательской ошибки, представляющий ошибку ОДЗ для некоторых логарифмических функций
 */
public class BadArgumentException extends Exception {
    BadArgumentException() {
        super("Bad Argument Exception");
    }
}
