package binemployee.model.dto;

import lombok.Getter;

@Getter
public class BranchOfficeDTO {

    private long cityId;
    private String address;

    public BranchOfficeDTO(long cityId, String address) {
        this.cityId = cityId;
        this.address = address;
    }
}
