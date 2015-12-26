package Swing.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Created by qiuxin on 15/12/24.
 */
public class MainView {
    private JButton newNoteButton;
    private JTextField searchTextField;
    private JPanel Main;
    private JButton searchButton;
    private JButton exitButton;
    private JScrollBar scrollBar1;
    private JPanel notePanel;
    private JLabel notesLabel;
    private JList list1;


    public MainView() {
        searchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                searchTextField.setText("");
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        newNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel note = new JLabel("Test");
                getNotePanel().add(note);
            }
        });
    }

    public JPanel getNotePanel() {
        return notePanel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notes");
        frame.setContentPane(new MainView().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640,480));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

}
