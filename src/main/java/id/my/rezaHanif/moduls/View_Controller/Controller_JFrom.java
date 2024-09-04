package id.my.rezaHanif.moduls.View_Controller;

import id.my.rezaHanif.moduls.Data.PasswordStore;
import id.my.rezaHanif.moduls.Page.MainPage;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class Controller_JFrom extends lat_JFrame_JTable {

    //constructor
    public Controller_JFrom() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                // Kode untuk kembali ke MainPage
                try {
                    new MainPage(50).draw();
                } catch (Exception exc) {
                    System.out.println("Error: " + exc.getMessage());
                }
            }
        });
    }

    // Comparator untuk mengurutkan data berdasarkan title
    public static Comparator<PasswordStore> TitleComparator = new Comparator<PasswordStore>(){
        @Override
        public int compare(PasswordStore ps1, PasswordStore ps2) {
            return ps1.name.compareTo(ps2.name);
        }
    };

    // Comparator untuk mengurutkan data berdasarkan username
    public static Comparator<PasswordStore> UsernameComparator = new Comparator<PasswordStore>() {
        @Override
        public int compare(PasswordStore ps1, PasswordStore ps2) {
            return ps1.username.compareTo(ps2.username);
        }
    };

    // Comparator untuk mengurutkan data berdasarkan password
    public static Comparator<PasswordStore> ScoreComparator = new Comparator<PasswordStore>() {
        @Override
        public int compare(PasswordStore ps1, PasswordStore ps2) {
            return Double.compare(ps1.getScore(), ps2.getScore());
        }
    };

    // Comparator untuk mengurutkan data berdasarkan category
    public static Comparator<PasswordStore> CategoryComparator = new Comparator<PasswordStore>() {
        @Override
        public int compare(PasswordStore ps1, PasswordStore ps2) {
            return ps1.getCategory().compareTo(ps2.getCategory());
        }
    };


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(lat_JFrame_JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lat_JFrame_JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lat_JFrame_JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lat_JFrame_JTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lat_JFrame_JTable().setVisible(true);
            }
        });
    }
}
