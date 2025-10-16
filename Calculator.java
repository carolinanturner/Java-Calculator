import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Calculator class implements ActionListener to handle button click events 
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1=0, num2=0, result=0;
    char operator;
    // Constructor to set up the calculator GUI
    Calculator() {
        // Create the frame
        frame= new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        // Create text field for calculator display
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        frame.add(textField);
        textField.setEditable(false);
        frame.setVisible(true);

        // Create function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");       
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // Store all function buttons in an array for easy access
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;     
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

         // Configure each function button
        for(int i=0;i<8;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Create and configure number buttons (0–9)
        for (int i=0;i<10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Position special buttons below the main grid
        negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);

        // Panel to hold most of the buttons (4x4 grid)
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.PINK);

        // Set up buttons in 4x4 for display
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        // Add other operations to the frame
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.add(negButton);
        frame.setVisible(true);

    }

    // Main method to run the calculator 
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
    }

    // This method handles all button click events
    @Override
    public void actionPerformed(ActionEvent e) {
         // Handle number button clicks (0–9)
        for(int i=0;i<10;i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        // Handle decimal point
        if(e.getSource()== decButton){
               textField.setText(textField.getText().concat("."));
            }
            // Handle addition
            if(e.getSource() == addButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='+';
                textField.setText("");
            }
            // Handle subtraction
            if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='-';
                textField.setText("");
            }
            // Handle multiplication
            if(e.getSource() == mulButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='*';
                textField.setText("");
            }
            // Handle division
            if(e.getSource() == divButton){
                num1 = Double.parseDouble(textField.getText());
                operator ='/';
                textField.setText("");
            }
            // Handle equals button to perform calculation
            if(e.getSource() == equButton){
                num2= Double.parseDouble(textField.getText());
                // Perform operation based on the selected operator
                switch(operator){
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }
                // Display results
                textField.setText(String.valueOf(result));
                num1=result;
            }
            // Handle clear button to reset the display
            if(e.getSource() == clrButton){
                textField.setText("");
            }
            // Handle delete button to remove last character
            if(e.getSource() == delButton){
                String string = textField.getText();
                textField.setText(" ");
                for(int i=0;i<string.length()-1;i++){
                    textField.setText(textField.getText()+string.charAt(i));
                }
            }
            // Handle negation button to toggle sign
            if(e.getSource() == negButton){
                double temp = Double.parseDouble(textField.getText());
                temp*=-1;
                textField.setText(String.valueOf(temp));
            }
    }
}
