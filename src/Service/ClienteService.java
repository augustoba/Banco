package Service;

import Entities.Sucursal;
import Entities.Cliente;
import Repositories.ClienteRepository;

import java.util.List;
import java.util.Scanner;

public class ClienteService {

    ClienteRepository objclienteRepository = new ClienteRepository();
    private Scanner objScanner = new Scanner(System.in);

    public Cliente crearCliente(/*List<Sucursal> bancoList, List<Cliente> clienteList*/){
        CuentaService  objCuentaService = new CuentaService();

        Cliente objCliente = new Cliente();
        System.out.println("ingrese el nombre del cliente");
        objCliente.setNombre(objScanner.nextLine());
        System.out.println("ingrese el apellido");
        objCliente.setApellido(objScanner.nextLine());
        System.out.println("ingrese la direccion");
        objCliente.setDireccion(objScanner.nextLine());
        System.out.println("ingrese el dni");
        objCliente.setDni(objScanner.nextLine());
        objCliente.setCuenta(objCuentaService.crearCuenta());
        objclienteRepository.agregarCliente(objCliente);

       // objCliente.setCuenta(objCuentaService.crearCuenta(bancoList,objCliente));
      //  clienteList.add(objCliente);
        return objCliente;
    }
}
