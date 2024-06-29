package alexander.packages.com;

import alexander.packages.com.entities.Descriptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Scheduler extends JFrame implements ActionListener {
    private JLabel titulo;
    private JTextField textField;

    public Scheduler() {
        super("Formulario Básico");

        JButton abrirDialogo;
        getContentPane().setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Etiqueta
        JLabel label = new JLabel("Introduce numero de identificacion:");
        getContentPane().add(label);
        JLabel label2 = new JLabel("/ Introduce numero de nacimiento yyyymmdd");
        getContentPane().add(label2);


        // Campo de texto
        textField = new JTextField("", 20);
        setKeyPressedTextField();

        getContentPane().add(textField);

        // Botón

        abrirDialogo = new JButton("Enviar");
        getContentPane().add(abrirDialogo);
        abrirDialogo.setBounds(450,570,100,50);
        abrirDialogo.addActionListener(this);

        setSize(400, 300);
        setVisible(true);
    }

    private void setKeyPressedTextField() {
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Este método se llama cuando se presiona y se libera una tecla
                char keyChar = e.getKeyChar();
                System.out.println("Tecla presionada: " + keyChar);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // Este método se llama cuando se presiona una tecla
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    showDialog();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Este método se llama cuando se libera una tecla
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showDialog();
    }
    public void showDialog(){
        if (validateInputNumber()) {
            showMessage();
        } else {
            showMessageError();
        }

    }

    private void showMessageError() {
        JDialog dialogo = new JDialog(this, "Error in data entry", true);
        dialogo.setLayout(new FlowLayout());
        JLabel label = new JLabel("Hi you must entry a number -- "+ textField.getText());
        dialogo.add(label);
        JButton closeButton = new JButton("close");
        closeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialogo.dispose();
                    }
                }

        );
        dialogo.add(closeButton);
        dialogo.pack();
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private void showMessage() {
        JDialog dialogo = new JDialog(this, "Mi JDialog", true);
        dialogo.setLayout(new FlowLayout());
        Long numberReduction = reduceNum(textField.getText());
        JLabel label = new JLabel("Hi from Jlabel -- "+ textField.getText()+  "el numero reducido es: "+ numberReduction);
        dialogo.add(label);

        JLabel label2 = new JLabel(new Descriptions().getValue(numberReduction.intValue()));
        dialogo.add(label2);
        JButton closeButton = new JButton("close");
        closeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialogo.dispose();
                    }
                }

        );
        dialogo.add(closeButton);
        dialogo.pack();
        dialogo.setLocationRelativeTo(this);
        dialogo.setVisible(true);
    }

    private Boolean validateInputNumber() {
       Boolean isValid = Boolean.FALSE;
        try
        {
              Long number = Long.parseLong(textField.getText());
              isValid = Boolean.TRUE;
        } catch (NumberFormatException e)
        {
            isValid = Boolean.FALSE;
        }

        return isValid;
    }

    public Long reduceNum(String num)
    {
        Long result = 0L;
        Long sum = 0L;

        for (Character number: num.toCharArray())
        {
            int digitValue = Character.getNumericValue(number);
            sum += Long.valueOf(digitValue);
            sum = reduceToOneDigit(sum);
        }


        return  sum;
    }


    public static Long reduceToOneDigit(Long num) {
        if (num < 10L) {
            return num; // Caso base: número de un solo dígito
        } else {
            Long sumOfDigits = 0L;
            while (num > 0) {
                sumOfDigits += num % 10;
                num /= 10;
            }
            return reduceToOneDigit(sumOfDigits); // Llamada recursiva
        }
    }
}
