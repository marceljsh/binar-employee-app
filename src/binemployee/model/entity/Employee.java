package binemployee.model.entity;

import binemployee.common.Auditable;
import binemployee.utils.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Employee extends Auditable {

    private String fullName;
    private LocalDate birthDate;
    private String address;
    private Status status;
    private BranchOffice branchOffice;

    public Employee(String fullName, LocalDate birthDate, String address, BranchOffice branchOffice) {
        super();

        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.branchOffice = branchOffice;
        this.status = Status.ACTIVE;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", fullName, branchOffice);
    }
}
