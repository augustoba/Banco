package Service;


import Entities.Sucursal;
import Repositories.BancoRepository;

import java.util.Scanner;

public class BancoService {

    private BancoRepository bancoRepo;

    public BancoService() {
    }

    public BancoService(BancoRepository bancoRepo) {
        this.bancoRepo = bancoRepo;
    }


    private Scanner objRead = new Scanner(System.in);

    BancoRepository objBancoRepository = bancoRepo;

    public Sucursal  crearBanco() {

        Sucursal objBanco = new Sucursal();
        System.out.println("ingrese la direccion de sucursal");
        objBanco.setDireccion(objRead.nextLine());
        bancoRepo.agregarSucursal(objBanco);
        return objBanco;
    }

}
