import javax.script.ScriptException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ExpressionException, ScriptException { // Тело программы.

        Scanner input = new Scanner(System.in); // Cоздал объект input класса Scanner для ввода даных.
        System.out.println("Введите выражение:"); // Команда пользователю для ввода выражения.
        String expres = input.nextLine(); // Создается строка с выражением введеным ползователем.

        String [] expresToList = expres.split("\s"); // Массив для передачи в конструктор класса.
        CheckExpression checkUserInput = new CheckExpression(expresToList);

        System.out.println(checkUserInput.checkLearnExpression());
        System.out.println(checkUserInput.checkMathSymbol());
        System.out.println(checkUserInput.checkNumbersExpressionArabic());
        System.out.println(checkUserInput.checkNumberExpressionRoman());
        System.out.println(checkUserInput.calculationArabicNumbers());


        System.out.println(("Выводится пример пользователя %s".formatted(calc(expres))  )); // Вызывается метод calc,
        // который принимает и возвращает результат выражения.
    }

    public static String calc(String input) {

        return input;
    }
}