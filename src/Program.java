import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        System.out.println("������������!");
        startProgram();
    }

    static void startProgram() {
        System.out.println("������� ����� ��������� (1-4), ���� ������� \"Q\" ��� ������.");
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������� � ");
        String program = scanner.nextLine();
        if (program.equalsIgnoreCase("q")) {
            System.out.println("�� ��������!");
        } else if (program.chars().allMatch(Character::isDigit)) {
            switch (program) {
                case "1" -> ex0();
                case "2" -> ex1();
                case "3" -> ex2();
                case "4" -> ex3();
                case "5" -> ex4();
                default -> {
                    System.out.println("������ ������������ �����, ����������, ���������� ��� ���.");
                    startProgram();
                }
            }
        } else {
            System.out.println("���� �����������, ����������, ���������� ��� ���.");
            startProgram();
        }
    }

    // ������ 1. ��������� n-�� ������������ �����(����� ����� �� 1 �� n)
    static void ex0() {
        System.out.println("������� ����� N:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("����� N = ");
        String input = scanner.nextLine();
        if (input.chars().allMatch(Character::isDigit)) {
            int num = Integer.parseInt(input);
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }
            System.out.println("����� ����� �� 1 �� " + num + " = " + sum);
        }
        startProgram();
    }

    // ������ 2. ��������� n! (������������ ����� �� 1 �� n)
    static void ex1() {
        System.out.println("������� ����� N:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("����� N = ");
        String input = scanner.nextLine();
        if (input.chars().allMatch(Character::isDigit)) {
            int num = Integer.parseInt(input);
            int mult = 1;
            for (int i = 1; i <= num; i++) {
                mult *= i;
            }
            System.out.println("������������ ����� (n!) �� 1 �� " + num + " = " + mult);
        }
        startProgram();
    }

    // ������ 2. ������� ��� ������� ����� �� 1 �� 1000
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

    // ������ 3. ����������� ������� �����������
    static void ex3() {
        int firstNumber = 0;
        int secondNumber = 0;
        String symbol = "";
        int result = 0;
        while (true) {
            System.out.println("������� ������ �����:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("������ ����� = ");
            String input = scanner.nextLine();
            if (input.chars().allMatch(Character::isDigit)) {
                firstNumber = Integer.parseInt(input);
                break;
            } else {
                System.out.println("���� �����������, ����������, ���������� ��� ���.");
            }
        }

        while (true) {
            System.out.println("������� ������ �����:");
            Scanner scanner = new Scanner(System.in);
            System.out.print("������ ����� = ");
            String input = scanner.nextLine();
            if (input.chars().allMatch(Character::isDigit)) {
                secondNumber = Integer.parseInt(input);
                break;
            } else {
                System.out.println("���� �����������, ����������, ���������� ��� ���.");
            }
        }

        while (true) {
            System.out.println("������� ����������� �������� (+, -, * ��� /):");
            Scanner scanner = new Scanner(System.in);
            System.out.print("�������� = ");
            String input = scanner.nextLine();
            if (Objects.equals(input, "+") || Objects.equals(input, "-")
                    || Objects.equals(input, "*") || Objects.equals(input, "/")) {
                symbol = input;
                break;
            } else {
                System.out.println("���� �����������, ����������, ���������� ��� ���.");
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
                    System.out.println("�� 0 ������ ������!");
                }
            }
        }
        System.out.println("��������� ���������� " + firstNumber + " " + symbol + " " + secondNumber + " = " + result);
    }

    /* ������ 4. *+������ ��������� ���� q + w = �, q, w, e >= 0. ��������� ����� ����� ���� �������� ������ �������,
     * �������� 2? + ?5 = 69. ��������� ������������ ��������� �� ������� ���������.
     * ���������� ���� �� ���� ������� ��� ��������, ��� ��� ���.
     */
    static void ex4() {
        System.out.println("������� ������ ��� ��������, ������� ��������� ����� � X � Y " +
                "������� ������� � ������� (X?+?Y=ZZ):");
        Scanner scanner = new Scanner(System.in);
        System.out.print("��������� = ");
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
                System.out.println("������� ���������: " + a + " + " + b + " = " + c);
                isSolutionExist = true;
                break;
            }
        }
        if (!isSolutionExist) {
            System.out.println("������� ���!");
        }
        startProgram();
    }
}
