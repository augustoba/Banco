package Service;

import Entities.Cliente;
import Entities.Sucursal;
import Entities.Cuenta;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CuentaService {

    private static Scanner objScanner = new Scanner(System.in)
            


    public Cuenta crearCuenta(List<Sucursal> sucursales,Cliente cliente) {
        Cuenta cuenta = new Cuenta();


        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println("sucursal : " + sucursales.get(i).getNumeroSuc()+
                    " Direccion: " + sucursales.get(i).getDireccion());
        }


        Boolean check=false;
        int suc;
        do {
            System.out.println("elija una sucursal");
             suc = objScanner.nextInt();
            if (suc > sucursales.size()) {
                System.out.println("la sucursal no existe.");

            } else {
                cuenta.setSucursal(suc);
                cuenta.setIdCuenta(suc + cliente.getDni());
                check=true;
            }
        }while (!check);

        System.out.println("que tipo de cuenta quiere crear");

        Boolean flag=false;
        do {

            System.out.println("ingrese 1 para cuenta corriente, 2 para caja de ahorros.");
            int opc = objScanner.nextInt();
        switch (opc) {
            case 1:
                cuenta.setCajaAhorro(true);
                cuenta.setFechaAlta(LocalDate.now());
                flag=true;
                break;
            case 2:
                cuenta.setCuentaCorriente(true);
                cuenta.setFechaAlta(LocalDate.now());
                flag=true;
                break;
                default:
                    System.out.println("ingrese una opcion correcta");
        }
            cuenta.setSaldo(100000.5);
        }while (!flag);
        return cuenta;
    }

 }
