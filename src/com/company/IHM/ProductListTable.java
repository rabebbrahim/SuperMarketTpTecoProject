package com.company.IHM;

import javax.swing.*;

public class ProductListTable extends JFrame{
    JFrame frameProduct;
    JPanel tablePanel;
    public ProductListTable(String title) {
        super("shop products");
        frameProduct = new JFrame();
        tablePanel=(JPanel)this.getContentPane();
        frameProduct.add(tablePanel);

        ////Creation of the table of the list of products

        String data[][] = {{"Pain", "2", "30"},
                {"Lait", "2", "80"},
                {"jus", "5", "50"},
                {"pomme", "3.5", "40"},
                {"poire", "4", "50"},
                {"farine", "1.5", "100"},
                {"riz", "4", "70"}};

        String column[] = {"NAME", "PRICE","QUANTITY"};
        JTable jtable = new JTable(data, column);
        jtable.setBounds(30, 40, 300, 400);
        JScrollPane sp = new JScrollPane(jtable);
        JCheckBox isAdded = new JCheckBox();
        isAdded.setEnabled(false);

        frameProduct.add(sp);
        frameProduct.setSize(600, 600);
        frameProduct.setVisible(true);
        tablePanel.add(jtable);
        tablePanel.add(isAdded);
    }


}

