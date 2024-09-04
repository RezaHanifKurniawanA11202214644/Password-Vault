package id.my.rezaHanif.moduls.Page;

import id.my.rezaHanif.moduls.Base.BasePage;
import id.my.rezaHanif.moduls.CLI.*;
import id.my.rezaHanif.moduls.Data.*;
import id.my.rezaHanif.moduls.Interface.*;
import id.my.rezaHanif.moduls.View_Controller.Controller_JFrom;

public class MainPage extends BasePage {
    private SelectInput pageSelect;

    public MainPage(int width) {
        super("Aplikasi Penyimpanan Password", width);
        this.components.add(new Label("Selamat datang di aplikasi Password Vault",
                this.width));
        this.components.add(new Label("Simpan password anda dengan aman di sini",
                this.width));
        this.components.add(new Space(this.width));
        String[] pages = { "Input Password", "Tampilkan Account dengan GUI (JForm)", "Keluar Aplikasi" };
        this.pageSelect = new SelectInput("Pilih halaman berikut:",
                pages, this.width);
        this.components.add(pageSelect);
    }

    @Override
    protected void drawContent() throws Exception {
        int select;
        for (Drawable widget : this.components) {
            widget.draw();
        }
        select = this.pageSelect.getValue() - 1;
        switch (select) {
            case 0 -> {
                drawFooter();
                new InputPage(this.width).draw();
            }
            case 1 -> {
                drawFooter();
                DataPassword.saveCSVData();
                new Controller_JFrom().setVisible(true);
            }
            case 2 -> {
                new Label("Menyimpan data ... ...", this.width).draw();
                new Label("Terima kasih telah menggunakan aplikasi", this.width).draw();
                drawFooter();
                System.exit(0);
            }
            default -> {
                this.label.text = "--- --- --- --- ---";
                this.label.draw();
                new Label("Pilihan tidak valid", this.width).draw();
                this.label.text = "--- --- --- --- ---";
                this.label.draw();
                this.space.draw();
                new MainPage(this.width).draw();
            }
        }
    }
}
