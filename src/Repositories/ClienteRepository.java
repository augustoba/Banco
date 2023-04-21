package Repositories;

import DataBase.ClienteDB;
import Entities.Cliente;

import java.util.List;

public class ClienteRepository extends ClienteDB {

    public ClienteRepository(List<Cliente> clienteList) {
        super(clienteList);
    }

    public ClienteRepository() {
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        clienteList.add(cliente);
    }

    @Override
    public List<Cliente> mostrarClientes() {
        return clienteList;
    }

    @Override
    public void modificarCliente(Cliente cliente) {
        for (int i = 0; i < clienteList.size(); i++) {
            Cliente clienteaux = clienteList.get(i);
            if (cliente.getCuenta().getIdCuenta() .equals(clienteaux.getCuenta().getIdCuenta())  ) {
                clienteList.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
       for (int i = 0; i < clienteList.size(); i++) {
            Cliente clienteaux = clienteList.get(i);
            if (clienteaux.getDni() .equalsIgnoreCase(cliente.getDni()) ) {
                clienteList.remove(i);
                break;
            }
        }
    }
}
