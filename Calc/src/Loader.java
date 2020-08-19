import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class Loader {

    private int num1;
    private int num2;
    private int convertNum;
    private char operation;

    TreeMap<Integer, String> roman = new TreeMap<>();

    Scanner in = new Scanner(System.in);
    String getStr = in.nextLine();
    String[] splitS = getStr.split("\\s");

    public boolean checkArabic() {
        return getStr.matches("[0-9,10]\\s[+|\\-|/|*]\\s[0-9,10]");
    }

    public boolean checkRoman() {
        return getStr.matches("(I|V|X)+\\s[+|\\-|/|*]\\s(I|V|X)+");
    }

    private boolean isCorrectChar(String str) {
        return (str.matches("[+-/*]"));
    }

    private int strToInt(String in) {
        return Integer.parseInt(in);
    }

    final public int getNum1() {
        if (checkArabic() && toInt(splitS[0]) < 11) {
            num1 = strToInt(splitS[0]);
        }
        if (checkRoman() && toInt(splitS[0]) < 11) {
            num1 = toInt(splitS[0]);
        }
        return num1;
    }

    final public int getNum2() {
        if (checkArabic() && toInt(splitS[2]) < 11) {
            num2 = strToInt(splitS[2]);
        }
        if (checkRoman() && toInt(splitS[2]) < 11) {
            num2 = toInt(splitS[2]);
        }
        return num2;
    }

    final public char getOperation() {
        if (isCorrectChar(splitS[1])) {
            operation = splitS[1].charAt(0);
        }
        return operation;
    }

    public int toInt(String s) {
        roman.put(1, "I");
        roman.put(2, "II");
        roman.put(3, "III");
        roman.put(4, "IV");
        roman.put(5, "V");
        roman.put(6, "VI");
        roman.put(7, "VII");
        roman.put(8, "VIII");
        roman.put(9, "VIIII");
        roman.put(10, "X");
        roman.put(20, "XX");
        roman.put(30, "XXX");
        roman.put(40, "XL");
        roman.put(50, "L");
        roman.put(60, "LX");
        roman.put(70, "LXX");
        roman.put(80, "LXXX");
        roman.put(90, "XC");
        roman.put(100, "C");

        for (Map.Entry<Integer, String> entry : roman.entrySet()) {
            if (Objects.equals(s, entry.getValue())) {
                convertNum = entry.getKey();
            }
        }
        return convertNum;
    }
}