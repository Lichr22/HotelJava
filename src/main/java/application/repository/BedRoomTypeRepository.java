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
    public BedRoomType saveBedRoomType(BedRoomType bedRoomType) {
        bedRoomTypes.add(bedRoomType);
        return bedRoomType;
    }

    @Override
    public Optional<BedRoomType> findBedRoomTypeById(int id) {
        return bedRoomTypes.stream()
                .filter(type -> type.getIdType() == id)
                .findFirst();
    }

    @Override
    public List<BedRoomType> findAllBedRoomTypes() {
        return bedRoomTypes;
    }

    @Override
    public BedRoomType updateBedRoomType(int id, BedRoomType bedRoomType) {
        for (int i = 0; i < bedRoomTypes.size(); i++) {
            if (bedRoomTypes.get(i).getIdType() == id) {
                bedRoomTypes.set(i, bedRoomType);
                return bedRoomType;
            }
        }
        throw new IllegalArgumentException("Tipo de habitación con ID " + id + " no encontrado");
    }

    @Override
    public void deleteBedRoomTypeById(int id) {
        boolean removed = bedRoomTypes.removeIf(type -> type.getIdType() == id);
        if (!removed) {
            throw new IllegalArgumentException("Tipo de habitación con ID " + id + " no encontrado");
        }
    }
}
