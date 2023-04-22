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

    private static Scanner objScanner = new Scanner(System.in);

    public Cliente crearCliente(){
       CuentaService  objCuentaService = new CuentaService();

        Cliente objCliente = new Cliente();
        System.out.println("ingrese el nombre del cliente");
        objCliente.setNombre(objScanner.nextLine());
        System.out.println("ingrese el apellido");
        System.out.println("ingrese el dni");
        objCliente.setDni(objScanner.nextLine());
        objCliente.setApellido(objScanner.nextLine());
        System.out.println("ingrese la direccion");
        objCliente.setDireccion(objScanner.nextLine());
        objCliente.setAlta(true);
        objCliente.setCuenta(objCuentaService.crearCuenta(bancoRepo.listaSucursales(),objCliente));
        clienteRepo.agregarCliente(objCliente);

        return objCliente;
    }


    public void MostrarClienteCuenta(String num){
        Boolean encontrado=false;
        for (Cliente cliente: clienteRepo.mostrarClientes()){
            if (cliente.getCuenta().getIdCuenta().equalsIgnoreCase(num)){
                System.out.println(cliente);
                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("no se encontro el cliente");

        }

    }
    public void MostrarTodosCliente(){
        System.out.println(clienteRepo.mostrarClientes());

    }


}
