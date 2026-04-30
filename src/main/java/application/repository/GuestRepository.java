package application.repository;

import application.domain.Guest;
import application.domain.enums.GuestType;
import application.service.ports.GuestRepositoryPort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

public class GuestRepository implements GuestRepositoryPort {

    private final List<Guest> guests = new CopyOnWriteArrayList<>(List.of(
            new Guest(1, "Maria", "Gomez", "mg@mail.com", "123456", true, "Medellín", GuestType.NUEVO),
            new Guest(2, "Juan", "Perez", "juan@mail.com", "12345678", true, "Bogotá", GuestType.FRECUENTE)
    ));

    @Override
    public Guest saveGuest(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public List<Guest> findAllGuests() {
        return guests;
    }

    @Override
    public Optional<Guest> findGuestById(int id) {
        return guests.stream()
                .filter(guest -> guest.getId() == id)
                .findFirst();
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == id) {
                guests.set(i, guest);
                return guest;
            }
        }
        throw new IllegalArgumentException("Huésped con ID " + id + " no encontrado");
    }

    @Override
    public void deleteGuestById(int id) {
        boolean removed = guests.removeIf(guest -> guest.getId() == id);
        if (!removed) {
            throw new IllegalArgumentException("Huésped con ID " + id + " no encontrado");
        }
    }
}
