package Service;


import Entities.Cliente;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;


import java.util.Scanner;

public class ClienteService {

    private ClienteRepository clienteRepo;
    private BancoRepository bancoRepo;
    public ClienteService() {
    }

    public ClienteService(ClienteRepository clienteRepo, BancoRepository bancoRepo) {
        this.clienteRepo = clienteRepo;
        this.bancoRepo = bancoRepo;
    }

    ClienteRepository objclienteRepository = clienteRepo;
    BancoRepository objbancoRep=bancoRepo;

    private Scanner objScanner = new Scanner(System.in);

    public Cliente crearCliente(){
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
        objCliente.setAlta(true);
        objCliente.setCuenta(objCuentaService.crearCuenta(bancoRepo.listaSucursales(),objCliente));
        clienteRepo.agregarCliente(objCliente);

        return objCliente;
    }
}
