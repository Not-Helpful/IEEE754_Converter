package project2csc4101;

public class Convertor {
    public static String IEEE754(double input) {
        String returnString;
        String integerPartBinary = stepOne(input);
        String decimalPartBinary = stepTwo(input);
        String exponent = getExponent(integerPartBinary);
        System.out.println(exponent);
        String mantisa = (integerPartBinary.substring(2, integerPartBinary.length())) + decimalPartBinary;
        String signBit = "";
        if (input < 0) {
            signBit += '1';
        } else {
            signBit += '0';
        }
        returnString = signBit + " | " + exponent + " | " + mantisa;
        return returnString;
    }

    private static String stepOne(double input) {
        String returnString = "";
        int integerPart = (int) input;
        returnString = integerToBinary(integerPart);
        
        return returnString;
    }

    private static String stepTwo(double input) {
        String returnString = "";
        int integerPart = (int) input;
        double decimalPart = input - integerPart;
        for (double i = decimalPart; i != 0;) {
            returnString += (int)(i*2);
            i *= 2;
            integerPart = (int) i;
            i = i - integerPart;
        }
        for (int i = returnString.length(); i <= 23; i++) {
            returnString += '0';
        }
        return returnString;
        
    }

    private static String getExponent(String integerPart) {
        int exponent = 0;
        for (int i = 0; i < integerPart.length(); i++) {
            if (integerPart.charAt(i) == '1') {
                exponent = integerPart.length() - i;
            }
        }
        exponent += 127;
        String exponentString = integerToBinary(exponent);
        return exponentString;
    }

    private static String integerToBinary(int inputInteger) {
        String binaryString = "";
        for (int i = inputInteger; i > 0; i = i / 2) {
            if (i % 2 == 1) {
                binaryString += '1';
            } else {
                binaryString += '0';
            }
        }
        binaryString += '0';
        binaryString = reverseString(binaryString);
        return binaryString;
    }

    private static String reverseString(String target) {
        String returnString = "";
        for (int i = target.length() - 1; i >= 0; i--) {
            returnString += target.charAt(i);
        }
        
        return returnString;
    }

}
