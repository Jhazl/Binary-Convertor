import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class SignedMagnitudeToTwosComplement extends BinaryConversionPanel{
	private Map<SignedMagnitude, TwosComplement> memoizeTable = new HashMap<>();
	
	
	public SignedMagnitudeToTwosComplement(){
		super();
		this.setNameOfPanel("Signed Magnitude to Twos Complement");
		nameOfPanelLabel.setText("Signed Magnitude to Twos Complement");
		numberSystemToConvertFrom.setText("Signed Magnitude:");
		numberSystemToConvertTo.setText("Twos complement:");
	}
	
	public TwosComplement convert(SignedMagnitude n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		TwosComplement numberToOutput = new TwosComplement(n);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String signedMagnitudeEntry = numberToConvertEntryField.getText();
		if(signedMagnitudeEntry.equals("") || signedMagnitudeEntry.length() == 1){
			numberToConvertEntryField.setText("Please enter a valid signed binary");
		}else if(!(Binary.isValid(signedMagnitudeEntry))){
			numberToConvertEntryField.setText("Please enter a valid binary number");
		}else{
			SignedMagnitude binary = new SignedMagnitude(signedMagnitudeEntry);
			TwosComplement numberToOutput = convert(binary);
			outputResultTextField.setText(numberToOutput.toString());
		}
	
	}
	
	
}
