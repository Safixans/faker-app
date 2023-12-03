package uz.pdp.fakeInfo;

import com.github.javafaker.Faker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Supplier;


public class GenerationOfFakeData {
    static final Map<FieldType, Supplier<Object>> functions = new HashMap<>();

    static {
        Random random = new Random();
        UUID uuid = new UUID(1, 10000);
        Faker faker = new Faker();
        Supplier<Object> function = faker.name()::firstName;

        functions.put(FieldType.ID, () -> faker.random().nextInt(1, 40));
        functions.put(FieldType.UUID, () -> random.nextInt());
        functions.put(FieldType.BOOK_TITLE, () -> faker.book().title());
        functions.put(FieldType.BOOT_AUTHOR, () -> faker.book().author());
        functions.put(FieldType.POST_TITLE, () -> faker.lorem().sentence());
        functions.put(FieldType.POST_BODY, () -> faker.lorem().paragraph());
        functions.put(FieldType.FIRSTNAME, () -> faker.name().firstName());
        functions.put(FieldType.LASTNAME, () -> faker.name().lastName());
        functions.put(FieldType.USERNAME, () -> faker.name().username());
        functions.put(FieldType.FULLNAME, () -> faker.name().fullName());
        functions.put(FieldType.EMAIL, () -> faker.internet().emailAddress());
        functions.put(FieldType.GENDER, () -> faker.demographic().sex());
        functions.put(FieldType.PHONE, () -> faker.phoneNumber().phoneNumber());
        functions.put(FieldType.AGE, () -> faker.number().numberBetween(7, 70));
        functions.put(FieldType.COUNTRY_CODE, () -> faker.address().countryCode());
        functions.put(FieldType.COUNTRY_ZIP_CODE, () -> faker.address().zipCode());
        functions.put(FieldType.WORD, () -> faker.lorem().word());
        functions.put(FieldType.WORDS, () -> faker.lorem().words(3));
        functions.put(FieldType.PARAGRAPH, () -> faker.lorem().paragraph());
        functions.put(FieldType.PARAGRAPHS, () -> faker.lorem().paragraphs(3));
        functions.put(FieldType.LETTERS, () -> faker.lorem().characters(10));
        functions.put(FieldType.RANDOM_INT, () -> faker.random().nextInt(1, 100));
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print(" Enter File name: ");
        String fileName = scanner.nextLine();
        System.out.print(" Enter type: (JSON)(CSV) ");
        String type = scanner.nextLine();
        String format = type.toUpperCase();

        System.out.print(" Enter row count: ");
        int count = scanner.nextInt();
        Request request = new Request(fileName, count, type);
        List<Pairs> pairsList = new ArrayList<>();

        if (format.equals("JSON")) {
            JSONDataFormat(request, pairsList);

        } else if (format.equals("CSV")) {
            CSVDataFormat(request, pairsList);
        }else {
            System.out.println("unavailable type");
        }


    }

    private static void CSVDataFormat(Request request, List<Pairs> pairsList) throws IOException {
        Scanner scanner=new Scanner(System.in);
        boolean coreLoop=true;
        while (coreLoop){
            System.out.println("Enter field name: ");
            String fieldName = scanner.next();
            menu();
            FieldType fieldType = getFieldType(scanner);
            if (fieldType != null) {
                System.out.println("\u001B[32m" + fieldName + "\u001B[0m  " + "\u001B[32m" + fieldType + "\u001B[0m");
                pairsList.add(new Pairs(fieldName, fieldType));
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("Add Field y(es)");
            System.out.println("Add Field n(o)");
            String toContinue = scanner.next();
            if (toContinue.equals("y") || toContinue.equals("Y")) {
                coreLoop = true;
            } else if (toContinue.equals("n") || toContinue.equals("N")) {
                coreLoop = false;
            } else {
                System.out.println("wrong input try again! ");
                coreLoop = false;
            }
        }
            request.setPairs(pairsList);
            generateDataAsCSV(request);
    }

    private static void JSONDataFormat(Request request, List<Pairs> pairsList) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = true;
        while (isTrue) {
            System.out.println("Enter field name: ");
            String fieldName = scanner.next();
            menu();
            FieldType fieldType = getFieldType(scanner);

            if (fieldType != null) {
                System.out.println("\u001B[32m" + fieldName + "\u001B[0m : " + "\u001B[32m" + fieldType + "\u001B[0m");
                pairsList.add(new Pairs(fieldName, fieldType));
            } else {
                System.out.println("Invalid input.");
            }
            System.out.println("Add Field y(es)");
            System.out.println("Add Field n(o)");
            String toContinue = scanner.next();
            if (toContinue.equals("y") || toContinue.equals("Y")) {
                isTrue = true;
            } else if (toContinue.equals("n") || toContinue.equals("N")) {
                isTrue = false;
            } else {
                System.out.println("wrong input try again! ");
                isTrue = false;
            }


            request.setPairs(pairsList);
            generateRandomDataAsJSON(request);
        }
    }

    private static FieldType getFieldType(Scanner scanner) {
        System.out.println("Enter one of the Types by pressing number that proper on your choice");
        String userInput = scanner.next();
        FieldType fieldType = switch (userInput) {
            case "1" -> FieldType.ID;
            case "2" -> FieldType.UUID;
            case "3" -> FieldType.BOOK_TITLE;
            case "4" -> FieldType.BOOT_AUTHOR;
            case "5" -> FieldType.POST_TITLE;
            case "6" -> FieldType.POST_BODY;
            case "7" -> FieldType.FIRSTNAME;
            case "8" -> FieldType.LASTNAME;
            case "9" -> FieldType.USERNAME;
            case "10" -> FieldType.FULLNAME;
            case "11" -> FieldType.BLOOD_GROUP;
            case "12" -> FieldType.EMAIL;
            case "13" -> FieldType.GENDER;
            case "14" -> FieldType.PHONE;
            case "15" -> FieldType.LOCALDATE;
            case "16" -> FieldType.AGE;
            case "17" -> FieldType.COUNTRY_CODE;
            case "18" -> FieldType.COUNTRY_ZIP_CODE;
            case "19" -> FieldType.CAPITAL;
            case "20" -> FieldType.WORD;
            case "21" -> FieldType.WORDS;
            case "22" -> FieldType.PARAGRAPH;
            case "23" -> FieldType.PARAGRAPHS;
            case "24" -> FieldType.LETTERS;
            case "25" -> FieldType.RANDOM_INT;
            default -> null;
        };
        return fieldType;
    }

    private static void menu() {

        System.out.println(
                "1. ID\t\t\t" + "14. PHONE\n" +
                        "2. UUID\t\t\t" + "15. LOCALDATE\n" +
                        "3. BOOK TITLE\t" + "16. AGE\n" +
                        "4. BOOT AUTHOR\t" + "17. COUNTRY CODE\n" +
                        "5. POST_TITLE\t" + "18. COUNTRY ZIP CODE\n" +
                        "6. POST BODY\t" + "19. CAPITAL\n" +
                        "7. FIRSTNAME\t" + "20. WORD\n" +
                        "8. LASTNAME\t\t" + "21. WORDS\n" +
                        "9. USERNAME\t\t" + "22. PARAGRAPH\n" +
                        "10. FULLNAME\t " + "23. PARAGRAPHS\n" +
                        "11. BLOOD GROUP\t" + "24. LETTERS\n" +
                        "12. EMAIL\t" + "25. RANDOM INT\n" +
                        "13. GENDER"
        );

    }

    private static void generateRandomDataAsJSON(Request request) throws IOException {
        List<Pairs> pairs = request.getPairs();
        StringJoiner jsonDataArray = new StringJoiner(",", "[", "\n]");
        List<Entry> neededMethods = getNeededMethods(pairs);


        for (int i = 0; i < request.getCount(); i++) {
            StringJoiner jsonData = new StringJoiner(",\n", "\n{\n", "\n}");

            for (Entry entry : neededMethods) {
                FieldType fieldType = entry.getFieldType();
                String fieldName = entry.getFieldName();
                Supplier<Object> entrySupplier = entry.getSupplier();
                jsonData.add(fieldType.getJsonPairs(fieldName, entrySupplier.get()));
            }
            jsonDataArray.add(jsonData.toString());
        }

        System.out.println(jsonDataArray);

        Files.writeString(Path.of(request.getFilename()), jsonDataArray.toString());
    }

    private static void generateDataAsCSV(Request request) throws IOException {
        List<Pairs> pairs = request.getPairs();
        StringJoiner csvDataArray = new StringJoiner("\n");
        List<Entry> neededMethods = getNeededMethods(pairs);


        StringJoiner headerRow = new StringJoiner("; ");
        for (Entry entry : neededMethods) {
            String fieldName = entry.getFieldName();
            headerRow.add(fieldName);
        }
        csvDataArray.add(headerRow.toString());

        for (int i = 0; i < request.getCount(); i++) {
            StringJoiner rowData = new StringJoiner("; ");

            for (Entry entry : neededMethods) {
                FieldType fieldType = entry.getFieldType();
                Supplier<Object> entrySupplier = entry.getSupplier();
                Object value = entrySupplier.get();


                String formattedValue = value.toString();
                if (formattedValue.contains("; ")) {
                    formattedValue = "\"" + formattedValue + "\"";
                }

                rowData.add(formattedValue);
            }
            csvDataArray.add(rowData.toString());
        }

        System.out.println(csvDataArray);

        Files.writeString(Path.of(request.getFilename()), csvDataArray.toString());
    }


    private static List<Entry> getNeededMethods(List<Pairs> pairs) {
        var list = new ArrayList<Entry>();
        for (Pairs pair : pairs) {
            list.add(new Entry(pair.getField_name(), pair.getField_type(), functions.get(pair.getField_type())));

        }
        return list;
    }
}
