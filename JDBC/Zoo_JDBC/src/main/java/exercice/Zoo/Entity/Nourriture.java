package exercice.Zoo.Entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Nourriture {
    private String name, date, hours, details;

    @Override
    public String toString() {
        return "Nourriture{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", hours='" + hours + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
