package application.configuration;

import application.repository.BedRoomRepository;
import application.repository.BedRoomTypeRepository;
import application.repository.EmployeeRepository;
import application.repository.GuestRepository;
import application.service.BedRoomServiceImpl;
import application.service.EmployeeServiceImpl;
import application.service.GuestServiceImpl;
import application.service.outputs.BedRoomService;
import application.service.outputs.EmployeeService;
import application.service.outputs.GuestService;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.EmployeeRepositoryPort;
import application.service.ports.GuestRepositoryPort;
import application.userinterface.MenuApp;
import application.view.BedRoomView;
import application.view.EmployeeView;
import application.view.GuestView;

public class Config {

    public static MenuApp createMenuApp(){

        GuestRepositoryPort guestRepository = new GuestRepository();
        GuestService guestService = new GuestServiceImpl(guestRepository);
        GuestView guestView = new GuestView(guestService);

        BedRoomTypeRepository bedRoomTypeRepository = new BedRoomTypeRepository();
        BedRoomRepositoryPort bedRoomRepositoryPort = new BedRoomRepository();
        BedRoomService bedRoomService = new BedRoomServiceImpl(bedRoomRepositoryPort, bedRoomTypeRepository);
        BedRoomView bedRoomView = new BedRoomView(bedRoomService);

        EmployeeRepositoryPort employeeRepository = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepository);
        EmployeeView employeeView = new EmployeeView(employeeService);

        return new MenuApp(guestView, bedRoomView, employeeView);
    }
}
