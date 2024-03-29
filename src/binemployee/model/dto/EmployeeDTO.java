package binemployee.model.dto;

import java.time.LocalDate;

public record EmployeeDTO(String fullName, LocalDate birthDate, String address, long branchOfficeId) {

    public EmployeeDTO {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        if (birthDate == null) {
            throw new IllegalArgumentException("Birth date cannot be null");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (branchOfficeId <= 0) {
            throw new IllegalArgumentException("Branch office id must be greater than 0");
        }
    }
}
