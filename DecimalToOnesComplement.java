import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class DecimalToOnesComplement extends BinaryConversionPanel{
	private Map<SignedDecimalNumber, OnesComplement> memoizeTable = new HashMap<>();
	
	public DecimalToOnesComplement(){
		super();
		this.setNameOfPanel("Decimal to Ones Complement");
		nameOfPanelLabel.setText("Decimal to Ones Complement");
		numberSystemToConvertFrom.setText("Decimal:");
		numberSystemToConvertTo.setText("Ones Complement:");
	}
	
	public OnesComplement convert(SignedDecimalNumber n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedMagnitude decimalAsSigned = new SignedMagnitude(n);
		OnesComplement numberToOutput = new OnesComplement(decimalAsSigned);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String decimalEntry = numberToConvertEntryField.getText();
		if(decimalEntry.equals("") || (!(SignedDecimalNumber.isValid(decimalEntry))) || decimalEntry.equals("-")){
			numberToConvertEntryField.setText("Please enter a valid integer");
		}else{
			SignedDecimalNumber decimal = new SignedDecimalNumber(decimalEntry);
			OnesComplement numberToOutput = convert(decimal);
			outputResultTextField.setText(numberToOutput.toString());
		}
	}
}