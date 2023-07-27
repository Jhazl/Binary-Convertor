import java.util.*;


class Binary{
	public String number;
	
	public Binary(){
		number = "";
	}
	
	public Binary(String numberRepresentation){
		number = numberRepresentation;
	}
	
	public Binary(DecimalNumber number){
		String numberAsString = number.toString();
		this.number = convertDecimalToBinary(numberAsString);
	}
	
	public static boolean isValid(String binaryRepresentation){
		ArrayList<Character> validCharList = new ArrayList<>(Arrays.asList('0', '1'));
		boolean isValidBinary = true;
		for(int i = 0; i<binaryRepresentation.length(); i++){
			char currentChar = binaryRepresentation.charAt(i);
			if(validCharList.indexOf(currentChar) == -1){
				isValidBinary = false;
			}
			
		}
		return isValidBinary;
	}
	
	public String convertDecimalToBinary(String decimal){
		return Integer.toBinaryString(Integer.parseInt(decimal));
	}
	
	public String toString(){
		return this.number;
	}
	
}