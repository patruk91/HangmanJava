import java.lang.reflect.Array;

public class Country {
    private String country;
    private String capital;

    public Country(String[] countryAndCapital) {
        this.country = countryAndCapital[0];
        this.capital = countryAndCapital[1];
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return country + " " + capital + "\n";
    }

}
