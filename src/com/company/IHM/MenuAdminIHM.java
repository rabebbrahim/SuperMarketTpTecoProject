package com.company.IHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAdminIHM extends JFrame {
    JFrame adminFrame;
    ProductListTable listProduct;
    Window myWindow;
    public MenuAdminIHM(String Title){
        super("Admin Menu");

        this.adminFrame=new JFrame();
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        adminFrame.setLocationRelativeTo(null);
        adminFrame.setSize(300,400);
        adminFrame.setVisible(true);


        ///////Panel Menu administrator

        JPanel adminPanel = (JPanel)this.getContentPane();
        FlowLayout monLayout = new FlowLayout();
        adminPanel.setLayout(monLayout);
        adminPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        adminPanel.setBackground(Color.DARK_GRAY);
        adminFrame.add(adminPanel);

        ///////Component Menu ---label and Buttons---

        //---------title-------
        JLabel titleAdminMenuLabel =new JLabel("WHAT DO YOU WANT TO DO ?");
        titleAdminMenuLabel.setFont(new Font("Comic Sans MS",Font.BOLD+Font.ITALIC,15));
        titleAdminMenuLabel.setForeground(Color.WHITE);
        adminPanel.add(titleAdminMenuLabel,BorderLayout.NORTH);
        //---------1st Button-------
        JButton listOfProductButton = new JButton("List Of Products");
        listOfProductButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        listOfProductButton.setForeground(Color.DARK_GRAY);
        listOfProductButton.setMargin(new Insets(15,15,15,15));
        adminPanel.add(listOfProductButton, BorderLayout.NORTH);
        //---------2nd Button--------
        JButton addProductButton = new JButton("ADD New Product");
        addProductButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        addProductButton.setForeground(Color.DARK_GRAY);
        addProductButton.setMargin(new Insets(15,15,15,15));
        adminPanel.add(addProductButton, BorderLayout.CENTER);
        //---------3rd Button---------
        JButton goBackButton = new JButton("GO BACK");
        goBackButton.setFont(new Font("Comic Sans MS",Font.BOLD,19));
        goBackButton.setForeground(Color.GRAY);
        goBackButton.setMargin(new Insets(15,15,15,15));
        adminPanel.add(goBackButton, BorderLayout.CENTER);

        //////----1st button action Listener

        listOfProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /// show list of product
                listProduct=new ProductListTable("Table of Product");
            }
        });

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // add a new product in the table

            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // go back  to the principal menu
                myWindow= new Window("Welcome in the shop");

            }
        });

        /********** Creation of a method which get the admin to add a new product**********/


    }
}
