package android.example.com.retrofitexercise;

public class Puppy {
    private String dogURL;

    public Puppy(String dogURL) {
        this.dogURL = dogURL;
    }

    public String getDogURL() {
        return dogURL;
    }
}
