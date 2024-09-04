package id.my.rezaHanif.moduls.Page;

import id.my.rezaHanif.moduls.Data.*;
import static id.my.rezaHanif.moduls.Data.DataPassword.passData;

import id.my.rezaHanif.moduls.Base.BasePage;
import id.my.rezaHanif.moduls.CLI.Input;
import id.my.rezaHanif.moduls.CLI.SelectInput;

public class InputPage extends BasePage {
    private Input nameInput;
    private Input usernameInput;
    private Input passInput;
    private SelectInput catInput;
    private PasswordStore passStr;

    public InputPage(int width) {
        super("Inputan Password", width);
    }

    public void drawContent() throws Exception {
        String judul, username, password;
        String[] category = { "Belum terkategori", "Aplikasi web", "Aplikasi mobile", "Akun lainnya" };
        catInput = new SelectInput("Kategori", category, this.width);
        this.label.text = "Inputan Password Baru";
        this.label.draw();
        nameInput = new Input("Judul Password : ");
        nameInput.draw();
        judul = nameInput.getValue();
        usernameInput = new Input("Username : ");
        usernameInput.draw();
        username = usernameInput.getValue();
        passInput = new Input("Password : ");
        passInput.draw();
        password = passInput.getValue();
        catInput.draw();
        int cat = catInput.getValue();
        passStr = new PasswordStore(judul, username, password, cat);
        do {
            int value = catInput.getValue();
            if (value < 1 || value > category.length) {
                StringBuilder labelWarningBuilder = new StringBuilder("| ");
                labelWarningBuilder.append("Kategori tidak valid");
                StringBuilder lineWarningBuilder = new StringBuilder("| ");
                lineWarningBuilder.append("--- --- --- --- ---");
                int lineWarningSpace = width - lineWarningBuilder.length();
                int labelWarningSpace = width - labelWarningBuilder.length();
                for (int j = 0; j < labelWarningSpace; j++) {
                    labelWarningBuilder.append(" ");
                }
                for (int i = 0; i < lineWarningSpace; i++) {
                    lineWarningBuilder.append(" ");
                }
                labelWarningBuilder.append(" |");
                lineWarningBuilder.append(" |");
                System.out.println(lineWarningBuilder);
                System.out.println(labelWarningBuilder);
                System.out.println(lineWarningBuilder);
                this.drawFooter();
                this.space.draw();
                catInput.draw();
            }
        } while (catInput.getValue() < 1 || catInput.getValue() > category.length);
        passData.add(passStr);
        this.label.text = "--- --- --- --- ---";
        this.label.draw();
        this.label.text = "Password berhasil disimpan";
        this.label.draw();
        this.label.text = "--- --- --- --- ---";
        this.label.draw();
        this.drawFooter();
        new MainPage(this.width).draw();
    }
}
