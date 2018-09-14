package leetcode.easy.numbers;

public class DecimalToRomanNumeral {

	
	public static String getDecimalToRomanNumeral(int num) {
	    if (num < 1 || num > 3999)
	        return "Invalid Roman Number Value";
	    String x = "";
	    while (num >= 1000) {
	        x += "M";
	        num -= 1000;        }
	    while (num >= 900) {
	        x += "CM";
	        num -= 900;
	    }
	    while (num >= 500) {
	        x += "D";
	        num -= 500;
	    }
	    while (num >= 400) {
	        x += "CD";
	        num -= 400;
	    }
	    while (num >= 100) {
	        x += "C";
	        num -= 100;
	    }
	    while (num >= 90) {
	        x += "XC";
	        num -= 90;
	    }
	    while (num >= 50) {
	        x += "L";
	        num -= 50;
	    }
	    while (num >= 40) {
	        x += "XL";
	        num -= 40;
	    }
	    while (num >= 10) {
	        x += "X";
	        num -= 10;
	    }
	    while (num >= 9) {
	        x += "IX";
	        num -= 9;
	    }
	    while (num >= 5) {
	        x += "V";
	        num -= 5;
	    }
	    while (num >= 4) {
	        x += "IV";
	        num -= 4;
	    }
	    while (num >= 1) {
	        x += "I";
	        num -= 1;
	    }    
	    return x;
	}
}
