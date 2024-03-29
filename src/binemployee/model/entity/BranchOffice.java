package binemployee.model.entity;

import binemployee.common.Auditable;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BranchOffice extends Auditable {

    private City city;
    private String address;

    public BranchOffice(City city, String address) {
        super();

        this.city = city;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s HQ <%s>", getCity(), address);
    }
}
