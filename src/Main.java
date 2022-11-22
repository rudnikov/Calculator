import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ExpressionException { // Тело программы.
        Scanner input = new Scanner(System.in); // Cоздал объект input класса Scanner для ввода даных.
        System.out.println("Введите выражение:"); // Команда пользователю для ввода выражения.
        String expres = input.nextLine().strip(); // Создается строка с выражением введеным ползователем.
        System.out.println("Ответ: " + calc(expres)); // Вызывается метод calc, который принимает и возвращает
                                                    // результат выражения.
    }
    /** Выполнение основной программы Калькулятор
     * @param input String (Например 2 + 5)
     * @return String (Ответ решения арифметического выражения)
     * @throws ExpressionException Возможные ошибки при выполнении кода.
     */
    public static String calc(String input) throws ExpressionException {
        // Подготовка данных.
        String[] expresToList = input.split(" "); // Массив для передачи в конструктор класса,
                                                        // цыфры разделены арифметическими знаками.
        CheckExpression checkUserInput = new CheckExpression(expresToList); // Создание экземпляра класса checkUserInput
                                                                            // от класса CheckExpression
        ConvertDigits convetNum = new ConvertDigits(); // Создание экземпляра класса convetNum
                                                    // от класса ConvertDigits

        // Проверка ввода данных
        if (checkUserInput.checkLearnExpression() & checkUserInput.checkMathSymbol()) {
            if (checkUserInput.checkNumbersExpressionArabic()) {
                if ((Integer.parseInt(expresToList[0]) > 10) | (Integer.parseInt(expresToList[2]) > 10)) {
                    throw new ExpressionException("Используются только числа меньше или равные 10");
                }
                return checkUserInput.calculationArabicNumbers(expresToList[0], expresToList[2],
                        expresToList[1]);
            } else if (checkUserInput.checkNumberExpressionRoman()) {
                String numberOne = convetNum.convertedRomanToArabic(expresToList[0]);
                String numberTwo = convetNum.convertedRomanToArabic(expresToList[2]);
                if ((Integer.parseInt(numberOne) > 10) | (Integer.parseInt(numberTwo) > 10)){
                    throw new ExpressionException("Используются только числа меньше или равные X");
                }
                String resultOperate = checkUserInput.calculationArabicNumbers(numberOne, numberTwo, expresToList[1]);
                if (Integer.parseInt(resultOperate) <= 0) {
                    throw new ExpressionException("Ошибка при решении примера: В римских числах нет 0 и отрицательных" +
                            "чисел.");
                }
                return convetNum.convertedArabianToRoman(resultOperate);
            } else throw new ExpressionException("Ошибка ввода данных: В примере могут быть использованы или только " +
                    "арабские числа, или только римские числа (комбинация заглавных латинских букв I, V, X).");
        }
        return "0";
    }
}