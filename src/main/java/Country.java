public class Country {
    private final String code;
    private final String name;
    private final long population;

    public Country(String code, String name, long population) {
        this.code = code;
        this.name = name;
        this.population = population;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) ma %d ludności.", name, code, population);
    }
}
