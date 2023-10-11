import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        MathCalc calc = new  MathCalc();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        try {
            System.out.println(calc.calc(input));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
