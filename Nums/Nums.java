public class Nums {
    public static final String[] zeroToNineteen = {"Zero", 
						   "One", 
						   "Two", 
						   "Three", 
						   "Four", 
						   "Five", 
						   "Six", 
						   "Seven", 
						   "Eight", 
						   "Nine", 
						   "Ten", 
						   "Eleven", 
						   "Twelve", 
						   "Thirteen", 
						   "Fourteen",
						   "Fifteen", 
						   "Sixteen", 
						   "Seventeen", 
						   "Eighteen", 
						   "Nineteen"};
    public static final String[] tens = {"Twenty",
					 "Thirty",
					 "Fourty",
					 "Fifty",
					 "Sixty",
					 "Seventy",
					 "Eighty",
					 "Ninety"};
    public static final String hundred = "hundred";
    public static final String thousand = "thousand";
    public static final String million = "million";
    public static final String billion = "billion";
    public static void main(String[] args) {
	System.out.println(convert(183726));
    }

    public static int getFirstDigits(int n) {
	if (getDigits(n) == 1) {
	    return n;
	}
	else {
	    return getFirstDigits(n / 10);
	}
    }

    public static String convert(int n) {
	if (n < 20) {
	    return zeroToNineteen[n];
	}
	else {
	    if (getDigits(n) == 2 || getDigits(n) == 5 || getDigits(n) == 8 || getDigits(n) == 11) {
		return tens[getFirstDigits(n) - 2] + convert(n % 10);
	    }
	    else if (getDigits(n) == 3 || getDigits(n) == 6 || getDigits(n) == 9 || getDigits(n) == 12) {
		return zeroToNineteen[getFirstDigits(n) / 100] + hundred + convert(n % 10);
	    }
	    else if (getDigits(n) == 4) {
		return zeroToNineteen[n / 1000] + thousand + convert(n % 10);
	    }
	    else if (getDigits(n) == 7) {
		return zeroToNineteen[n / 1000000] + million + convert(n % 10);
	    }
	    else if (getDigits(n) == 10) {
		return zeroToNineteen[n / 1000000000] + billion + convert(n % 10);
 	    }
	    else {
		return "That number is too big";
	    }
	}
    }

    public static int getDigits(int n) {
	if (n < 10) {
	    return 1;
	}
	else {
	    return 1 + getDigits(n / 10);
	}
    }

    
}