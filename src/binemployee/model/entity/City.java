package binemployee.model.entity;

import binemployee.common.Auditable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City extends Auditable {

    private String name;

    public City(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
