package Swing.View;

import Swing.Model.Note;

import javax.swing.*;
import javax.swing.border.TitledBorder;
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
                Note note = new Note();
                note.setTitle("ÐÂ±Ê¼Ç");
                DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
                listModel.addElement(note);
            }
        });

        list1.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {
                return super.getListCellRendererComponent(list, ((Note)value).getTitle(), index, isSelected, cellHasFocus);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Notes");
        frame.setContentPane(new MainView().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel getNotePanel() {
        return notePanel;
    }

}
