import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //Программа выполнена Денисом Шариповым. Ссылка на VK: https://vk.com/rain_zetios.

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input:");
	    String inputString = reader.readLine(); //Строка на входе.
        System.out.println("Output:");
        System.out.println(Calculator.Calc(inputString)); //Строка на выходе.
    }


}
