import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class UnsignedDecimalToBinary extends BinaryConversionPanel{
	private Map<DecimalNumber, Binary> memoizeTable = new HashMap<>();

	public UnsignedDecimalToBinary(){
		super();
		this.setNameOfPanel("Unsigned decimal to Binary");
		nameOfPanelLabel.setText("Unsigned decimal to Binary");
		numberSystemToConvertFrom.setText("Decimal:");
		numberSystemToConvertTo.setText("Binary:");
	}
	
	public Binary convert(DecimalNumber n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		Binary numberToOutput = new Binary(n);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String decimalNumberEntry = numberToConvertEntryField.getText();
		if(!(DecimalNumber.isValid(decimalNumberEntry))){
			numberToConvertEntryField.setText("Please enter a valid decimal number");
		}else if(Double.parseDouble(decimalNumberEntry) > 2147483647){
			numberToConvertEntryField.setText("Please enter a number less than 2147483647");
		}else{
			DecimalNumber decimalNumber = new DecimalNumber(decimalNumberEntry);
			Binary binaryNumber = convert(decimalNumber); //new Binary(decimalNumber);
			outputResultTextField.setText(binaryNumber.toString());
		}
	
	}
	
	
}