import java.util.*;


class SignedMagnitude extends Binary{
	public String sign;
	
	public SignedMagnitude(){
		sign = "";
	}
	
	public SignedMagnitude(String numberRepresentation){
		super();
		sign = numberRepresentation.substring(0, 1);
		number = numberRepresentation.substring(1);
	}
	
	public SignedMagnitude(SignedDecimalNumber number){
		String numberAsString = number.toString();
		if(number.sign.equals("-")){
			sign = "1";
			numberAsString = numberAsString.substring(1);
		}else{
			sign = "0";
		}
		this.number = convertDecimalToBinary(numberAsString);
	}
	
	public SignedMagnitude(OnesComplement onesComplement){
		sign = onesComplement.sign;
		if(sign.equals("1")){
			number = flipBits(onesComplement.number);
		}else{
			number = onesComplement.number;
		}
		
	}
	
	public SignedMagnitude(TwosComplement twosComplement){
		sign = twosComplement.sign;
		if(sign.equals("1")){
			number = reverseTwoComplementConversion(twosComplement.number);
		}else{
			number = twosComplement.number;
		}
	}
	
	
	
	public String toString(){
		return this.sign + this.number;
	}
	
	public String getSign(){
		return this.sign;
	}
	
	public String flipBit(String bit){
		if(bit.equals("0")){
			return "1";
		}else{
			return "0";
		}
	}
	
	public String flipBits(String bits){
		String flippedBitsString = "";
		for(int i = 0; i<bits.length(); i++){
			String bit = bits.substring(i, i+1);
			flippedBitsString += flipBit(bit);
			
		}
		return flippedBitsString;
	}
	
	public String reverseTwoComplementConversion(String twosComplement){
		if(twosComplement.indexOf("1") == -1){
			return twosComplement;
		}
		String stringToReturn = "";
		int indexOfFirstOne = twosComplement.lastIndexOf("1");
		for(int i = 0; i < twosComplement.length(); i++){
			String bit = twosComplement.substring(i, i+1);
			if(i < indexOfFirstOne){
				stringToReturn += flipBit(bit);
			}else{
				stringToReturn += bit;
			}
		}
		return stringToReturn;
	}
	
}