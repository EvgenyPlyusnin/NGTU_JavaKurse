package org.example;

/**
 * Класс пользовательской ошибки, представляющий деление на ноль
 */
public class DivisionByZeroException extends Exception {
    DivisionByZeroException() {
        super("Division By Zero");
    }
}
