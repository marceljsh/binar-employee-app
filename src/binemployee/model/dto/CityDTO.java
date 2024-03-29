package binemployee.model.dto;

public record CityDTO(String name) {
    public CityDTO {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("City name cannot be null or empty");
        }
    }
}
