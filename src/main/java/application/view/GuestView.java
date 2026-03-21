package application.view;

import application.domain.Guest;
import application.service.GuestService;
import application.service.GuestServiceImpl;

public class GuestView {

    private final GuestService guestService;
    private final Guest guest;

    public GuestView(GuestService guestService, Guest guest) {
        this.guestService = guestService;
        this.guest = guest;
    }

    public void createGuest(){


        guestService.createGuest(guest);

    }





}
