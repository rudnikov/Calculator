import java.util.HashMap;

public class ConvertDigits {
    /**
     * Этот класс проводит конвертирование цыфр из арабских в римские и наоборот.
     */
//    String number; // Принимает строку, которая может являться римской или арабской цыфрой.
//    public ConvertDigits(String numberUser) {
//        this.number = numberUser;
//    }
    /**
     * Метод конвертирует римскую цыфру в арабскую.
     */
    String convertedRomanToArabic(String numberRoman) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);

        int end = numberRoman.length() - 1;
        char[] arr = numberRoman.toCharArray();
        int numbArab;
        int result = map.get(arr[end]);
        for (int elem = end - 1; elem >= 0; elem--) {
            numbArab = map.get(arr[elem]);

            if (numbArab < map.get(arr[elem + 1])) {
                result -= numbArab;
            } else {
                result += numbArab;
            }
        }
        return String.format("%s", result);
    }
    /**
     * Метод конвертирует римскую цыфру в арабскую.
     */
    String convertedArabianToRoman(String numberArab) throws ExpressionException {
        String[] pomanList = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII",
                "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
                "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"};
        if (numberArab.equals(pomanList[0])) {
            throw new ExpressionException("Ошибка в решении примера: В системе римских цыфр нет 0");
        }
        return pomanList[Integer.parseInt(numberArab)];
    }

}
