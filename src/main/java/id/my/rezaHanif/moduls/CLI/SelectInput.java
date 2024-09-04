package id.my.rezaHanif.moduls.CLI;

import id.my.rezaHanif.moduls.Interface.Drawable;

public class SelectInput implements Drawable {
    /* ATTRIBUTE */
    private String label;
    private int width;
    private String[] selection;
    private Input input;
    private int value;

    /* CONSTRUCTOR */
    public SelectInput(String label, String[] selection, int width) {
        this.label = label;
        this.width = width;
        this.selection = selection;
        this.input = new Input("Pilhan : ");
    }

    /* METHOD */
    public void draw() throws Exception {
        StringBuilder labelBuilder = new StringBuilder("| ");
        labelBuilder.append(label);
        int lenghtSpace = width - labelBuilder.length();
        for (int i = 0; i < lenghtSpace; i++) {
            labelBuilder.append(" ");
        }
        labelBuilder.append(" |");
        System.out.println(labelBuilder);

        for (int i = 0; i < selection.length; i++) {
            labelBuilder = new StringBuilder("| ");
            labelBuilder.append("   [").append(i + 1).append("] ").append(selection[i]);
            lenghtSpace = width - labelBuilder.length();
            for (int j = 0; j < lenghtSpace; j++) {
                labelBuilder.append(" ");
            }
            labelBuilder.append(" |");
            System.out.println(labelBuilder);
        }
        input.draw();
        value = Integer.parseInt(input.getValue());
    }

    public int getValue() {
        return value;
    }
}
