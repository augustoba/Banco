package Service;

import Entities.Cliente;
import Entities.Sucursal;
import Entities.Cuenta;
import Exceptions.Excepciones;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CuentaService {

    private static Scanner objScanner = new Scanner(System.in);
    private Excepciones objExcepciones = new Excepciones();



    public Cuenta crearCuenta(List<Sucursal> sucursales,Cliente cliente) {
        Cuenta cuenta = new Cuenta();


        for (int i = 0; i < sucursales.size(); i++) {
            System.out.println("sucursal : " + sucursales.get(i).getNumeroSuc()+
                    " Direccion: " + sucursales.get(i).getDireccion());
        }


        Boolean check=false;
        int suc;
        do {
            System.out.println("Elija una sucursal.");
             suc = objExcepciones.validarInput();
            if (suc > sucursales.size()) {
                System.out.println("la sucursal no existe.");

            } else {
                cuenta.setSucursal(suc);
                cuenta.setIdCuenta(suc + cliente.getDni());
                check=true;
            }
        }while (!check);

        System.out.println("Que tipo de cuenta quiere crear.");

        Boolean flag=false;
        do {
            System.out.println("Ingrese 1 para cuenta corriente, 2 para caja de ahorros.");
            int opc = objExcepciones.validarInput();

        switch (opc) {
            case 1:
                cuenta.setCajaAhorro(true);
                cuenta.setFechaAlta(LocalDate.now());
                cuenta.setSaldo(100000.5);
                flag=true;
                break;
            case 2:
                cuenta.setCuentaCorriente(true);
                cuenta.setFechaAlta(LocalDate.now());
                cuenta.setSaldo(100000.5);
                flag=true;
                break;
                default:
                    System.out.println("Ingrese una opcion correcta.");
        }

        }while (!flag);
        return cuenta;
    }

 }
