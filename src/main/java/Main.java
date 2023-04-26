import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "countries.csv";

    // nie zmieniaj nic w main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        main.run(scanner);
    }

    void run(Scanner scanner) {
        try {
            Map<String, Country> map = createCountriesMapFromFile();
            showCountryStats(scanner, map);
        } catch (FileNotFoundException e) {
            System.out.println("Brak pliku countries.csv.");
        }
    }

    private void showCountryStats(Scanner scanner, Map<String, Country> map) {
        System.out.println("Spośród dostępnych krajów [PL|DE|GB|FR|CZ] podaj kod kraju, o którym chcesz zobaczyć informacje:");
        String code = scanner.nextLine();
        if (map.containsKey(code)) {
            System.out.println(map.get(code));
        } else {
            System.out.println("Kod kraju " + code + " nie został znaleziony.");
        }
    }

    private Map<String, Country> createCountriesMapFromFile() throws FileNotFoundException {
        Map<String, Country> countries = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] split = line.split(";");
                countries.put(split[0], new Country(split[0], split[1], Long.parseLong(split[2])));
            }
        }
        return countries;
    }
}
