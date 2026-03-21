package application.service;

import application.domain.Guest;
import application.domain.Person;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    public Guest createGuest(Guest guest);

    public Guest updateGuest(Guest guest);



    public Optional<Guest> getGuestById(int id);





}
