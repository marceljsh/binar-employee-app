package binemployee.model.dto;

public record BranchOfficeDTO(long cityId, String address) {

    public BranchOfficeDTO {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
        if (cityId <= 0) {
            throw new IllegalArgumentException("City ID must be greater than 0");
        }
    }
}
