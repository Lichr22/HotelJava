package application.service;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;
import application.service.outputs.GuestAdminService;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {

    private final GuestRepositoryPort guestRepository;

    public GuestAdminServiceImpl(GuestRepositoryPort guestRepository) {
        this.guestRepository = guestRepository;
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
