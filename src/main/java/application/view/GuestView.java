package application.view;

import application.domain.Guest;
import application.service.GuestServiceImpl;

public class GuestView {

    private final GuestServiceImpl guestService;
    private final Guest guest;

    public GuestView(GuestServiceImpl guestService, Guest guest) {
        this.guestService = guestService;
        this.guest = guest;
    }

    public void createGuest(){


        guestService.createGuest(guest);

    }





}
