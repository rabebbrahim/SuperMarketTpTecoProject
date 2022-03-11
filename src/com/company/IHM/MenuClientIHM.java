package com.company.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuClientIHM extends JFrame {
    JFrame clientMenuFrame;
    Window myWindow;

    public MenuClientIHM(String title) {
        super("Client MENU");
        this.clientMenuFrame=new JFrame();
        clientMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        clientMenuFrame.setLocationRelativeTo(null);
        clientMenuFrame.setSize(600,300);
        clientMenuFrame.setVisible(true);

        ///////Panel Menu Client

        JPanel menuPanel = (JPanel)this.getContentPane();
        FlowLayout monLayout = new FlowLayout();
        menuPanel.setLayout(monLayout);
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        menuPanel.setBackground(Color.GRAY);
        clientMenuFrame.add(menuPanel);

        ///////Component Menu ---label and Buttons---

        //---------title-------
        JLabel titleMenuLabel =new JLabel("WHAT DO YOU WANT TO DO ?");
        titleMenuLabel.setFont(new Font("Comic Sans MS",Font.BOLD+Font.ITALIC,22));
        titleMenuLabel.setForeground(Color.WHITE);
        menuPanel.add(titleMenuLabel,BorderLayout.NORTH);
        //---------1st Button-------
        JButton listOfProductButton = new JButton("List Of Products");
        listOfProductButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        listOfProductButton.setForeground(Color.GRAY);
        listOfProductButton.setMargin(new Insets(15,15,15,15));
        menuPanel.add(listOfProductButton, BorderLayout.NORTH);
        //---------2nd Button--------
        JButton clientCartButton = new JButton("Cart");
        clientCartButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        clientCartButton.setForeground(Color.GRAY);
        clientCartButton.setMargin(new Insets(15,15,15,15));
        menuPanel.add(clientCartButton, BorderLayout.CENTER);
        //---------3rd Button---------
        JButton logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        logoutButton.setForeground(Color.GRAY);
        logoutButton.setMargin(new Insets(15,15,15,15));
        menuPanel.add(logoutButton, BorderLayout.CENTER);
        //--------4th Button---------
        JButton newAccountButton = new JButton("Create New Account");
        newAccountButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        newAccountButton.setForeground(Color.GRAY);
        newAccountButton.setMargin(new Insets(15,15,15,15));
        menuPanel.add(newAccountButton, BorderLayout.CENTER);

        ////////////// 1st button event listner

        listOfProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //// calling the class ProductListTable to show the list of product
                new ProductListTable("List of Product");
            }
        });

        /////////// 2nd button event listener

        clientCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ///// calling the method of cart to add products

            }
        });

        /////// 3rd button event listener

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get back to the principal menu
                myWindow=new Window("Welcome in the shop");
            }
        });

        /////// 4th button event listener

        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // calling the method to create a new account

            }
        });


        /*********** create a method to create new account *********/

       /* public void createNewAccount(JTextField myJTextFielLogin,JTextField  myJTextFieldPassword){



        }

        /***************** create a method to get the cart **********/


        /* public void getYourCart(){

        }*/



    }


}
