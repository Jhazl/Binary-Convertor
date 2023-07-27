import java.util.*;


//edit heavily
class SignedDecimalNumber extends DecimalNumber{
	public String sign = "+";
	
	public SignedDecimalNumber(String numberRepresentation){
		super();
		if(numberRepresentation.charAt(0) == '-'){
			sign = "-";
			numberRepresentation = numberRepresentation.substring(1);
		}
		number = numberRepresentation;
	}
	
	public SignedDecimalNumber(SignedMagnitude bin){
		super();
		String numberAsString = bin.toString();
		if(numberAsString.charAt(0) == '1'){
			sign = "-";
		}
		numberAsString = numberAsString.substring(1);
		number = convertBinaryToDecimal(numberAsString);
	}
	
	public static boolean isValid(String decimalRepresentation){
	if(decimalRepresentation.equals("") || decimalRepresentation.equals("-")){return false;}
		if(decimalRepresentation.charAt(0) == '-'){
			decimalRepresentation = decimalRepresentation.substring(1);
		}
		ArrayList<Character> validCharList = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
		boolean isValidDecimal = true;
		for(int i = 0; i<decimalRepresentation.length(); i++){
			char currentChar = decimalRepresentation.charAt(i);
			if(validCharList.indexOf(currentChar) == -1){
				isValidDecimal = false;
			}
		}
		return isValidDecimal;
	}
	
	
	public String toString(){
		return sign + this.number;
	}
	
}