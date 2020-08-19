import java.util.Map;

public class Operation extends Loader {

    public void letsGo() {
        if (checkArabic() || checkRoman()) {
            calc();
        } else {
            System.out.println("Incorrect numbers! Try again!");
        }
    }

    private void calc() {
        int result = 0;

        switch (getOperation()) {
            case '+':
                result = getNum1() + getNum2();
                break;
            case '-':
                result = getNum1() - getNum2();
                break;
            case '*':
                result = getNum1() * getNum2();
                break;
            case '/':
                result = getNum1() / getNum2();
                break;
        }
        if (!checkArabic()) {
            convertArabicToRoman(result);
        }
        if (checkArabic()) {
            System.out.println(result);
        }
    }

    private void convertArabicToRoman(int res) {
        StringBuilder total = new StringBuilder();
        String n1 = "", n2 = "";
        int num2 = res % 10;
        int num1 = res - num2;

        for (Map.Entry<Integer, String> entry : roman.entrySet()) {
            if (entry.getKey().equals(num1)) {
                n1 = entry.getValue();
            }
            if (entry.getKey().equals(num2)) {
                n2 = entry.getValue();
            }
        }
        total.append(n1);
        total.append(n2);
        System.out.println(total.toString());
    }
}
