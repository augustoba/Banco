package Repositories;
import Entities.Cliente;
import Entities.Sucursal;
import Service.BancoService;
import Service.ClienteService;
import Service.TransferenciaService;

import java.util.ArrayList;
import java.util.List;

public class PruebaService {

public static void main(String[]args){
    List<Sucursal> BancoList=new ArrayList<>();
    List<Cliente> clienteList=new ArrayList<>();

    BancoRepository objBancoRepository=new BancoRepository(BancoList);
    BancoService objBancoService=new BancoService(objBancoRepository);
    ClienteRepository objClienteRepository=new ClienteRepository(clienteList);
    ClienteService objClienteService=new ClienteService(objClienteRepository,objBancoRepository);
    TransferenciaService objTransferenciaService=new TransferenciaService(objClienteRepository);
    objBancoService.crearBanco();
    objBancoService.crearBanco();

    System.out.println(objBancoRepository.listaSucursales());
    objClienteService.crearCliente();
    objClienteService.crearCliente();


    System.out.println(objClienteRepository.mostrarClientes());
    objTransferenciaService.transferir();

    System.out.println(objClienteRepository.mostrarClientes());
}
}

  /*  ClienteService objClientService=new ClienteService();
    ClienteRepository objClienteRepository=new ClienteRepository(clienteList);*/