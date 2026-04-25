package application.repository;

import application.domain.BedRoomType;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.BedRoomTypeRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class BedRoomTypeRepository implements BedRoomTypeRepositoryPort {


    private final List<BedRoomType> bedRoomTypes = new CopyOnWriteArrayList<>(List.of(
            new BedRoomType(1, "Sencilla"),
            new BedRoomType(2, "Doble"),
            new BedRoomType(3, "Suite"),
            new BedRoomType(4, "Grupal")
    ));

    @Override
    public BedRoomType saveBedRoomType() {
        return null;
    }

    @Override
    public Optional<BedRoomType> findBedRoomTypeById(int id) {
        return bedRoomTypes.stream()
                .filter(type -> type.getIdType() == id)
                .findFirst();
    }
}
