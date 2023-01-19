import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("Здравствуйте!");
        startProgram();
    }

    static void startProgram() {
        System.out.println("Введите номер программы (1-4), либо введите \"Q\" для выхода.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Программа № ");
        String program = scanner.nextLine();
        if (program.equalsIgnoreCase("q")) {
            System.out.println("До свидания!");
        } else if (program.chars().allMatch(Character::isDigit)) {
            switch (program) {
                case "1" -> ex0();
                case "2" -> ex1();
                case "3" -> ex2();
                case "4" -> ex3();
                case "5" -> ex4();
                default -> {
                    System.out.println("Введен некорректный номер, пожалуйста, попробуйте еще раз.");
                    startProgram();
                }
            }
        } else {
            System.out.println("Ввод некорректен, пожалуйста, попробуйте еще раз.");
            startProgram();
        }
    }

    // Задача 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n)
    static void ex0() {
        System.out.println("Введите число N:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Число N = ");
        String input = scanner.nextLine();
        if (input.chars().allMatch(Character::isDigit)) {
            int num = Integer.parseInt(input);
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }
            System.out.println("Сумма чисел от 1 до " + num + " = " + sum);
        }
        startProgram();
    }

    // Задача 2. Вычислить n! (произведение чисел от 1 до n)
    static void ex1() {
        System.out.println("Введите число N:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Число N = ");
        String input = scanner.nextLine();
        if (input.chars().allMatch(Character::isDigit)) {
            int num = Integer.parseInt(input);
            int mult = 1;
            for (int i = 1; i <= num; i++) {
                mult *= i;
            }
            System.out.println("Произведение чисел (n!) от 1 до " + num + " = " + mult);
        }
        startProgram();
    }

    // Задача 2. Вывести все простые числа от 1 до 1000
    static void ex2() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 2; i < 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                arr.add(i);
            }
        }
        System.out.println(arr);
        startProgram();
    }

    // Задача 3. Реализовать простой калькулятор
    static void ex3() {
        int firstNumber = 0;
        int secondNumber = 0;
        String symbol = "";
        int result = 0;
        while (true) {
            System.out.println("Введите первое число:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Первое число = ");
            String input = scanner.nextLine();
            if (input.chars().allMatch(Character::isDigit)) {
                firstNumber = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Ввод некорректен, пожалуйста, попробуйте еще раз.");
            }
        }

        while (true) {
            System.out.println("Введите второе число:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Второе число = ");
            String input = scanner.nextLine();
            if (input.chars().allMatch(Character::isDigit)) {
                secondNumber = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Ввод некорректен, пожалуйста, попробуйте еще раз.");
            }
        }

        while (true) {
            System.out.println("Введите необходимое дейсвтие (+, -, * или /):");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Действие = ");
            String input = scanner.nextLine();
            if (Objects.equals(input, "+") || Objects.equals(input, "-")
                    || Objects.equals(input, "*") || Objects.equals(input, "/")) {
                symbol = input;
                break;
            } else {
                System.out.println("Ввод некорректен, пожалуйста, попробуйте еще раз.");
            }
        }

        switch (symbol) {
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    System.out.println("На 0 делить нельзя!");
                }
            }
        }
        System.out.println("Результат вычисления " + firstNumber + " " + symbol + " " + secondNumber + " = " + result);
    }

    /* Задача 4. *+Задано уравнение вида q + w = е, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
     * например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
     * Предложить хотя бы одно решение или сообщить, что его нет.
     */
    static void ex4() {
        System.out.println("Введите пример без пробелов, заменив некоторые числа в X и Y " +
                "знаками вопроса в формате (X?+?Y=ZZ):");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выражение = ");
        String text = scanner.nextLine();
        String leftSide = text.split("=")[0];
        String rightSide = text.split("=")[1];
        String numberA = leftSide.split("\\+")[0];
        String numberB = leftSide.split("\\+")[1];
        boolean isSolutionExist = false;

        long countQuestionMark = text.chars().filter(ch -> ch == '?').count();
        for (int i = 0; i < (Math.pow(10, countQuestionMark)); i++) {
            String a = numberA.replace("?", String.format("%d", i));
            String b = "";
            for (int j = 0; j < 10; j++) {
                b = numberB.replace("?", String.format("%d", j));
                if ((Integer.parseInt(a) + Integer.parseInt(b)) == Integer.parseInt(rightSide)) {
                    break;
                }
            }
            if ((Integer.parseInt(a) + Integer.parseInt(b)) == Integer.parseInt(rightSide)) {
                int c = (Integer.parseInt(a) + Integer.parseInt(b));
                System.out.println("Решение уравнения: " + a + " + " + b + " = " + c);
                isSolutionExist = true;
                break;
            }
        }
        if (!isSolutionExist) {
            System.out.println("Решений нет!");
        }
        startProgram();
    }
}
