package application.view;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.service.BedRoomStateSelector;
import application.service.outputs.BedRoomService;
import application.util.FormValidationUtil;

import java.util.List;

public class BedRoomView {

    private final BedRoomService bedRoomService;

    public BedRoomView(BedRoomService bedRoomService) {
        this.bedRoomService = bedRoomService;
    }

    public void createBedRoom() {
        System.out.println("--- Crear Habitación ---");
        try {
            int roomId = FormValidationUtil.validateInt("Ingrese el Id de la habitación");
            String room = FormValidationUtil.validateString("Ingrese el número de habitación");
            int typeId = FormValidationUtil.validateInt("Ingrese el id del tipo");
            double price = FormValidationUtil.validateDouble("Ingrese el precio");
            String state = BedRoomStateSelector.bedRoomAddState();

            BedRoom bedRoom = new BedRoom(roomId, room, new BedRoomType(typeId, ""), price, state);
            BedRoom created = bedRoomService.createBedRoom(bedRoom);
            System.out.println("Habitación creada: " + created.getRoomId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAllBedRooms() {
        System.out.println("--- Listado de Habitaciones ---");
        List<BedRoom> bedRoomList = bedRoomService.getAllBedRooms();
        for (BedRoom bedroom : bedRoomList) {
            System.out.println(bedroom.getRoomId() + " | "
                    + bedroom.getRoom() + " | "
                    + bedroom.getBedRoomType().getType() + " | "
                    + bedroom.getPrice() + " | "
                    + bedroom.getState());
        }
    }

    public void getBedRoomById() {
        System.out.println("--- Buscar Habitación ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el ID");
            BedRoom bedRoom = bedRoomService.getBedRoomById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada"));

            System.out.println(bedRoom.getRoomId() + " | "
                    + bedRoom.getRoom() + " | "
                    + bedRoom.getBedRoomType().getType() + " | "
                    + bedRoom.getPrice() + " | "
                    + bedRoom.getState());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateBedRoom() {
        System.out.println("--- Actualizar Habitación ---");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el ID de la habitación a actualizar");
            BedRoom current = bedRoomService.getBedRoomById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Habitación no existe"));

            System.out.println("Datos actuales: " + current.getRoom() + " (" + current.getBedRoomType().getType() + ")");
            
            System.out.println("Seleccione campo a actualizar:\n1. Número\n2. Tipo\n3. Precio\n4. Estado");
            int option = FormValidationUtil.validateInt("Opción");

            switch (option) {
                case 1:
                    current.setRoom(FormValidationUtil.validateString("Nuevo número"));
                    break;
                case 2:
                    int typeId = FormValidationUtil.validateInt("Nuevo ID de tipo");
                    current.setBedRoomType(new BedRoomType(typeId, ""));
                    break;
                case 3:
                    current.setPrice(FormValidationUtil.validateDouble("Nuevo precio"));
                    break;
                case 4:
                    current.setState(BedRoomStateSelector.bedRoomAddState());
                    break;
                default:
                    System.out.println("Opción no válida");
                    return;
            }

            bedRoomService.updateBedRoom(id, current);
            System.out.println("Habitación actualizada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteBedRoomById() {
        try {
            int id = FormValidationUtil.validateInt("Ingrese el ID a eliminar");
            bedRoomService.deleteBedRoomById(id);
            System.out.println("Habitación eliminada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
