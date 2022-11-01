package udemy_master_class.section_4.one.data;

import java.util.Arrays;

public class GameConfig {
    private int releaseYear;
    private String gameName;
    private double price;

    private String[] characterNames;

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getCharacterNames() {
        return characterNames;
    }

    public void setCharacterNames(String[] characterNames) {
        this.characterNames = characterNames;
    }

    @Override
    public String toString() {
        return String.format("GameConfig [releaseYear: %s, gameName: %s, price: %s, characterNames: %s]", releaseYear,
                gameName, price, Arrays.toString(characterNames));
    }
}
