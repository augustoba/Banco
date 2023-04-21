package Service;
import Entities.Cliente;
import Entities.Sucursal;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuService {

public  void menu(){
    List<Sucursal> BancoList=new ArrayList<>();
    List<Cliente> clienteList=new ArrayList<>();

    BancoRepository objBancoRepository=new BancoRepository(BancoList);
    SucursalService objSucursalService =new SucursalService(objBancoRepository);
    ClienteRepository objClienteRepository=new ClienteRepository(clienteList);
    ClienteService objClienteService=new ClienteService(objClienteRepository,objBancoRepository);
    TransferenciaService objTransferenciaService=new TransferenciaService(objClienteRepository);



    objSucursalService.crearSucursal();
    objSucursalService.crearSucursal();

    System.out.println(objBancoRepository.listaSucursales());
    objClienteService.crearCliente();
    objClienteService.crearCliente();


    System.out.println(objClienteRepository.mostrarClientes());
    objTransferenciaService.transferir();

    System.out.println(objClienteRepository.mostrarClientes());
}
}
