package id.my.rezaHanif.moduls.Base;

import java.util.ArrayList;

import id.my.rezaHanif.moduls.CLI.HLine;
import id.my.rezaHanif.moduls.CLI.Label;
import id.my.rezaHanif.moduls.CLI.Space;
import id.my.rezaHanif.moduls.Interface.Drawable;

public abstract class BasePage {
    public String title;
    public int width;
    protected HLine hline;
    protected Space space;
    protected Label label;
    protected ArrayList<Drawable> components = new ArrayList<>();

    public BasePage(String title, int width) {
        this.width = width;
        this.title = title;
        this.hline = new HLine(width);
        this.space = new Space(width);
        this.label = new Label(title.toUpperCase(), width);
    }

    public void draw() throws Exception {
        this.drawHeader();
        this.space.draw();
        this.drawContent();
    }

    public void drawHeader() {
        this.hline.draw();
        this.space.draw();
        this.label.draw();
        this.space.draw();
        this.hline.draw();
    }

    public void drawFooter() {
        this.space.draw();
        this.hline.draw();
    }

    protected abstract void drawContent() throws Exception;

}
