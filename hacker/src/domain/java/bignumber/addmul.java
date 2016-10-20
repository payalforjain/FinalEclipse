package domain.java.bignumber;

import java.math.BigDecimal;
import java.util.Scanner;

public class addmul {

	 public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       BigDecimal b1 = sc.nextBigDecimal();
	       BigDecimal b2 = sc.nextBigDecimal();
	       System.out.println(b1.add(b2));
	       System.out.println(b1.multiply(b2));
	    }
}
