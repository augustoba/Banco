package Service;

import Entities.Sucursal;
import Entities.Cuenta;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class CuentaService {

    private Scanner objScanner = new Scanner(System.in);
    private BancoRepository objBancoRepository=new BancoRepository();



    public Cuenta crearCuenta(List<Sucursal> sucursales) {
        Cuenta cuenta = new Cuenta();

        System.out.println("elija una sucursal");

        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println("sucursal : " + sucursales.get(i).getNumeroSuc()+
                    " Direccion: " + sucursales.get(i).getDireccion());
        }

        cuenta.setSucursal(objScanner.nextInt());

        System.out.println("que tipo de cuenta quiere crear");
        System.out.println("ingrese 1 para cuenta corriente 2 para caja de ahorros");
        int opc = objScanner.nextInt();
        switch (opc) {
            case 1:
                cuenta.setCajaAhorro(true);
                break;
            case 2:
                cuenta.setCuentaCorriente(true);
                break;
                default:
                    System.out.println("ingrese una opcion correcta");
        }
            cuenta.setSaldo(100000.5);
        return cuenta;
    }
}
