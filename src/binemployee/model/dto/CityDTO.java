package binemployee.model.dto;

import lombok.Getter;

@Getter
public class CityDTO {

    private String name;

    public CityDTO(String name) {
        this.name = name;
    }
}
