package org.example;

/**
 * Класс пользовательской ошибки, представляющий извлечение отрицательного числа из под корня
 */
public class SqrtArgumentException extends Exception {
    SqrtArgumentException() {
        super("Sqrt Argument Exception");
    }
}
