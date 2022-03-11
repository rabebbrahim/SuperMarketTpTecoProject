package com.company.IHM;

import com.company.Menus.ClientMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame {

    JFrame newClientMenu;
    JFrame myWindow;



    public LoginMenu(String title) {

        super("AUTHENTICATION");
        JFrame authenticationFrame = new JFrame();
        authenticationFrame.setSize(350, 200);
        authenticationFrame.setLocationRelativeTo(null);
        authenticationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        authenticationFrame.setVisible(true);

        /// JPanel
        JPanel authenticationPanel = (JPanel)this.getContentPane();
        authenticationPanel.setLayout(null);
        authenticationPanel.setBackground(Color.decode("#E7700D"));
        authenticationFrame.add(authenticationPanel);
        //// JLabel LOGIN

        JLabel loginLabel = new JLabel("Login");
        loginLabel.setBounds(10, 20, 80, 25);

        loginLabel.setForeground(Color.WHITE);
        authenticationPanel.add(loginLabel);

        /////JTextField LOGIN

        JTextField loginText = new JTextField(20);
        loginText.setBounds(100, 20, 165, 25);

        authenticationPanel.add(loginText);

        //// JLabel Password

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setBounds(10, 50, 80, 25);

        passwordLabel.setForeground(Color.WHITE);

        authenticationPanel.add(passwordLabel);

        //// JPassword

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);

        authenticationPanel.add(passwordText);

        ///// Validate Button

        JButton loginButton = new JButton("ENTER");
        loginButton.setBounds(10, 80, 80, 25);

        loginButton.setForeground(Color.decode("#E7700D"));

        authenticationPanel.add(loginButton);


        /////// ActionListener LoginButton

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = loginText.getText();
                String password = passwordText.getText();
                System.out.println(login + "," + password);
                if (login.equals("coding") && password.equals("coding")) {
                    /////// new JFrame() ---ListOfProduct
                    newClientMenu= new MenuClientIHM("Client Menu");

                } else {
                    String message = "Error,please try again!";
                    JOptionPane.showMessageDialog(null, message);
                    myWindow=new Window("Welcome in the shop");
                }
            }
        });


    }



}
