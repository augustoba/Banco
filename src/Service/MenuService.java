package Service;

import Entities.Cliente;
import Entities.Sucursal;
import Exceptions.Excepciones;
import Exceptions.NumeroNegativoException;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    private static Scanner objScanner = new Scanner(System.in);
    List<Sucursal> BancoList = new ArrayList<>();
    List<Cliente> clienteList = new ArrayList<>();
    BancoRepository objBancoRepository = new BancoRepository(BancoList);
    SucursalService objSucursalService = new SucursalService(objBancoRepository);
    ClienteRepository objClienteRepository = new ClienteRepository(clienteList);
    ClienteService objClienteService = new ClienteService(objClienteRepository, objBancoRepository);
    TransferenciaService objTransferenciaService = new TransferenciaService(objClienteRepository,objBancoRepository,objClienteService);
    Excepciones objExcepciones = new Excepciones();

    public void menu() {

        int opc = 0;
        opcMenu();


        do {
            System.out.println("Ingrese una opcion, ingrese 7 para volver a ver el menu.");

             opc = objExcepciones.validarInput();

            switch (opc) {

                case 1:

                    objSucursalService.crearSucursal();

                    break;
                case 2:
                    objClienteService.crearCliente();
                    break;
                case 3:
                    try {
                        objTransferenciaService.transferir();
                    } catch (NumeroNegativoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    objSucursalService.mostrarBancos();
                    break;
                case 5:
                    System.out.println("Ingrese el numero de cuenta.");
                    System.out.println(objClienteService.MostrarClienteCuenta(objScanner.nextLine()));

                    break;
                case 6:
                    objClienteService.MostrarTodosCliente();
                    break;
                case 7:
                    opcMenu();
                    break;
                case 8:
                    System.out.println("Cerrando programa.....");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta.");
            }
        } while (opc != 8);
    }

    public void opcMenu(){
        System.out.println("-----MENU-----");
        System.out.println("1- Crear sucursal.");
        System.out.println("2- Crear cliente.");
        System.out.println("3- Transferir.");
        System.out.println("4- Mostrar lista de bancos.");
        System.out.println("5- Buscar cliente por numero de cuenta.");
        System.out.println("6- Mostrar todos los clientes.");
        System.out.println("7- Volver a mostrar el menu..");
        System.out.println("8- Salir.");

    }

}
