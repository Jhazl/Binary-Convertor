import javax.swing.*;
import java.awt.*;
 import java.util.Map;
import java.util.HashMap;

abstract class BinaryConversionPanel extends JPanel{
	private String nameOfPanel = "";
	public JLabel nameOfPanelLabel = new JLabel(nameOfPanel);
	public JLabel numberSystemToConvertFrom = new JLabel();
	public JTextField numberToConvertEntryField = new JTextField(25);
	public JLabel numberSystemToConvertTo = new JLabel();
	public JTextField outputResultTextField = new JTextField(25);

	
	public BinaryConversionPanel(){
		super();
		setThemeForPanel();
		
		
		add(nameOfPanelLabel);
		JSeparator nameSeperator = new JSeparator(JSeparator.VERTICAL);
		nameSeperator.setPreferredSize(new Dimension(5,10));
		nameSeperator.setBackground(Color.WHITE);
		add(nameSeperator);
		
		add(numberSystemToConvertFrom);
		add(numberToConvertEntryField);
		add(numberSystemToConvertTo);
		add(outputResultTextField);
	}
	
	public void setThemeForPanel(){
		setLayout(new FlowLayout(FlowLayout.LEFT, 30,30));
		//setLayout(new GridLayout(0,2));
		setBackground(Color.DARK_GRAY);
		nameOfPanelLabel.setForeground(Color.WHITE);
		numberSystemToConvertFrom.setForeground(Color.WHITE);
		numberSystemToConvertTo.setForeground(Color.WHITE);
	}
	
	public void setNameOfPanel(String name){
		nameOfPanel = name;
		
	}
	
	public String toString(){
		return nameOfPanel;
	}
	
	public abstract void convertAndDisplay();
	public void clear(){
		numberToConvertEntryField.setText("");
		outputResultTextField.setText("");
		
	}
	
}