package application.domain.enums;

public enum EmployeePosition {
    ADMINISTRADOR("Administrador"),
    RECEPCIONISTA("Recepcionista"),
    LIMPIEZA("Personal de Limpieza"),
    MANTENIMIENTO("Mantenimiento"),
    GERENTE("Gerente");

    private final String description;

    EmployeePosition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
