import java.util.Scanner;
public class Main{

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] subStr;

        System.out.print("Введите выражение: ");
        String num = String.valueOf(in.nextLine());

        System.out.print(calc(num));
    }

    public static String calc (String input) {

        int num1 = -1;
        int num2 = -1;
        String[] subStr;
        String delimeter = "\\ ";
        boolean check = false;
        String outString = "";

        String num = input;

        subStr = input.split(delimeter);
        try {
            num1 = Integer.parseInt(subStr[0]);
            check = true;
        } catch (NumberFormatException e) {}
        try {
            num2 = Integer.parseInt(subStr[2]);
            check = true;
        } catch (NumberFormatException e) {}


        if ((((num1 != -1) && (num2 == -1)) || ((num1 == -1) && (num2 != -1))))
        {
            throw new NullPointerException("Исключение");
        }

        if (check == true && ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10)))
        {
            throw new NullPointerException("Исключение");
        }

        subStr = num.split(delimeter);
        if (subStr.length != 3)
            throw new NullPointerException("Исключение");

        if (check == false)
            switch(subStr[0]) {
                case "X": subStr[0] = "10"; break;
                case "IX": subStr[0] = "9"; break;
                case "VIII": subStr[0] = "8"; break;
                case "VII": subStr[0] = "7"; break;
                case "VI": subStr[0] = "6"; break;
                case "V": subStr[0] = "5"; break;
                case "IV": subStr[0] = "4"; break;
                case "III": subStr[0] = "3"; break;
                case "II": subStr[0] = "2"; break;
                case "I": subStr[0] = "1"; break;
                default: ;


            }
        if (check == false)
            switch(subStr[2]) {
                case "X": subStr[2] = "10"; break;
                case "IX": subStr[2] = "9"; break;
                case "VIII": subStr[2] = "8"; break;
                case "VII": subStr[2] = "7"; break;
                case "VI": subStr[2] = "6"; break;
                case "V": subStr[2] = "5"; break;
                case "IV": subStr[2] = "4"; break;
                case "III": subStr[2] = "3"; break;
                case "II": subStr[2] = "2"; break;
                case "I": subStr[2] = "1"; break;
                default: ;
            }
        try {
            num1 = Integer.parseInt(subStr[0]);
            num2 = Integer.parseInt(subStr[2]);
        } catch (NumberFormatException e) {
            System.err.println("Исключение");
        }

        if ((num1 >= 10) || (num1 < 1) || (num2 >= 10) || (num2 < 1))
            throw new NullPointerException("Исключение");


        int x= 0;
        // производим операцию с ячейкой массива
        switch(subStr[1]) {
            case "+":
                x = (num1+num2);
                break;
            case "-":
                x = (num1-num2);
                break;
            case "*":
                x = (num1*num2);
                break;
            case "/":
                x = (num1/num2);
                break;
        }

        if ((check ==false && x <= 0) || (check ==false && x <= 0 ))
            throw new NullPointerException("Исключение");

        if (check == false){
            num = String.valueOf(Math.abs(x));
            char[] result = num.toCharArray();

            switch(result.length) {
                case 1:
                    num = String.valueOf(result[0]);
                    num = num.replace("9", "VIV");
                    num = num.replace("8", "VIII");
                    num = num.replace("7", "VII");
                    num = num.replace("6", "VI");
                    num = num.replace("5", "V");
                    num = num.replace("4", "IV");
                    num = num.replace("3", "III");
                    num = num.replace("2", "II");
                    num = num.replace("1", "I");
                    outString += num;
                    break;
                case 2:
                    if (x >= 90) {
                        outString +="XC";
                        x -= 90;
                    } else if (x>= 50) {
                        outString +="L";
                        x -= 50;

                    } else if (x>=40){
                        outString +="XL";
                        x -= 40;
                    }


                    while (x>=10) {
                        outString += "X";
                        x -= 10;
                    }
                    switch(x) {
                        case 0: ; break;
                        case 1: outString += "I"; break;
                        case 2: outString += "II"; break;
                        case 3: outString += "III"; break;
                        case 4: outString += "IV"; break;
                        case 5: outString += "V"; break;
                        case 6: outString += "VI"; break;
                        case 7: outString += "VII"; break;
                        case 8: outString +="VIII"; break;
                        case 9: outString +="IX"; break;
                    }
                    break;
                case 3:
                    return "C";
            }
        } else
        {
            outString = Integer.toString(x);
            return outString;
        }


        return outString;
    }
}