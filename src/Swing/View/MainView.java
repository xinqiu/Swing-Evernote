package Swing.View;

import Swing.Control.*;
import Swing.Model.Note;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


/**
 * Created by qiuxin on 15/12/24.
 */
public class MainView {
    private static int userId;
    private JButton newNoteButton;
    private JTextField searchTextField;
    private JPanel Main;
    private JButton searchButton;
    private JButton exitButton;
    private JPanel notePanel;
    private JList list1;
    private JButton deleteButton;
    private JButton modifyButton;


    public MainView(final JFrame frame, int id) {
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

//        newNoteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Note note = new Note();
////                note.setTitle("New note");
//                note.setContent("I write a new text");
//                DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
//                listModel.addElement(note);
//            }
//        });
//
        list1.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list,
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus) {
                return super.getListCellRendererComponent(list, ((Note)value).getContent(), index, isSelected, cellHasFocus);
            }
        });

        list1.setModel(new DefaultListModel<Note>());
        final DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();

        newNoteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewNoteView.newNote(userId, MainView.this);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete?","Confirm",JOptionPane.YES_NO_OPTION);
                if (res == 0) {
                    int index = list1.getSelectedIndex();
                    Note dNote = new Note();
                    dNote = listModel.elementAt(index);
                    deleteNote.delete(dNote.getContent());
                    DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
                    listModel.removeElementAt(index);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> notesList;
                notesList = searchNote.search(userId , searchTextField.getText());
                Iterator it = notesList.iterator();
                listModel.removeAllElements();
                while (it.hasNext()){
                    Note tmp = new Note();
                    tmp.setContent(it.next().toString());
                    listModel.addElement(tmp);
                }
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                Note oNote = new Note();
                oNote = listModel.elementAt(index);
                String info = JOptionPane.showInputDialog(null,"Please update your note");
                if(!info.isEmpty()) {
                    modifyNote.modify(info, oNote.getContent());
                    listModel.elementAt(index).setContent(info);
                    list1.updateUI();
                }
            }
        });

        setUserId(id);

        showNotes(listModel);

    }

    public void showNotes(DefaultListModel<Note> listModel){
        ArrayList<String> notesList;
        notesList = showNotes.showNotes(userId);
        Iterator it = notesList.iterator();
        while (it.hasNext()){
            Note tmp = new Note();
            tmp.setContent(it.next().toString());

            listModel.addElement(tmp);
        }
        list1.updateUI();
    }

    public void show(){
        Note note = new Note();
        note.setContent(getNote.get(userId));
        DefaultListModel<Note> listModel = (DefaultListModel<Note>) list1.getModel();
        listModel.addElement(note);
    }


    public static void main(int id) {
        JFrame frame = new JFrame("Notes");
        frame.setContentPane(new MainView(frame, id).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(640, 480));
        frame.setLocationRelativeTo(null);
        setUserId(id);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setUserId(int id) {
        userId = id;
    }


}