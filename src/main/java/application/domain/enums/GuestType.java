package application.domain.enums;

public enum GuestType {
    NUEVO("Nuevo"),
    FRECUENTE("Frecuente"),
    VIP("VIP"),
    CORPORATIVO("Corporativo");

    private final String description;

    GuestType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
