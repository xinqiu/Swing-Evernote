package Swing.View;

import Swing.Control.Register;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by qiuxin on 15/12/24.
 */
public class RegisterView {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nameField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton resetButton;
    private JButton submitButton;
    private JButton exitButton;
    private JPanel Register;

    public RegisterView(final JFrame frame) {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (Swing.Control.Register.submitCheck(usernameField.getText(),
                        new String(passwordField.getPassword()), nameField.getText(),
                        maleRadioButton.isSelected(), femaleRadioButton.isSelected())){
                    case 0:
                        JOptionPane.showMessageDialog(null, " Username has been used!\tPlease change again! ",
                                "Username has been used", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, " Username invalid!\t" +
                                        "Usernames must have only letters,numbers, underscores\tPlease change again! ",
                                "Username Envalid", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Please enter everything\tPlease change again! ",
                                "Something Empty", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"Password must contains 6 to 16 characters\tPlease change again! ",
                                "Password Length Error", JOptionPane.WARNING_MESSAGE);
                        break;
                    case 1:
                        Swing.Control.Register.submit(usernameField.getText(), new String(passwordField.getPassword()),
                                nameField.getText(), maleRadioButton.isSelected(), femaleRadioButton.isSelected());
                        frame.dispose();
                        EnterView.main(null);
                        break;
                }

            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                nameField.setText("");
                maleRadioButton.setSelected(false);
                femaleRadioButton.setSelected(false);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                EnterView.main(null);
            }
        });

        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!femaleRadioButton.isSelected() && !maleRadioButton.isSelected()) {
                    maleRadioButton.setSelected(true);
                }else if(femaleRadioButton.isSelected()) {
                    femaleRadioButton.setSelected(false);
                    maleRadioButton.setSelected(true);
                }else {
                    maleRadioButton.setSelected(true);
                }
            }
        });
        femaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!femaleRadioButton.isSelected() && !maleRadioButton.isSelected()) {
                    femaleRadioButton.setSelected(true);
                }else if(maleRadioButton.isSelected())
                {
                    maleRadioButton.setSelected(false);
                    maleRadioButton.setSelected(false);
                    femaleRadioButton.setSelected(true);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Register");
        frame.setContentPane(new RegisterView(frame).Register);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }
}
