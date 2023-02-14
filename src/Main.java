import java.util.Scanner;

public class Main {

    public static String calculator () throws MyException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your string: ");
        String userStr = sc.nextLine();

        String[] userArr = userStr.split(" ");
        if (userArr.length != 3)
            throw new MyException("Incorrect insert");

        String operator = operatorCheck(userArr[1]);

        int arabNum1 = toArabian(userArr[0]);
        int arabNum2 = toArabian(userArr[2]);

        if ((arabNum1 != 0) && (arabNum2 != 0)) {
            if (count(arabNum1, arabNum2, operator) > 0)
                return toRoman(count(arabNum1, arabNum2, operator));
            else throw new MyException("Rome result should be positive");
        };

        int num1 = numCheck(userArr[0]);
        int num2 = numCheck(userArr[2]);

        return "" + count(num1, num2, operator);
    };


    public static String toRoman (int num) {
        int[] tryArabian = new int[] {1, 4, 5, 9, 10, 40, 50, 90, 100};
        String[] tryRoman = new String[] {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};

        String numRoman = "";
        int i = tryArabian.length - 1;

        while (num > 0) {
            if (num >= tryArabian[i]) {
                numRoman += tryRoman[i];
                num -= tryArabian[i];
            }
            else i--;
        }
        return numRoman;

    }


    public static int toArabian (String romanNum) {
        switch (romanNum) {
            case "I": return 1;
            case "II": return 2;
            case "III": return 3;
            case "IV": return 4;
            case "V": return 5;
            case "VI": return 6;
            case "VII": return 7;
            case "VIII": return 8;
            case "IX": return 9;
            case "X": return 10;
        }
        return 0;
    }


    public static String operatorCheck (String operator) throws MyException {
        if ((!operator.equals("+")) && (!operator.equals("-")) && (!operator.equals("*")) && (!operator.equals("/"))) {
            throw new MyException("Incorrect operator");
        }

        return operator;
    }


    public static int numCheck (String str) throws MyException {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new MyException("Incorrect number");
        };

        if (num > 10) {
            throw new MyException ("Number > 10");
        } if (num < 1) {
            throw new MyException ("Number < 1");
        };

        return num;
    }


    public static int count (int num1, int num2, String operator) {

        switch (operator) {
            case "+": return (num1 + num2);
            case "-": return (num1 - num2);
            case "*": return (num1 * num2);
            case "/": return (int) (num1 / num2);
        };
        return 0;
    }


    public static void main(String[] args) throws MyException {

        System.out.println(calculator());

    }
}

