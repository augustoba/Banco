package Service;

import Entities.Cliente;
import Entities.Transferencia;
import Repositories.ClienteRepository;
import java.util.Scanner;

public class TransferenciaService {

    private ClienteRepository clienteRepo;

    public TransferenciaService(ClienteRepository clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    private Scanner objRead = new Scanner(System.in);


    public void transferir() {
        Double monto;

        Boolean clienteEnvia = false;

        Boolean clienteRecibe = false;

        for (Cliente cliente : clienteRepo.mostrarClientes()) {

            System.out.println("ingrese su numero de cuenta");
            String numCuenta = objRead.nextLine();

            if (cliente.getCuenta().getIdCuenta().equals(numCuenta)) {
                clienteEnvia = true;
                System.out.println("ingrese la cuenta a transferir");
                String numCuentaDestino = objRead.nextLine();

                for (Cliente clienteDestino : clienteRepo.mostrarClientes()) {

                    if (clienteDestino.getCuenta().getIdCuenta().equals(numCuentaDestino)) {
                        clienteRecibe = true;
                        System.out.println("ingrese el monto a transferir");
                        monto = objRead.nextDouble();
                        if (cliente.getCuenta().getSaldo() >= monto) {

                            clienteDestino.getCuenta().setSaldo(cliente.getCuenta().getSaldo() + monto);
                            System.out.println("saldo cuenta destino: " + clienteDestino.getCuenta().getSaldo());

                            cliente.getCuenta().setSaldo(cliente.getCuenta().getSaldo() - monto);
                            System.out.println("saldo cuenta origen: " + cliente.getCuenta().getSaldo());

                            Transferencia objTransferencia = new Transferencia();
                            objTransferencia.setMonto(monto);
                            objTransferencia.setDetalle(detalleTransfEnv(monto, objTransferencia, cliente, clienteDestino));
                            cliente.getCuenta().getTransferencias().add(objTransferencia);
                            clienteDestino.getCuenta().getTransferencias().add(objTransferencia);
                            System.out.println("transferencia realizada con exito...");
                        } else {
                            System.out.println("no posee el saldo suficiente para realizar la transferencia");
                        }

                    }
                }

            }

        }
        if (!clienteEnvia) {
            System.out.println("la cuenta de origen no existe");
        }
        if (!clienteRecibe) {
            System.out.println("la cuenta de destino no existe");
        }


    }


    public String detalleTransfEnv(Double monto, Transferencia transferencia, Cliente cliente, Cliente clienteDestino) {
        String detalle ="\n"+
                " ID Transferencia: " + transferencia.getIdTransferencia() + "\n"
                +"Fecha de transferencia: " + transferencia.getFechaTransferenc() + "\n"
                + " Nombre: " + cliente.getNombre() + "\n"
                + " Apellido: " + cliente.getApellido() + "\n"
                + " Cuenta de origen: " + cliente.getCuenta().getIdCuenta() + "\n"
                + "------------------------------------------------------------------------" + "\n"
                + " Nombre: " + clienteDestino.getNombre() + "\n"
                + " Apellido: " + clienteDestino.getApellido() + "\n"
                + " Cuenta de destino: " + clienteDestino.getCuenta().getIdCuenta() + "\n"
                + "------------------------------------------------------------------------"+"\n"
                + "Monto de transferencia: " + monto + "\n"
                + "------------------------------------------------------------------------"+"\n";

        return detalle;
    }

}
