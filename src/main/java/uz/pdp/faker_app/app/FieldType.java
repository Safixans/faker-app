package uz.pdp.faker_app.app;

public enum FieldType {


    ID("\""),
    CELL_PHONE("\""),
    TITLE("\""),
    COUNTRY("\""),
    BOOK_TITLE("\""),
    POST_TITLE("\""),
    FIRSTNAME("\""),
    USERNAME("\""),
    BLOOD_GROUP("\""),
    GENDER("\""),
    LOCALDATE("\""),
    COUNTRY_CODE("\""),
    CAPITAL("\""),
    WORDS("\""),
    PARAGRAPHS("\""),
    UUID("\""),
    BOOT_AUTHOR("\""),
    POST_BODY("\""),
    LASTNAME("\""),
    FULLNAME("\""),
    EMAIL("\""),
    PHONE("\""),
    AGE(""),
    COUNTRY_ZIP_CODE("\""),
    WORD("\""),
    PARAGRAPH("\""),
    LETTERS("\""),
    RANDOM_INT("");

    private final String i;

    FieldType(String i) {
        this.i = i;
    }

    public String getJsonPairs(String fieldName, Object value) {
        return "\t\"%s\" : %s%s%s".formatted(fieldName, i, value, i);
    }
}
