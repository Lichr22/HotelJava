package application.service;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.service.outputs.BedRoomService;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.BedRoomTypeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class BedRoomServiceImpl implements BedRoomService {

    private final BedRoomRepositoryPort bedRoomRepositoryPort;
    private final BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort;

    public BedRoomServiceImpl(BedRoomRepositoryPort bedRoomRepositoryPort, BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort) {
        this.bedRoomRepositoryPort = bedRoomRepositoryPort;
        this.bedRoomTypeRepositoryPort = bedRoomTypeRepositoryPort;
    }

    @Override
    public BedRoom createBedRoom(BedRoom bedRoom) {
        // Resolve aggregation and business validation
        BedRoomType bedRoomType = addBedRoomType(bedRoom.getBedRoomType().getIdType());
        bedRoom.setBedRoomType(bedRoomType);

        if (bedRoomRepositoryPort.findBedRoomById(bedRoom.getRoomId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe una habitación con ID: " + bedRoom.getRoomId());
        }

        return bedRoomRepositoryPort.saveBedRoom(bedRoom);
    }

    @Override
    public BedRoom updateBedRoom(int id, BedRoom bedRoom) {
        BedRoom existing = bedRoomRepositoryPort.findBedRoomById(id)
                .orElseThrow(() -> new IllegalArgumentException("Habitación no encontrada con ID: " + id));

        BedRoomType bedRoomType = addBedRoomType(bedRoom.getBedRoomType().getIdType());
        
        existing.setRoom(bedRoom.getRoom());
        existing.setBedRoomType(bedRoomType);
        existing.setPrice(bedRoom.getPrice());
        existing.setState(bedRoom.getState());

        return bedRoomRepositoryPort.updateBedRoom(id, existing);
    }

    @Override
    public Optional<BedRoom> getBedRoomById(int id) {
        return bedRoomRepositoryPort.findBedRoomById(id);
    }

    @Override
    public List<BedRoom> getAllBedRooms() {
        return bedRoomRepositoryPort.findAllBedRooms();
    }

    @Override
    public void deleteBedRoomById(int id) {
        bedRoomRepositoryPort.deleteBedRoomById(id);
    }

    private BedRoomType addBedRoomType(int typeId) {
        return bedRoomTypeRepositoryPort.findBedRoomTypeById(typeId)
                .orElseThrow(() -> new IllegalArgumentException("No existe un tipo de habitación con ID: " + typeId));
    }
}
