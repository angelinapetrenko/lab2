import java.util.Scanner;

class Utils{
    /**
     * функция получения значений для переменных
     * @param element название переменной
     * @return значение переменной element,введённое пользователем
     */
    public static double getKey(String element) {
        System.out.print("Введите значение для переменной " + element + ": ");
        Scanner scanner = new Scanner(System.in);
        double value = scanner.nextDouble();
        return value;
    }
}
