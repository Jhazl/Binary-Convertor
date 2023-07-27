import java.util.*;


class OnesComplement extends SignedMagnitude{
	
	
	public OnesComplement(){
		super();
	}
	
	public OnesComplement(String numberRepresentation){
		super(numberRepresentation);
	}
	
	public OnesComplement(SignedMagnitude signedMagnitudeBinary){
		super();
		sign = signedMagnitudeBinary.getSign();
		if(sign.equals("1")){
			this.number = flipBits(signedMagnitudeBinary.number);
		}else{
			this.number = signedMagnitudeBinary.number;
		}
	}
	
	

}