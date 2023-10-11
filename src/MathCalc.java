import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathCalc {
    private static final List<String> operations = List.of("(", ")", "*", "+", "-", "/", "^");
    public double calc(String expression) throws Exception {
        return 0;
    }
    /**
     * Проверяем является ли строка знаком операции
     * @param str проверяемая строка
     * @return является ли знаком операции
     */
    private boolean isOperation(String str) {
        return operations.contains(str);
    }
    /**
     * Получение приоритета операции
     * @param operation знак операции
     * @return приоритет операции
     * @throws Exception неподдерживаемая операция
     */
    private int getPriority(String operation) throws Exception {
        switch (operation) {
            case "(":
                return -1;
            case "*":
            case "/":
            case "^":
                return 1;
            case "+":
            case "-":
                return 2;
            default:
                throw new Exception("Unknown operation");
        }
    }
    /**
     * Выполнение заданной операции
     * @param a первое число
     * @param b второе число
     * @param operation знак операции
     * @return результат операции
     * @throws Exception неподдерживаемая операция
     */
    private double performOperation(double a, double b, String operation) throws Exception {
        switch (operation) {
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "^":
                return Math.pow(a, b);
        }

        throw new Exception("Unsupported operation '" + operation + "'");
    }
    /**
     * Разделение строки на элементы
     * @param expression исходное выражение
     * @return список элементов в исходном порядке
     */
    private List<String> parseExpression(String expression) {
        List<String> result = new ArrayList<>();

        for (String operation : operations) {
            expression = expression.replace(operation, " " + operation + " "); //расставляем пробелы для разделения
        }

        expression = expression.replaceAll("\\s+", " ");
        for (Object operation : operations.stream().filter(it->!it.equals(")")).collect(Collectors.toList())) {
            expression = expression.replace(operation + " - ", operation + " -");
        }

        Scanner scanner = new Scanner(expression);
        while (scanner.hasNext()) {
            result.add(scanner.next());
        }

        return result;
    }
    /**
     * Проверяем является ли строка числом
     * @param str проверяемая строка
     * @return является ли числом
     */
    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
