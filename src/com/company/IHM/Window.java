package com.company.IHM;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    JFrame newAdminMenu;
    JFrame newLogin;

    public Window(String title) throws HeadlessException {
        super("WELCOME IN THE SHOP");
        this.setSize(300,400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        JFrame myWindow=this;


        //newLogin=new LoginMenu("Authentication");
        JPanel container = (JPanel)this.getContentPane();
        FlowLayout monLayout = new FlowLayout();
        container.setLayout(monLayout);
        container.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        container.setBackground(Color.decode("#4FB164"));
        //////////////configuration of components /////////////


        JLabel labelQuestion =new JLabel("WHAT DO YOU WANT TO DO ?");


        labelQuestion.setFont(new Font("Comic Sans MS",Font.BOLD+Font.ITALIC,14));
        labelQuestion.setForeground(Color.WHITE);
        container.add(labelQuestion);
        JButton logInAsAClient =new JButton();
        logInAsAClient.setText("LOG IN AS CLIENT");
        logInAsAClient.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        logInAsAClient.setForeground(Color.decode("#4FB164"));
        logInAsAClient.setMargin(new Insets(15,15,15,15));
        container.add(logInAsAClient, BorderLayout.NORTH);
        JButton logInAsAdmin =new JButton();
        logInAsAdmin.setText("LOG IN AS ADMIN");
        logInAsAdmin.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        logInAsAdmin.setForeground(Color.decode("#4FB164"));
        logInAsAClient.setMargin(new Insets(20,15,20,15));
        container.add(logInAsAdmin, BorderLayout.CENTER);
        JButton exitMain = new JButton();
        exitMain.setText("EXIT");
        exitMain.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        exitMain.setForeground(Color.decode("#4FB164"));
        exitMain.setMargin(new Insets(15,15,15,15));
        container.add(exitMain, BorderLayout.SOUTH);



        ///////Configuration of 1st menu buttons////////
        logInAsAClient.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newLogin=new LoginMenu("Authentication");
                //newLogin.this.authenticationPanel;

            }
        }));

        logInAsAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /////Admin Menu
                newAdminMenu=new MenuAdminIHM("Administrator");
            }
        });
        exitMain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



    }
}
