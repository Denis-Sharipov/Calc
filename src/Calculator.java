import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator { //Калькулятор.
    public static String Calc(String inputString) {
        String result = ""; //Результат, который будет на выходе.
        int romeNumbs = 0; //Количество римских чисел (чтобы понимать, в каком формате выводить значения).
        String[] inputArray = ToArray.InputArray(inputString); //Преобразование строки на входе в массив.
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].toUpperCase().contains("I") || inputArray[i].toUpperCase().contains("V") || inputArray[i].toUpperCase().contains("X")){ //Проверка на римские числа.
                inputArray[i] = toArabic.arabicValue(inputArray[i]); //Преобразование римского числа в арабское.
                romeNumbs++; //+1 римское число в копилку, если число прошло по условию.
            }
            i++; //Переход на индекс 3, так как 2-й элемент массива - это операция.
        }
        if (romeNumbs!=0&&romeNumbs!=2) throw new NullPointerException("Нельзя производить операции между римскими и арабскими числами!");
        try{
            int numb1 = Integer.parseInt(inputArray[0]); //Первое число.
            int numb2 = Integer.parseInt(inputArray[2]); //Второе число.

            if (numb1 < 0 || numb1 > 10 || numb2 < 0 || numb2 > 10)
                throw new NullPointerException("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более!");

            char oper = inputArray[1].charAt(0); //Операция между числами.
            result = operation(numb1, numb2, oper); //Произведение операции.

            if (romeNumbs == 2) {
                result = toRoman.romanValue(result); //Преобразование числа в римский формат, если оба числа на входе были римскими.
            }
        }
        catch (NumberFormatException ex){
            ex.printStackTrace(); //Если на вход вместо чисел подаются неправильные символы (к примеру, прочие буквы из алфавита), то выдаётся ошибка.
            System.out.println("Введены несуществующие числа!");
        }
        return result; //Возвращение результата.
    }

    public static String operation(int numb1, int numb2, char oper) { //Операция.
        String result;
            switch (oper) {
                case '+': //Сложение.
                    result = Integer.toString(numb1 + numb2);
                    break;
                case '-': //Вычитание.
                    result = Integer.toString(numb1 - numb2);
                    break;
                case '*': //Умножение.
                    result = Integer.toString(numb1 * numb2);
                    break;
                case '/': //Деление.
                    result = Integer.toString(numb1 / numb2);
                    break;
                default: //Если введённого действия не существует, то выдаётся ошибка.
                    throw new UnsupportedOperationException("Введена несуществующая операция!");
            }
        return result;
    }
}



