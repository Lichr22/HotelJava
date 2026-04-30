package application.repository;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.domain.enums.BedRoomState;
import application.service.ports.BedRoomRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class BedRoomRepository implements BedRoomRepositoryPort {

    private final List<BedRoom> bedRooms = new CopyOnWriteArrayList<>(List.of(
            new BedRoom(1, "201", new BedRoomType(1, "Individual"), 120000, BedRoomState.DISPONIBLE.getDescription()),
            new BedRoom(2, "202", new BedRoomType(2, "Doble"), 180000, BedRoomState.OCUPADA.getDescription()),
            new BedRoom(3, "203", new BedRoomType(3, "Suite"), 240000, BedRoomState.RESERVADA.getDescription())));

    public BedRoom saveBedRoom(BedRoom bedRoom) {

        bedRooms.add(bedRoom);

        return bedRoom;

    }

    @Override
    public BedRoom updateBedRoom(int id, BedRoom bedRoom) {
        for (int i = 0; i < bedRooms.size(); i++) {
            if (bedRooms.get(i).getRoomId() == id) {
                bedRooms.set(i, bedRoom);
                return bedRoom;
            }
        }
        throw new IllegalArgumentException("Habitación con Id " + id + " no encontrada");
    }

    @Override
    public Optional<BedRoom> findBedRoomById(int id) {
        return bedRooms.stream()
                .filter(bedroom -> bedroom.getRoomId() == id)
                .findFirst();
    }

    @Override
    public List<BedRoom> findAllBedRooms() {

        return bedRooms;

    }

    @Override
    public void deleteBedRoomById(int id) {
        boolean removed = bedRooms.removeIf(bedroom -> bedroom.getRoomId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Habitacion con id " + id + " no encontrada.");
        }
    }
}
