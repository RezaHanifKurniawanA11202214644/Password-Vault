package id.my.rezaHanif.moduls.Data;

import id.my.rezaHanif.moduls.Encryptor.Encryptor;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PasswordStore {
    public String name, username;
    public String password;
    private String hashkey;
    private double score;
    private int category;
    public static final String[] CATEGORIES = { "Belum terkategori",
            "Aplikasi Web", "Aplikasi Mobile", "Akun Lainnya" };


    public PasswordStore(String name, String username, String plainPass, int category) {
        try {
            this.hashkey = Encryptor.generateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.name = name;
        this.username = username;
        this.setPassword(plainPass);
        this.setCategory(category);
    }

    public PasswordStore(String name, String username, String encPass,
            int category, String hashKey, double score) {
        this.name = name;
        this.username = username;
        this.password = encPass;
        this.category = category;
        this.hashkey = hashKey;
        this.score = score;
    }


    public void setPassword(String plainPass) {
        String encryptedPass;
        try {
            encryptedPass = Encryptor.encrypt(plainPass, this.hashkey);
            this.password = encryptedPass;
            this.calculateScore(plainPass);
        } catch (Exception ex) {
            Logger.getLogger(PasswordStore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getEncPassword() {
        return this.password;
    }

    public String getHashkey() {
        return this.hashkey;
    }

    public double getScore() {
        return this.score;
    }

    public int getCategoryCode() {
        return this.category;
    }

    public void setCategory(int category) {
        if (category >= 1 && category <= CATEGORIES.length ) {
            this.category = category - 1;
        } else {
            this.category = 0;
        }
    }

    public String getCategory() {
    if (this.category < 0 || this.category >= CATEGORIES.length) {
        // Jika kategori tidak valid, kembalikan string kosong atau pesan kesalahan
        return "";
    }else {
        return CATEGORIES[category];
    }
}

    private void calculateScore(String plainPass) {
        double len = plainPass.length();
        if (len > 15) {
            this.score = 10;
        } else {
            this.score = (len / 15) * 10;
        }
    }

    @Override
    public String toString() {
        return this.username + " - " + this.password + " - " + this.hashkey + " - "
                + String.format("%,.2f", this.score);
    }
}
