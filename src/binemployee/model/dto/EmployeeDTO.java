package binemployee.model.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeDTO {

    private String fullName;
    private LocalDate birthDate;
    private String address;
    private long branchOfficeId;

    public EmployeeDTO(String fullName, LocalDate birthDate, String address, long branchOfficeId) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.branchOfficeId = branchOfficeId;
    }
}
