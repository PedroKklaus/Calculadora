package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField numField1, numField2;
    private JButton addButton, subButton, mulButton, divButton;
    private JLabel resultLabel;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));

        numField1 = new JTextField(10);
        numField2 = new JTextField(10);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Número 1:"));
        inputPanel.add(numField1);
        inputPanel.add(new JLabel("Número 2:"));
        inputPanel.add(numField2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        resultLabel = new JLabel("Resultado: ");
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setForeground(Color.BLUE);

        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultLabel);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        inputPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double num1 = Double.parseDouble(numField1.getText());
        double num2 = Double.parseDouble(numField2.getText());
        double result = 0;

        if (e.getSource() == addButton) {
            result = num1 + num2;
        } else if (e.getSource() == subButton) {
            result = num1 - num2;
        } else if (e.getSource() == mulButton) {
            result = num1 * num2;
        } else if (e.getSource() == divButton) {
            if (num2 != 0) {
                result = num1 / num2;
            } else {
                resultLabel.setText("Erro: Divisão por zero!");
                return;
            }
        }

        resultLabel.setText("Resultado: " + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}
