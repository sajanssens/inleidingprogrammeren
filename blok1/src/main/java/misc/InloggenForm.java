package misc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InloggenForm {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPanel panel;
    private JButton okButton;
    private String text;
    private String pw;

    public InloggenForm() {
        okButton.addActionListener(e -> {
            getData(this);
            System.out.println(text);
            System.out.println(pw);
        });
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(final String pw) {
        this.pw = pw;
    }

    public void setData(InloggenForm data) {
        textField1.setText(data.getText());
        passwordField1.setText(data.getPw());
    }

    public void getData(InloggenForm data) {
        data.setText(textField1.getText());
        data.setPw(passwordField1.getText());
    }

    public boolean isModified(InloggenForm data) {
        if (textField1.getText() != null ? !textField1.getText().equals(data.getText()) : data.getText() != null) return true;
        if (passwordField1.getText() != null ? !passwordField1.getText().equals(data.getPw()) : data.getPw() != null) return true;
        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("InloggenForm");
        frame.setContentPane(new InloggenForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
