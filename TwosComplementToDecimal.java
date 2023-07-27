import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class TwosComplementToDecimal extends BinaryConversionPanel{
	private Map<TwosComplement, SignedDecimalNumber> memoizeTable = new HashMap<>();
	
	public TwosComplementToDecimal(){
		super();
		this.setNameOfPanel("Twos Complement to Decimal");
		nameOfPanelLabel.setText("Twos Complement to Decimal");
		numberSystemToConvertFrom.setText("Twos Complement:");
		numberSystemToConvertTo.setText("Signed decimal:");
	}
	
	public SignedDecimalNumber convert(TwosComplement n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedMagnitude signedMagnitude = new SignedMagnitude(n);
		SignedDecimalNumber numberToOutput = new SignedDecimalNumber(signedMagnitude);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String twosComplementEntry = numberToConvertEntryField.getText();
		if(twosComplementEntry.equals("") || twosComplementEntry.length() == 1){
			numberToConvertEntryField.setText("Please enter a valid twos complement");
		}else if(!(Binary.isValid(twosComplementEntry))){
			numberToConvertEntryField.setText("Please enter a valid twos complement");
		}else{
			TwosComplement binary = new TwosComplement(twosComplementEntry);
			SignedDecimalNumber numberToOutput = convert(binary);
			outputResultTextField.setText(numberToOutput.toString());
		}
	
	}
	
	
}