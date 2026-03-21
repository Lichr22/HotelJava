package application.userinterface;

import application.view.GuestView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    private final GuestView guestView;
    public MenuApp(GuestView guestView) {
        this.guestView = guestView;
    }



    public void showMainMenu(){

        System.out.println("Bienvenido al Hotel Java");
        System.out.println("Presione 1 para iniciar la aplicacion");

        int init = sc.nextInt();
        sc.nextLine();
        while(init != 0){

            System.out.println("Seleccione 1. Registrar Usuario 2. Iniciar Sesion 3. Salir");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:
                    System.out.println("Registrar Usuario");
                    guestView.createGuest();
                    break;
                case 2:
                    System.out.println("Iniciar Sesion");
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida, por favor seleccione una opcion valida");
            }

        }
    }
}
