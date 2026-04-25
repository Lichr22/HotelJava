package application.service.outputs;

import application.domain.Guest;
import java.util.List;
import java.util.Optional;

public interface GuestService {

    Guest createGuest(Guest guest);

    Guest updateGuest(int id, Guest guest);

    Optional<Guest> getGuestById(int id);

    List<Guest> getAllGuests();

    void deleteGuest(int id);

}
