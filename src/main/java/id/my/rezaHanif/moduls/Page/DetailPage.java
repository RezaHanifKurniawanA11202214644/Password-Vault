package id.my.rezaHanif.moduls.Page;

import id.my.rezaHanif.moduls.Base.BasePage;
import id.my.rezaHanif.moduls.Data.PasswordStore;

public class DetailPage extends BasePage {
    private PasswordStore passStr;

    public DetailPage(int width) {
        super("Detail Password", width);
    }

    public void drawContent() throws Exception {
        this.label.text = "Detail Password";
        this.label.draw();
        this.label.text = "---- ---- ----";
        this.label.draw();
        this.label.text = "Judul : " + passStr.name;
        this.label.draw();
        this.label.text = "Username : " + passStr.username;
        this.label.draw();
        this.label.text = "Password : " + passStr.password;
        this.label.draw();
        this.label.text = "Kategori : " + passStr.getCategory();
        this.label.draw();
        drawFooter();
        new MainPage(this.width).draw();
    }

}
