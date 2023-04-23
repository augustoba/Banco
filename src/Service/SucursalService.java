package Service;


import Entities.Sucursal;
import Exceptions.CantCarcException;
import Exceptions.Excepciones;
import Exceptions.NumeroNegativoException;
import Repositories.BancoRepository;

import java.util.Scanner;

public class SucursalService {

    private BancoRepository bancoRepo;
    Excepciones objExcepciones = new Excepciones();
    BancoRepository objBancoRepository = bancoRepo;

    public SucursalService() {
    }

    public SucursalService(BancoRepository bancoRepo) {
        this.bancoRepo = bancoRepo;
    }


    private static final Scanner objRead = new Scanner(System.in);



    public Sucursal crearSucursal() {

        Sucursal objSucursal = new Sucursal();

      //  System.out.println("Ingrese la direccion de la sucursal.");
        try {
            objSucursal.setDireccion(objExcepciones.cantCaracteres("la direccion de la sucursal"));
            objSucursal.setProvincia(objExcepciones.cantCaracteres("la provincia"));
            objSucursal.setPais(objExcepciones.cantCaracteres("el pais"));
        } catch (CantCarcException e) {
            e.printStackTrace();
        }
        System.out.println("Ingrese el codigo postal.");
        objSucursal.setCp(objExcepciones.validarInput());
        bancoRepo.agregarSucursal(objSucursal);
        return objSucursal;
    }

    public void mostrarBancos() {
        if (bancoRepo.listaSucursales().size() > 0) {
        System.out.println(bancoRepo.listaSucursales());

    }else{
            System.out.println("No hay sucursales cargadas");
    }

}
}