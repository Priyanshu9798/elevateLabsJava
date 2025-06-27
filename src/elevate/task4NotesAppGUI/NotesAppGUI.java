package elevate.task4NotesAppGUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class NotesAppGUI extends JFrame {
    private JTextArea noteArea;
    private JButton saveButton, loadButton;
    private static final String FILE_NAME = "notes.txt";

    public NotesAppGUI() {
        setTitle("Notes App");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Title
        JLabel titleLabel = new JLabel("Simple Notes App", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Text area
        noteArea = new JTextArea();
        noteArea.setFont(new Font("Arial", Font.PLAIN, 16));
        add(new JScrollPane(noteArea), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save Note");
        loadButton = new JButton("Load Notes");

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button listeners
        saveButton.addActionListener(e -> saveNote());
        loadButton.addActionListener(e -> loadNotes());
    }

    private void saveNote() {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(noteArea.getText() + "\n");
            JOptionPane.showMessageDialog(this, "Note saved.");
            noteArea.setText(""); // Clear input
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving note: " + ex.getMessage());
        }
    }

    private void loadNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            noteArea.setText(""); // Clear area
            String line;
            while ((line = reader.readLine()) != null) {
                noteArea.append(line + "\n");
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No notes found.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading notes: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new NotesAppGUI().setVisible(true);
        });
    }
}
