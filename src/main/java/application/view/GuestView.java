package application.view;

import application.domain.Guest;
import application.domain.enums.GuestType;
import application.service.outputs.GuestService;
import application.util.FormValidationUtil;

import java.util.List;

public class GuestView {

    private final GuestService guestService;

    public GuestView(GuestService guestService) {
        this.guestService = guestService;
    }

    public void createGuest() {
        System.out.println("--- Crear Huésped ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el ID");
            String name = FormValidationUtil.validateString("Ingrese el nombre");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese la contraseña");
            String origin = FormValidationUtil.validateString("Ingrese el origen");
            
            System.out.println("Seleccione tipo de huésped:");
            for (GuestType type : GuestType.values()) {
                System.out.println(type.ordinal() + 1 + ". " + type.getDescription());
            }
            int typeIdx = FormValidationUtil.validateInt("Opción") - 1;
            GuestType guestType = GuestType.values()[typeIdx];

            Guest guest = new Guest(id, name, lastName, email, password, true, origin, guestType);
            guestService.createGuest(guest);
            System.out.println("Huésped registrado con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAllGuests() {
        System.out.println("--- Listado de Huéspedes ---");
        List<Guest> guests = guestService.getAllGuests();
        for (Guest g : guests) {
            System.out.println(g.getId() + " | " + g.getName() + " " + g.getLastName() + " | " + g.getGuestType().getDescription());
        }
    }
}
