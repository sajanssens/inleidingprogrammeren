package h10.person;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Person {

    private String name;
    private int age;
    private int schoenmaat;
    private Gender gender;

    public void birthday() { this.age++; }

    // overrule lombok's setter:
    public void setAge(int age) {
        if (age <= 130) {
            this.age = age;
        }
    }

    // overrule lombok's equals:
    public boolean equals(Object o) {
        return name.equals(((Person) o).getName());
    }
}
