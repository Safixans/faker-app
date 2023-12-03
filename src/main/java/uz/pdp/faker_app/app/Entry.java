package uz.pdp.faker_app.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.function.Supplier;
@Getter
@AllArgsConstructor

public class Entry {
    private String fieldName;
    private FieldType fieldType;
    private Supplier<Object> supplier;

}
