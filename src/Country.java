import java.lang.reflect.Array;

public class Country {
    private String name;
    private String capital;

    public Country(String[] countryAndCapital) {
        this.name = countryAndCapital[0];
        this.capital = countryAndCapital[1];
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return name + " " + capital + "\n";
    }

}
