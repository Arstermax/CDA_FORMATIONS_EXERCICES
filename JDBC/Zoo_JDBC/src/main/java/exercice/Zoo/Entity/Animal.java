package exercice.Zoo.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class Animal {
    private String name, race, description, habitat;
    private int age, id;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", description='" + description + '\'' +
                ", habitat='" + habitat + '\'' +
                ", age=" + age +
                '}';
    }
}
