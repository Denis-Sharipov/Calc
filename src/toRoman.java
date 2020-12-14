import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class toRoman { //Перевод числа в римский формат.
    public static String romanValue(String input) {
        int number = Integer.parseInt(input);
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException("Значение" + number + " не в диапазоне (0,4000]! Данного символа нет в римских числах!");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();


        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    }
    //Согласно п.9 параграфа "Помогут также следующие ресурсы:" из ТЗ (https://jm-program.github.io/task-calculator), пользоваться гуглом не запрещено. :)
    //Код брал с сайта https://www.codeflow.site/ru/article/java-convert-roman-arabic.
    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private int value;

        RomanNumeral(int value) {
        this.value = value;
    }

        public int getValue() {
        return value;
         }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
}
