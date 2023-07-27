import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class SignedMagnitudeToOnesComplement extends BinaryConversionPanel{
	private Map<SignedMagnitude, OnesComplement> memoizeTable = new HashMap<>();
	
	public SignedMagnitudeToOnesComplement(){
		super();
		this.setNameOfPanel("Signed Magnitude to Ones Complement");
		nameOfPanelLabel.setText("Signed Magnitude to Ones Complement");
		numberSystemToConvertFrom.setText("Signed Magnitude:");
		numberSystemToConvertTo.setText("Ones complement:");
	}
	
	public OnesComplement convert(SignedMagnitude n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		OnesComplement numberToOutput = new OnesComplement(n);
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
			OnesComplement numberToOutput = convert(binary);
			outputResultTextField.setText(numberToOutput.toString());
		}
	
	}
	
	
}