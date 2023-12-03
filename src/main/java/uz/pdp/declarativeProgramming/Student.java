package uz.pdp.declarativeProgramming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Student {
    private Integer id;
    private String name;
    private String email;
    private String gender;
    private int age;
}
