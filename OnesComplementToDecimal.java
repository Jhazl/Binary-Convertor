import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class OnesComplementToDecimal extends BinaryConversionPanel{
	private Map<OnesComplement, SignedDecimalNumber> memoizeTable = new HashMap<>();
	
	
	public OnesComplementToDecimal(){
		super();
		this.setNameOfPanel("Ones Complement to Decimal");
		nameOfPanelLabel.setText("Ones Complement to Decimal");
		numberSystemToConvertFrom.setText("Ones Complement:");
		numberSystemToConvertTo.setText("Signed decimal:");
	}
	
	public SignedDecimalNumber convert(OnesComplement n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedMagnitude signedMagnitude = new SignedMagnitude(n);
		SignedDecimalNumber numberToOutput = new SignedDecimalNumber(signedMagnitude);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String onesComplementEntry = numberToConvertEntryField.getText();
		if(onesComplementEntry.equals("") || onesComplementEntry.length() == 1){
			numberToConvertEntryField.setText("Please enter a valid ones complement");
		}else if(!(Binary.isValid(onesComplementEntry))){
			numberToConvertEntryField.setText("Please enter a valid ones complement");
		}else{
			OnesComplement binary = new OnesComplement(onesComplementEntry);
			SignedDecimalNumber numberToOutput = convert(binary);
			outputResultTextField.setText(numberToOutput.toString());
		}
	
	}
	
	
}