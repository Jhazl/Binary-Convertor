import java.util.*;


class DecimalNumber{
	public String number;
	
	public DecimalNumber(){
		number = "";
	}
	
	public DecimalNumber(String numberRepresentation){
		number = numberRepresentation;
	}
	
	public DecimalNumber(Binary bin){
		String numberAsString = bin.toString();
		number = convertBinaryToDecimal(numberAsString);
	}
	
	public static boolean isValid(String decimalRepresentation){
		if(decimalRepresentation.equals("")){return false;}
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
	
	public String convertBinaryToDecimal(String binary){
		double decimalNumber = 0;
		double count = 0;
		for(int i = binary.length() - 1; i >= 0; i--){
			int currentBit = Integer.parseInt(binary.substring(i, i+1));
			decimalNumber += currentBit * Math.pow(2, count++);
			
		}
		return String.format("%.0f", decimalNumber);
	}
	
	public String toString(){
		return this.number;
	}
	
}