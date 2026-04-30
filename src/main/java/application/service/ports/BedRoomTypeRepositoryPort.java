package application.service.ports;

import application.domain.BedRoomType;

import java.util.List;
import java.util.Optional;

public interface BedRoomTypeRepositoryPort {

    BedRoomType saveBedRoomType(BedRoomType bedRoomType);
    Optional<BedRoomType> findBedRoomTypeById(int id);
    List<BedRoomType> findAllBedRoomTypes();
    BedRoomType updateBedRoomType(int id, BedRoomType bedRoomType);
    void deleteBedRoomTypeById(int id);

}
