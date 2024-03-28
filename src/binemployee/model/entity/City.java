package binemployee.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends BaseEntity {

    private String name;

    public City() {
        super();
    }

    public City(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
