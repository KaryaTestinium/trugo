package base;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Faker {

    private final com.github.javafaker.Faker faker;

    public Faker() {
        this.faker = new com.github.javafaker.Faker(new Locale("tr"));
    }

    public Map<String, String> generateUser() {
        Map<String, String> user = new HashMap<>();
        String name = faker.name().firstName();
        String city = faker.address().city();
        String address = faker.name().firstName() + " Caddesi " + faker.name().firstName() + " Sokak " + faker.number().digits(2) + "/" + faker.number().digits(1);
        String plaka   = faker.number().numberBetween(1, 82) + " " + faker.letterify("??").toUpperCase() + " " + faker.number().digits(3);

        user.put("Name", name);
        user.put("Surname", faker.name().lastName());
        user.put("PhoneNumber", "5342252816");
        user.put("registeredPhone", "5414532659");
        user.put("Email", "trugotest@gmail.com");
        user.put("registeredEmail", "karya.poyraz@gmail.com");
        user.put("InvoiceName", "Invoice" + name);
        user.put("City", city);
        user.put("Country", faker.address().country());
        user.put("Address", address);
        user.put("CompanyTitle", faker.company().profession());
        user.put("TaxNo", faker.number().digits(10));
        user.put("TaxOfficeName", city + " Vergi Dairesi");
        user.put("Plaka", plaka);

        return user;
    }

    public void generateUserCSV() throws IOException {
        String csvFileName = "fakerUser.csv";
        Map<String, String> user = generateUser();

        try (FileWriter writer = new FileWriter(csvFileName)) {
            writer.append(String.join(",", user.keySet())).append("\n");
            writer.append(String.join(",", user.values())).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        Faker generator = new Faker();
        generator.generateUserCSV();
    }
}
