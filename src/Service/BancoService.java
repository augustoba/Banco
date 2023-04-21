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







   /* public void transferir() {

        System.out.println("ingrese su numero de cuenta");

        String dni = objRead.nextLine();

        Double monto;

        for (Cliente cliente : clienteList) {


            if (cliente.getDni().equals(dni)) {
                System.out.println("ingrese el monto a transferir");
                monto = objRead.nextDouble();

                if (cliente.getCuenta().getSaldo() >= monto) {

                  cliente.getCuenta().setSaldo(cliente.getCuenta().getSaldo() - monto);

                } else {
                    System.out.println("no posee el saldo suficiente para realizar la transferencia");
                }

            }else{
                System.out.println("la cuenta no existe");
            }


        }


    }
*/

}
