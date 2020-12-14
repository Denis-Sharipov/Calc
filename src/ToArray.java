public class ToArray {
    public static String[] InputArray(String inputString) {
        //Преобразование полученной строки в массив.
        String[] inputArray = inputString.split(" "); //Разделение на массив по пробелу.
        if (inputArray.length != 3){
            throw new NullPointerException("Строка введена неверно! Введите строку по следующему образцу: \"число1 операция число2\"!");
        }
        return inputArray;
    }

}
