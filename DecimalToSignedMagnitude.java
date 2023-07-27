import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


class DecimalToSignedMagnitude extends BinaryConversionPanel{
	private Map<SignedDecimalNumber, SignedMagnitude> memoizeTable = new HashMap<>();
	
	public DecimalToSignedMagnitude(){
		super();
		this.setNameOfPanel("Decimal to Signed Magnitude");
		nameOfPanelLabel.setText("Decimal to Signed Magnitude");
		numberSystemToConvertFrom.setText("Decimal:");
		numberSystemToConvertTo.setText("Signed magnitude:");
	}
	
	public SignedMagnitude convert(SignedDecimalNumber n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedMagnitude numberToOutput = new SignedMagnitude(n);
		this.memoizeTable.put(n, numberToOutput);
		
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String decimalEntry = numberToConvertEntryField.getText();
		if(decimalEntry.equals("") || (!(SignedDecimalNumber.isValid(decimalEntry))) || decimalEntry.equals("-")){
			numberToConvertEntryField.setText("Please enter a valid integer");
		}else{
			SignedDecimalNumber decimal = new SignedDecimalNumber(decimalEntry);
			SignedMagnitude numberToOutput = convert(decimal);
			outputResultTextField.setText(numberToOutput.toString());
		}
	}
	
	
}