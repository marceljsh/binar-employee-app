package binemployee.utils;

import lombok.Getter;

@Getter
public enum Status {

    ACTIVE("active", 1),
    INACTIVE("inactive", 0);

    private final String description;
    private final int code;

    Status(String description, int code) {
        this.description = description;
        this.code = code;
    }
}
