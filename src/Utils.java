import java.io.InputStream;
import java.util.Scanner;

class Utils{
    /**
     * функция получения значений для переменных
     * @param element название переменной
     * @return значение переменной element,введённое пользователем
     */
    public static double getKey(String element, InputStream stream) {
        System.out.print("Введите значение для переменной " + element + ": ");
        Scanner scanner = new Scanner(stream);
        double value = scanner.nextDouble();
        return value;
    }
}
