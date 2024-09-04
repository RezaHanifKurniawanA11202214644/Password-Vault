package id.my.rezaHanif.moduls.CLI;

import id.my.rezaHanif.moduls.Interface.Drawable;

public class Label implements Drawable {
    // ATTRIBUTE
    private int width;
    public String text;

    // CONSTRUCTOR
    public Label(String text, int width) {
        this.width = width;
        this.text = text;
    }

    // METHOD
    public void draw() {
        StringBuilder label = new StringBuilder("| ");

        // Mengecek apakah panjang teks lebih kecil dari lebar minimal area
        if (text.length() <= width - 2) {
            int spaceCount = width - 2 - text.length();
            label.append(text);
            for (int i = 0; i < spaceCount; i++) {
                label.append(" ");
            }
        } else {
            label.append(text.substring(0, width - 5)).append("...");
        }
        label.append(" |");
        System.out.println(label);
    }
}
