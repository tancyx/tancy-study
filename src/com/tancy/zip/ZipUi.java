package com.tancy.zip;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author tancy
 * @description description
 * @date 2019/2/22 10:06
 **/
public class ZipUi {

    public static void main(String[] args) {

        JFrame jf=new JFrame("author tancy");
        jf.setBounds(600,300,600,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagLayout gridBagLayout=new GridBagLayout();
        GridBagConstraints constraints=new GridBagConstraints();
//        constraints.fill=GridBagConstraints.BOTH;
        jf.setLayout(gridBagLayout);
//        jf.setResizable(false);


        constraints.weightx=0;
        constraints.weighty=0;
        constraints.gridx=GridBagConstraints.RELATIVE;
        constraints.gridy=GridBagConstraints.RELATIVE;
        constraints.anchor=GridBagConstraints.NORTHWEST;
        JLabel jLabel=new JLabel("选择文件");
//        constraints.gridheight=1;
        constraints.gridwidth=1;
        gridBagLayout.setConstraints(jLabel,constraints);
        jf.add(jLabel);
        JTextField jTextField1=new JTextField(25);
//        constraints.gridheight= (int) 0.5;
        constraints.gridwidth=1;
        gridBagLayout.setConstraints(jTextField1,constraints);
        jf.add(jTextField1);
        JButton jButton1=new JButton("选择");
//        constraints.gridheight= (int) 0.5;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jButton1,constraints);

        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path path= Paths.get("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop");
                JFileChooser jFileChooser=new JFileChooser(path.toFile());
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue=jFileChooser.showOpenDialog(null);
                if (returnValue==JFileChooser.APPROVE_OPTION){
                    //用户做了选择文件操作
                    File file= jFileChooser.getSelectedFile();
                    jTextField1.setText(file.toString());
                }
            }
        });
        jf.add(jButton1);

        JLabel jLabe2=new JLabel("压缩到");
//        constraints.gridheight= (int) 0.5;
        constraints.gridwidth=1;
        gridBagLayout.setConstraints(jLabe2,constraints);
        jf.add(jLabe2);
        JTextField jTextField2=new JTextField(25);
//        constraints.gridheight= (int) 0.5;
        constraints.gridwidth=1;
        gridBagLayout.setConstraints(jTextField2,constraints);
        jf.add(jTextField2);
        JButton jButton2=new JButton("选择");
//        constraints.gridheight= (int) 0.5;
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jButton2,constraints);
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path path= Paths.get("C:\\Users\\"+System.getProperty("user.name")+"\\Desktop");
                JFileChooser jFileChooser=new JFileChooser(path.toFile());
                jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue=jFileChooser.showOpenDialog(null);
                if (returnValue==JFileChooser.APPROVE_OPTION){
                    //用户做了选择文件操作
                    File file= jFileChooser.getSelectedFile();
                    jTextField2.setText(file.toString());
                }
            }
        });
        jf.add(jButton2);

        JButton jButton3=new JButton("压缩");
        constraints.gridwidth=GridBagConstraints.REMAINDER;
        gridBagLayout.setConstraints(jButton3,constraints);

        JProgressBar bar=new JProgressBar(new DefaultBoundedRangeModel());
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setValue(0);
        bar.setOrientation(JProgressBar.HORIZONTAL);
        bar.setPreferredSize(new Dimension(450,30));
//        bar.setIndeterminate(true);
//        bar.setString("处理中");
        bar.setStringPainted(true);
        bar.setVisible(true);

        constraints.gridwidth=5;


        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar.setValue(0);
                ZipUtil zu=new ZipUtil(jTextField1.getText(),jTextField2.getText());
                Thread thread=new Thread(new ZipProgress(bar,zu));
                thread.start();
                zu.doZip();
            }
        });
        jf.add(jButton3);
        gridBagLayout.setConstraints(bar,constraints);
        jf.add(bar);


        jf.setVisible(true);



    }



}
