package application.service.outputs;

import application.domain.Guest;

import java.util.List;

public interface GuestAdminService {

    public List<Guest> getAllGuests();
    public void deleteGuest(int id);

}
