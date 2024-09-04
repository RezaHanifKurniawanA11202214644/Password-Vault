package id.my.rezaHanif.moduls.App;


import id.my.rezaHanif.moduls.Data.DataPassword;
import id.my.rezaHanif.moduls.Page.MainPage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
       public static void main(String[] args) throws Exception {
           DataPassword.loadCSVData();
           new MainPage(50).draw();
    }
}

// Path: src/main/java/id/my/rezaHanif/moduls/Base/BasePage.java