package id.my.rezaHanif.moduls.CLI;

import id.my.rezaHanif.moduls.Interface.Drawable;

import java.util.Scanner;

public class Input implements Drawable {
    // ATTRIBUTE
    private String label;
    private Scanner input;
    private String value;

    /* CONSTRUCTOR */
    public Input(String label) {
        this.label = label;
        this.input = new Scanner(System.in);
    }

    /* METHOD */
    @Override
    public void draw() {
        System.out.print("| " + label);
        value = input.nextLine();
    }

    public String getValue() {
        return value;
    }

    public int getValueInt() {
        return Integer.parseInt(getValue());
    }

    public double getValueDouble() {
        return Double.parseDouble(getValue());
    }
}
