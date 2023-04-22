package Service;


import Entities.Sucursal;
import Exceptions.Excepciones;
import Repositories.BancoRepository;

import java.util.Scanner;

public class SucursalService {

    private BancoRepository bancoRepo;
    Excepciones objExcepciones = new Excepciones();

    public SucursalService() {
    }

    public SucursalService(BancoRepository bancoRepo) {
        this.bancoRepo = bancoRepo;
    }


    private static final Scanner objRead = new Scanner(System.in);

    BancoRepository objBancoRepository = bancoRepo;

    public Sucursal crearSucursal() {

        Sucursal objSucursal = new Sucursal();

        System.out.println("ingrese la direccion de la sucursal");
        objSucursal.setDireccion(objRead.nextLine());
        System.out.println("ingrese la provincia");
        objSucursal.setProvincia(objRead.nextLine());
        /*System.out.println("ingrese el codigo postal");
        objSucursal.setCp(objExcepciones.validarInput());*/
        System.out.println("ingrese el pais");
        Scanner objScanner = new Scanner(System.in);
        String pais=objScanner.nextLine();
        objSucursal.setPais(pais);

        bancoRepo.agregarSucursal(objSucursal);
        return objSucursal;
    }

    public void mostrarBancos() {
        System.out.println(bancoRepo.listaSucursales());

    }

}
