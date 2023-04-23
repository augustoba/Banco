package Service;


import Entities.Cliente;
import Exceptions.CantCarcException;
import Exceptions.Excepciones;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;


import java.util.Scanner;

public class ClienteService {

    private ClienteRepository clienteRepo;
    private BancoRepository bancoRepo;
    private Excepciones objExcepciones=new Excepciones();
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
        try {
            objCliente.setNombre(objExcepciones.cantCaracteres("el nombre"));
            objCliente.setApellido(objExcepciones.cantCaracteres("el apellido"));
            objCliente.setDireccion(objExcepciones.cantCaracteres("la direccion"));
        } catch (CantCarcException e) {
            e.printStackTrace();
        }

        System.out.println("ingrese el dni");
        objCliente.setDni(objScanner.nextLine());
        objCliente.setAlta(true);
        objCliente.setCuenta(objCuentaService.crearCuenta(bancoRepo.listaSucursales(),objCliente));
        clienteRepo.agregarCliente(objCliente);

        return objCliente;
    }


    public Cliente MostrarClienteCuenta(String num){
        Cliente cliente1 = new Cliente();
        Boolean encontrado=false;
        for (Cliente cliente: clienteRepo.mostrarClientes()){
            if (cliente.getCuenta().getIdCuenta().equalsIgnoreCase(num)){
                cliente1=cliente;

                encontrado=true;
            }
        }
        if(!encontrado){
            System.out.println("no se encontro el cliente");

        }

        return cliente1;
    }

    public void MostrarTodosCliente(){
        System.out.println(clienteRepo.mostrarClientes());

    }


}
