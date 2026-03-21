package application;

import application.domain.BedRoom;
import application.domain.Guest;
import application.domain.Person;
import application.service.GuestServiceImpl;
import application.userinterface.MenuApp;
import application.view.GuestView;

public class Main {

    public static void main(String[] args) {

        Guest guest = new Guest();
        GuestServiceImpl guestService = new GuestServiceImpl();
        GuestView guestView = new GuestView(guestService, guest);
        MenuApp menuApp = new MenuApp(guestView);

        menuApp.showMainMenu();

    }
}
