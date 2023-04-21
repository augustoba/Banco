package DataBase;

import Entities.Cliente;

import java.util.ArrayList;
import java.util.List;

public abstract class ClienteDB {

    protected List<Cliente> clienteList;

    public ClienteDB() {
    }

    public ClienteDB(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public abstract void agregarCliente(Cliente cliente);

    public abstract List<Cliente> mostrarClientes();

    public abstract void modificarCliente(Cliente cliente);

    public abstract void eliminarCliente(Cliente cliente);

}
