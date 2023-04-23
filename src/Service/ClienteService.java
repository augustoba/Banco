package Service;


import Entities.Cliente;
import Exceptions.CantCarcException;
import Exceptions.Excepciones;
import Exceptions.StringNumerico;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;


import java.util.Scanner;

public class ClienteService {

    private ClienteRepository clienteRepo;
    private BancoRepository bancoRepo;
    private Excepciones objExcepciones = new Excepciones();

    public ClienteService() {
    }

    public ClienteService(ClienteRepository clienteRepo, BancoRepository bancoRepo) {
        this.clienteRepo = clienteRepo;
        this.bancoRepo = bancoRepo;
    }

    ClienteRepository objclienteRepository = clienteRepo;
    BancoRepository objbancoRep = bancoRepo;

    private static Scanner objScanner = new Scanner(System.in);

    public Cliente crearCliente() {
        CuentaService objCuentaService = new CuentaService();

        Cliente objCliente = new Cliente();
        try {
            objCliente.setNombre(objExcepciones.cantCaracteres("el nombre"));
            objCliente.setApellido(objExcepciones.cantCaracteres("el apellido"));
            objCliente.setDireccion(objExcepciones.cantCaracteres("la direccion"));
            try {
                objCliente.setDni(objExcepciones.valNumString());
            } catch (StringNumerico e) {
                System.out.println(e.getMessage());
            }
        } catch (CantCarcException e) {
            System.out.println(e.getMessage());
        }
         objCliente.setAlta(true);
        objCliente.setCuenta(objCuentaService.crearCuenta(bancoRepo.listaSucursales(), objCliente));
        clienteRepo.agregarCliente(objCliente);

        return objCliente;
    }


    public Cliente MostrarClienteCuenta(String num) {
        Cliente cliente1 = new Cliente();
        Boolean encontrado = false;
        for (Cliente cliente : clienteRepo.mostrarClientes()) {
            if (cliente.getCuenta().getIdCuenta().equalsIgnoreCase(num)) {
                cliente1 = cliente;

                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("no se encontro el cliente");

        }

        return cliente1;
    }

    public void MostrarTodosCliente() {
        System.out.println(clienteRepo.mostrarClientes());

    }

    public static boolean comprobarNumero(String str) {
        return str.matches("\\d+");
    }

}
