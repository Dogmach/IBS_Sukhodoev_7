package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void calculate(org.example.Сalculating calc) {

        Scanner scan = new Scanner(System.in);
        try {
            System.out.print("Введите первое число: ");
            float a = scan.nextFloat();
            System.out.print("Введите второе число: ");
            float b = scan.nextFloat();

            System.out.print("Введите действие : ");
            String someOp = scan.nextLine();
            someOp = scan.nextLine();

            int errorCode = calc.result(a, b, someOp);
            if (errorCode == Сalculating.ERROR_no) {
                System.out.printf("Ответ: " + a + " " + someOp + " " + b + " = %.4f", calc.getValue());
            } else {
                System.err.println("ОШИБКА: " + calc.getErrorText(errorCode));
            }
        } catch (InputMismatchException e) {
            System.err.println("ОШИБКА: Некорректный формат введенных данных");
        } catch (ArithmeticException e) {
            System.err.println("ОШИБКА: Деление на ноль запрещено");
        } catch (Exception e) {
            System.err.println("ОШИБКА: Обратитесь к разработчику");
        } finally {
            scan.close();
        }
    }

    public static void main(String[] args) {
        Сalculating calc = new Сalculating();
        calculate(calc);
    }
}