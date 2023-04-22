package Service;


import Entities.Sucursal;
import Repositories.BancoRepository;

import java.util.Scanner;

public class SucursalService {

    private BancoRepository bancoRepo;

    public SucursalService() {
    }

    public SucursalService(BancoRepository bancoRepo) {
        this.bancoRepo = bancoRepo;
    }


    private Scanner objRead = new Scanner(System.in);

    BancoRepository objBancoRepository = bancoRepo;

    public Sucursal crearSucursal() {

        Sucursal objSucursal = new Sucursal();
        System.out.println("ingrese la direccion de la sucursal");
        objSucursal.setDireccion(objRead.nextLine());
        System.out.println("ingrese la provincia");
        objSucursal.setProvincia(objRead.nextLine());
        System.out.println("ingrese el pais");
        objSucursal.setPais(objRead.nextLine());
        System.out.println("ingrese el codigo postal");
        objSucursal.setCp(objRead.nextInt());
        objSucursal.setProvincia(objRead.nextLine());
        bancoRepo.agregarSucursal(objSucursal);
        return objSucursal;
    }

    public void mostrarBancos(){
        System.out.println(bancoRepo.listaSucursales());

    }

}
