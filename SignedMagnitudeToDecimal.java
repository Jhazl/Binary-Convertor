import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class SignedMagnitudeToDecimal extends BinaryConversionPanel{
	private Map<SignedMagnitude, SignedDecimalNumber> memoizeTable = new HashMap<>();
	
	public SignedMagnitudeToDecimal(){
		super();
		this.setNameOfPanel("Signed Magnitude to Decimal");
		nameOfPanelLabel.setText("Signed Magnitude to Decimal");
		numberSystemToConvertFrom.setText("Signed Magnitude:");
		numberSystemToConvertTo.setText("Signed decimal:");
	}
	
	public SignedDecimalNumber convert(SignedMagnitude n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedDecimalNumber numberToOutput = new SignedDecimalNumber(n);
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
			SignedDecimalNumber numberToOutput = convert(binary);
			outputResultTextField.setText(numberToOutput.toString());
		}
	
	}
	
	
}