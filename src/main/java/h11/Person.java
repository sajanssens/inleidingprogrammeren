package h11;

import h10.person.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.awt.*;

@Data
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    private int age;
    private Gender gender;
    private int schoenmaat;
    private String address;
    private Color kleurOgen;

}
