package application.userinterface;

import application.util.FormValidationUtil;
import application.view.BedRoomView;
import application.view.EmployeeView;
import application.view.GuestView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    private final GuestView guestView;
    private final BedRoomView bedRoomView;
    private final EmployeeView employeeView;

    public MenuApp(GuestView guestView, BedRoomView bedRoomView, EmployeeView employeeView){
        this.guestView = guestView;
        this.bedRoomView = bedRoomView;
        this.employeeView = employeeView;
    }

    public void showMainMenu(){

        System.out.println("Bienvenido al Hotel Java");

        int init = FormValidationUtil.validateInt("Presione 1 para iniciar la aplicacion");
        sc.nextLine();
        while(init != 0){

            System.out.println("Seleccione 1. Huespedes 2. Habitaciones 3. Empleados 0. Salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    showGuestMenu();
                    break;
                case 2:
                    showBedRoomMenu();
                    break;
                case 3:
                    showEmployeeMenu();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }
    }

    public void showGuestMenu(){
        System.out.println("Menu Huespedes");
        boolean init = true;
        while(init){
            System.out.println("1. Crear 2. Listar 0. Volver");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1: guestView.createGuest(); break;
                case 2: guestView.getAllGuests(); break;
                case 0: init = false; break;
                default: System.out.println("Opcion no valida");
            }
        }
    }

    public void showBedRoomMenu(){
        System.out.println("Menu Habitaciones");
        boolean init = true;
        while(init){
            System.out.println("1. Crear 2. Actualizar 3. Eliminar 4. Listar 5. Buscar 0. Volver");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1: bedRoomView.createBedRoom(); break;
                case 2: bedRoomView.updateBedRoom(); break;
                case 3: bedRoomView.deleteBedRoomById(); break;
                case 4: bedRoomView.getAllBedRooms(); break;
                case 5: bedRoomView.getBedRoomById(); break;
                case 0: init = false; break;
                default: System.out.println("Opcion no valida");
            }
        }
    }

    public void showEmployeeMenu() {
        System.out.println("Menu Empleados");
        boolean init = true;
        while(init){
            System.out.println("1. Crear 2. Listar 0. Volver");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1: employeeView.createEmployee(); break;
                case 2: employeeView.showAllEmployees(); break;
                case 0: init = false; break;
                default: System.out.println("Opcion no valida");
            }
        }
    }
}
