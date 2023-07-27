import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


class BinaryToDecimal extends BinaryConversionPanel{
	private Map<Binary, DecimalNumber> memoizeTable = new HashMap<>();
	
	public BinaryToDecimal(){
		super();
		this.setNameOfPanel("Unsigned binary to Decimal");
		nameOfPanelLabel.setText("Unsigned binary to Decimal");
		numberSystemToConvertFrom.setText("Binary:");
		numberSystemToConvertTo.setText("Decimal:");
	}
	
	public DecimalNumber convert(Binary n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		DecimalNumber numberToOutput = new DecimalNumber(n);
		this.memoizeTable.put(n, numberToOutput);
		
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String binaryNumberEntry = numberToConvertEntryField.getText();
		if(!(Binary.isValid(binaryNumberEntry))){
			numberToConvertEntryField.setText("Please enter a valid binary number");
		}else{
			Binary binaryNumber = new Binary(binaryNumberEntry);
			DecimalNumber decimalNumber = convert(binaryNumber);
			outputResultTextField.setText(decimalNumber.toString());
		}
	
	}
	

	
}