import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class DecimalToTwosComplement extends BinaryConversionPanel{
	private Map<SignedDecimalNumber, TwosComplement> memoizeTable = new HashMap<>();
	
	public DecimalToTwosComplement(){
		super();
		this.setNameOfPanel("Decimal to Twos Complement");
		nameOfPanelLabel.setText("Decimal to Twos Complement");
		numberSystemToConvertFrom.setText("Decimal:");
		numberSystemToConvertTo.setText("Twos Complement:");
	}
	
	public TwosComplement convert(SignedDecimalNumber n){
		if(memoizeTable.containsKey(n)){
			return memoizeTable.get(n);
		}
		SignedMagnitude decimalAsSigned = new SignedMagnitude(n);
		TwosComplement numberToOutput = new TwosComplement(decimalAsSigned);
		this.memoizeTable.put(n, numberToOutput);
		return numberToOutput;
	}
	
	public void convertAndDisplay(){
		String decimalEntry = numberToConvertEntryField.getText();
		if(decimalEntry.equals("") || (!(SignedDecimalNumber.isValid(decimalEntry))) || decimalEntry.equals("-")){
			numberToConvertEntryField.setText("Please enter a valid integer");
		}else{
			SignedDecimalNumber decimal = new SignedDecimalNumber(decimalEntry);
			TwosComplement numberToOutput = convert(decimal);
			outputResultTextField.setText(numberToOutput.toString());
		}
	}
}