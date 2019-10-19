
package roman;

import java.util.LinkedHashMap;
import java.util.regex.*;

public final class RomanNumber extends Number {

  public static final long serialVersionUID = 1L;

  // Table des symboles
  private static final LinkedHashMap<String, Integer> SYMBOLS = new LinkedHashMap<>();
  static {
    SYMBOLS.put("M",  1000);
    SYMBOLS.put("CM", 900);
    SYMBOLS.put("D",  500);
    SYMBOLS.put("CD", 400);
    SYMBOLS.put("C",  100);
    SYMBOLS.put("XC", 90);
    SYMBOLS.put("L",  50);
    SYMBOLS.put("XL", 40);
    SYMBOLS.put("X",  10);
    SYMBOLS.put("IX", 9);
    SYMBOLS.put("V",  5);
    SYMBOLS.put("IV", 4);
    SYMBOLS.put("I", 1);
  }

  // Expression reguliere de validation
  private static final Pattern VALIDATION_RE = Pattern.compile(
      "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

  private final int value;

  public RomanNumber(String romanValue) {
    this.value = fromRoman(romanValue);
  }

  public RomanNumber(int value) {
  	if(value == 0) {
  		throw new IllegalArgumentException("Il n'y a pas de 0 en chiffre romains");
  	}
  	if(value > 3999) {
			throw new IllegalArgumentException("value is too high");
		}
		if(value < 1) {
			throw new IllegalArgumentException("value is too low");
		}
	  this.value = value;
  }

	public RomanNumber(double value) {
		throw new IllegalArgumentException("On ne peut pas convertir un double en chiffre romain");
	}

  @Override
  public double doubleValue() {
    Double d = new Double(this.value);
    return d;
  }

  @Override
  public float floatValue() {
    float f = (float)this.value;
    return f;
  }

  @Override
  public int intValue() {
    return this.value;
  }

  @Override
  public long longValue() {
    long l = this.value;
    return l;
  }

  @Override
  public String toString() {
    return toRoman(this.value);
  }

  public static RomanNumber valueOf(String roman) {
    return new RomanNumber(roman);
  }
  
  public static RomanNumber valueOf(double roman) {
    return new RomanNumber(roman);
  }

  public static RomanNumber valueOf(int value) {
    return new RomanNumber(value);
  }

  private static int fromRoman(String romanValue) {
    Matcher m = VALIDATION_RE.matcher(romanValue);
		boolean b = m.matches();
		if(b == false){
			throw new IllegalArgumentException("String not valid");
		}
		char[] romNb = romanValue.toCharArray();
		for (int x = 0; x < romNb.length; x++) {
			int n = (int)romNb[x];
			if( 40 > n && 90 < n){
				throw new IllegalArgumentException("must be capital");
			}
		}
		int res = 0;
		for (int i = romNb.length-1 ; i > -1 ; i--) {
			if(i != 0) {
				String tmp = String.valueOf(romNb[i-1]).concat(String.valueOf(romNb[i]));
				if (SYMBOLS.containsKey(tmp)){
					res = res + SYMBOLS.get(String.valueOf(tmp));
					i--;
					}
				else{
					res = res + SYMBOLS.get(String.valueOf(romNb[i]));
				}
			}
			else {
				res = res + SYMBOLS.get(String.valueOf(romNb[i]));
			}
		}
    return res;
  }

  private static String toRoman(int value) {
	if(value > 3999) {
		throw new IllegalArgumentException("value is too high");
	}
	if(value < 1) {
		throw new IllegalArgumentException("value is too low");
	}
    int n = value;
	String res ="";
	while(n>999){
		n=n-1000;
		res= res + "M";
	}
	while(n>899){
		n=n-900;
		res= res + "CM";
	}
	while(n>499){
		n=n-500;
		res= res + "D";
	}
	while(n>399){
		n=n-400;
		res= res + "CD";
	}
	while(n>99){
		n=n-100;
		res= res + "C";
	}
	while(n>89){
		n=n-90;
		res= res + "XC";
	}
	while(n>49){
		n=n-50;
		res= res + "L";
	}
	while(n>39){
		n=n-40;
		res= res + "XL";
	}
	while(n>9){
		n=n-10;
		res= res + "X";
	}
	while(n>8){
		n=n-9;
		res= res + "IX";
	}
	while(n>4){
		n=n-5;
		res= res + "V";
	}
	while(n>3){
		n=n-4;
		res= res + "IV";
	}
	while(n>0){
		n=n-1;
		res= res + "I";
	}
    return res;
  }
  
}
