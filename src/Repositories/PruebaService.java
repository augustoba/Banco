package Repositories;
import Entities.Cliente;
import Entities.Sucursal;
import Service.BancoService;
import Service.ClienteService;

import java.util.ArrayList;
import java.util.List;

public class PruebaService {

public static void main(String[]args){
    List<Sucursal> BancoList=new ArrayList<>();
    List<Cliente> clienteList=new ArrayList<>();

    BancoRepository objBancoRepository=new BancoRepository(BancoList);
    BancoService objBancoService=new BancoService(objBancoRepository);

    objBancoService.crearBanco();
    objBancoService.crearBanco();

    System.out.println(objBancoRepository.listaSucursales());
    System.out.println(objBancoRepository.listaSucursales());

}
}

  /*  ClienteService objClientService=new ClienteService();
    ClienteRepository objClienteRepository=new ClienteRepository(clienteList);*/