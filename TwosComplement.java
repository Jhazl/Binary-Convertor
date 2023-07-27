class TwosComplement extends OnesComplement{
	
	public TwosComplement(SignedMagnitude signedMagnitudeBinary){
		super();
		sign = signedMagnitudeBinary.getSign();
		if(sign.equals("1")){
			this.number = negSignedMagnitudeToTwosComplement(signedMagnitudeBinary.number);
		}else{
			this.number = signedMagnitudeBinary.number;
		}
	}
	public TwosComplement(String numberRepresentation){
		super(numberRepresentation);
	}
	
	public String negSignedMagnitudeToTwosComplement(String signedMagnitudeBinary){
		if(signedMagnitudeBinary.indexOf("1") == -1){
			return signedMagnitudeBinary;
		}
		String stringToReturn = "";
		int indexOfFirstOne = signedMagnitudeBinary.lastIndexOf("1");
		for(int i = 0; i < signedMagnitudeBinary.length(); i++){
			String bit = signedMagnitudeBinary.substring(i, i+1);
			if(i < indexOfFirstOne){
				stringToReturn += flipBit(bit);
			}else{
				stringToReturn += bit;
			}
		}
		return stringToReturn;
	}
}