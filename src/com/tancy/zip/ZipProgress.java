package com.tancy.zip;

import javax.swing.*;
import java.awt.*;

public class ZipProgress implements Runnable {

    private JProgressBar progressBar;
    private ZipUtil zipUtil;

    public ZipProgress(JProgressBar progressBar, ZipUtil zipUtil) {
        this.progressBar = progressBar;
        this.zipUtil = zipUtil;
    }

    @Override
    public void run() {
        try {
            while (!zipUtil.isWalkFileDone()){
                Thread.sleep(1);
            }
            progressBar.setMaximum(zipUtil.getTotalFiles());
//            progressBar.setStringPainted(true);
//            progressBar.setIndeterminate(false);
            while (zipUtil.getZipsDone()<zipUtil.getTotalFiles()){
                Rectangle rectangle=new Rectangle(progressBar.getPreferredSize());
                progressBar.setValue(zipUtil.getZipsDone());
                progressBar.paintImmediately(rectangle);
//                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Rectangle rectangle=new Rectangle(progressBar.getPreferredSize());
        progressBar.setValue(zipUtil.getZipsDone());
        progressBar.paintImmediately(rectangle);
//        progressBar.setVisible(false);
    }
}
