package application.service;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.ports.GuestRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepositoryPort guestRepository;

    public GuestServiceImpl(GuestRepositoryPort guestRepository) {
        this.guestRepository = guestRepository;
    }

    @Override
    public Guest createGuest(Guest guest) {
        if (guestRepository.findGuestById(guest.getId()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un huésped con ID: " + guest.getId());
        }
        return guestRepository.saveGuest(guest);
    }

    @Override
    public Guest updateGuest(int id, Guest guest) {
        guestRepository.findGuestById(id)
                .orElseThrow(() -> new IllegalArgumentException("Huésped no encontrado con ID: " + id));
        
        return guestRepository.saveGuest(guest);
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return guestRepository.findGuestById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAllGuests();
    }

    @Override
    public void deleteGuest(int id) {
        guestRepository.deleteGuestById(id);
    }
}
