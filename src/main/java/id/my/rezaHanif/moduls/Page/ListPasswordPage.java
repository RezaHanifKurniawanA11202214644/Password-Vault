package id.my.rezaHanif.moduls.Page;

import id.my.rezaHanif.moduls.Base.BasePage;
import id.my.rezaHanif.moduls.Data.PasswordStore;
import static id.my.rezaHanif.moduls.Data.DataPassword.passData;

public class ListPasswordPage extends BasePage {

    public ListPasswordPage(int width) {
        super("List Password", width);
    }

    public void drawContent() throws Exception {
        this.label.text = "Terdapat " + passData.size() + " tersimpan.";
        this.label.draw();
        this.label.text = "---- ---- ----";
        this.label.draw();
        // proses mendapatkan kata terpanjang, agar ukuran column dapat seragam.
        // sekalipun textnya panjang(opsional).
        int col = 0;
        for (PasswordStore password : passData) {
            col = (password.name.length() > col) ? password.name.length() : col;
            col = (password.username.length() > col) ? password.username.length() : col;
            col = (password.getCategory().length() > col) ? password.getCategory().length() : col;
        }
        col++;
        for (PasswordStore password : passData) {
            this.label.text = ("| " + password.name + " ".repeat(col - password.name.length()) +
                    "| " + password.username + " ".repeat(col - password.username.length()) +
                    "| " + password.getCategory() + " ".repeat(col - password.getCategory().length()) + "|");
            this.label.draw();
        }
        drawFooter();
        new MainPage(this.width).draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }
}
