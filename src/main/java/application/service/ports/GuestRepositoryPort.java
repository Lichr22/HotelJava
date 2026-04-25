package application.service.ports;

import application.domain.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestRepositoryPort {
    Guest saveGuest(Guest guest);
    List<Guest> findAllGuests();
    Optional<Guest> findGuestById(int id);
    void deleteGuestById(int id);
}
