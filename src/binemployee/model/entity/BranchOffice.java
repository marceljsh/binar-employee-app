package binemployee.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BranchOffice extends BaseEntity {

    private City city;
    private String address;

    public BranchOffice() {
        super();
    }

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
