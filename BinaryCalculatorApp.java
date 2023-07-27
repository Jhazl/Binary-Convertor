import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinaryCalculatorApp extends JFrame{
	JPanel currentPanel;
	JButton convertButton = new JButton("Convert");
	JComboBox<BinaryConversionPanel> calculatorOptions;
	
	public static void main(String[] args){
		new BinaryCalculatorApp();
	}
	
	public BinaryCalculatorApp(){
		super("Binary calculator");
		setUp();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 200);
		setBackground(Color.BLACK);
		setResizable(false);
		setVisible(true);
	}
	
	private void setUp(){
		BinaryConversionPanel[] options = new BinaryConversionPanel[]{new BinaryToDecimal(), new UnsignedDecimalToBinary(), new SignedMagnitudeToDecimal(), new DecimalToSignedMagnitude(), 
		new SignedMagnitudeToOnesComplement(), new SignedMagnitudeToTwosComplement(), new DecimalToOnesComplement(), new DecimalToTwosComplement(),
		new OnesComplementToDecimal(), new TwosComplementToDecimal()}; //Change to array of panels with tostring methods
		calculatorOptions = new JComboBox<BinaryConversionPanel>(new DefaultComboBoxModel<BinaryConversionPanel>(options));
		calculatorOptions.addActionListener(new PanelChangeEventListener());
		currentPanel = options[0];
		add(calculatorOptions, BorderLayout.PAGE_START);
		add(currentPanel, BorderLayout.CENTER);
		add(convertButton, BorderLayout.SOUTH);
		convertButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				((BinaryConversionPanel) currentPanel).convertAndDisplay();
			} 
		} );
	
	}
	
	
	class PanelChangeEventListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JComboBox cb = (JComboBox)e.getSource();
			BinaryConversionPanel panelChosen = (BinaryConversionPanel)cb.getSelectedItem();
			((BinaryConversionPanel)currentPanel).clear();
			currentPanel.setVisible(false);
			currentPanel = panelChosen;
			add(currentPanel, BorderLayout.CENTER);
			currentPanel.setVisible(true);
		}
	}
	
	
	
}
