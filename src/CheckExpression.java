import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CheckExpression {
    /** Этот класс может проводить манипуляции с введенным примером пользователя.*/
    String [] expressionListUser; // Массив символов выражения введенного пользователем.

    public CheckExpression(String [] expression) {
        this.expressionListUser = expression;
    }

    String symbols = "+*/-"; // Вычислительные операции, которые могут использоваться в примере.
    String romanNumbers = "IVX"; // Основные знаки римских чисел, которые могут быть использованы в примере.


    /** Метод проверяет длинну примера. Если пример состоит из 3 элементов,вернется true, если менее
     * или более 3 элементов, тогда вернется false.*/
    boolean checkLearnExpression() throws ExpressionException {

        if (expressionListUser.length != 3) {
            throw new ExpressionException("Ошибка ввода данных: В веденном выражении должно присутствовать два чилса (операнда)" +
                    "(от 0 до 10), разделенные одной арифметической операцией (+, -, *, /).");
        }
        return true;
    }

    /** Метод проверяет какая математическая операция используется в примере. При неверной операции вернется false.*/
    boolean checkMathSymbol() throws ExpressionException {

        if (!symbols.contains(expressionListUser[1])) {
            throw new ExpressionException("Ошибка ввода данных: Введена неверная математическая операция.");
            }
        return true;
    }

    /** Метод првоеряет арабская система цыфр используется в выражении.*/
    boolean checkNumbersExpressionArabic() {
        return ((Character.isDigit(expressionListUser[0].codePointAt(0)) &
                Character.isDigit(expressionListUser[2].codePointAt(0))));
    }

    /** Метод првоеряет римская система цыфр используется в выражении.*/
    boolean checkNumberExpressionRoman() {
        String [] num1 = expressionListUser[0].split("");
        String [] num2 = expressionListUser[2].split("");
        boolean variableFlag = true;

        for (String ch: num1) {
            if (!romanNumbers.contains(ch)) {
                variableFlag = false;
                return variableFlag;
            }
        }

        for (String ch2: num2) {
            if (!romanNumbers.contains(ch2)) {
                variableFlag = false;
                return variableFlag;
            }
        }
        return variableFlag;
    }

    /** Метод решает пример с арабскими цыфрами.*/
    ScriptEngine calculationArabicNumbers() throws ArithmeticException, ScriptException {
        if (expressionListUser[1].equals("/") & Integer.parseInt(expressionListUser[2]) == 0) {
            throw new ArithmeticException("Ошибка ввода данных: Нельзя делить на 0.");
        }
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return (ScriptEngine) engine.eval(String.format(expressionListUser[0], expressionListUser[1],
                expressionListUser[2]));
    }

}
