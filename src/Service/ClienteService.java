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


    public Cliente crearCliente() {
        CuentaService objCuentaService = new CuentaService();

        Cliente objCliente = new Cliente();

        try {

            objCliente.setNombre(objExcepciones.valLetrasString("el nombre"));
            objCliente.setApellido(objExcepciones.valLetrasString("el apellido"));
            objCliente.setDireccion(objExcepciones.valLetrasString("la direccion"));
        } catch (StringNumerico e) {
            System.out.println(e.getMessage());
        }

        try {
            objCliente.setDni(objExcepciones.valNumString("el DNI"));
        } catch (StringNumerico e) {
            e.printStackTrace();
        }
        objCliente.setAlta(true);
        objCliente.setCuenta(objCuentaService.crearCuenta(bancoRepo.listaSucursales(), objCliente));
        clienteRepo.agregarCliente(objCliente);



        return objCliente;
    }


    public Cliente MostrarClienteCuenta(String num) {


        for (Cliente cliente : clienteRepo.mostrarClientes()) {
            if (cliente.getCuenta().getIdCuenta().equalsIgnoreCase(num)) {



                return cliente;
            }
        }

        System.out.println("no se encontro el cliente");
        return null;
    }

    public void MostrarTodosCliente() {

        if (clienteRepo.mostrarClientes().size()>0){
        System.out.println(clienteRepo.mostrarClientes());

    }else{
            System.out.println("no hay clientes cargados");

        }


    }

    }
