package Service;

import Entities.Cliente;
import Entities.Transferencia;
import Exceptions.Excepciones;
import Exceptions.NumeroNegativoException;
import Exceptions.StringNumerico;
import Repositories.BancoRepository;
import Repositories.ClienteRepository;

import java.util.Scanner;

public class TransferenciaService {

    private ClienteRepository clienteRepo;
    private BancoRepository bancoRepo;
    private ClienteService clienteService;
    private Scanner objRead = new Scanner(System.in);
    private Excepciones objExcepciones = new Excepciones();

    public TransferenciaService() {
    }

    public TransferenciaService(ClienteRepository clienteRepo, BancoRepository bancoRepo, ClienteService clienteService) {
        this.clienteRepo = clienteRepo;
        this.bancoRepo = bancoRepo;
        this.clienteService = clienteService;
    }


    public void transferir() throws NumeroNegativoException {

        String cuentaNum1 = null;
        String cuentaNum2 = null;
        try {
            cuentaNum1 = objExcepciones.valNumString("el n° de su cuenta");
        } catch (StringNumerico e) {
            e.printStackTrace();
        }
        Cliente clienteOrigen = clienteService.MostrarClienteCuenta(cuentaNum1);
        if (clienteOrigen != null) {


            try {
                cuentaNum2 = objExcepciones.valNumString("el n° de cuenta de destino");
            } catch (StringNumerico e) {
                e.printStackTrace();
            }
            Cliente clienteDestino = clienteService.MostrarClienteCuenta(cuentaNum2);

            if (clienteOrigen != null && clienteDestino != null) {
                System.out.println("ingrese el monto a transferir");
                Double monto = objExcepciones.validarDouble();
                if (clienteOrigen.getCuenta().getSaldo() >= monto) {
                    if (clienteOrigen != clienteDestino) {

                        clienteOrigen.getCuenta().setSaldo((clienteOrigen.getCuenta().getSaldo() - monto));
                        clienteDestino.getCuenta().setSaldo((clienteDestino.getCuenta().getSaldo() + monto));
                        Transferencia objTransferencia = new Transferencia();
                        objTransferencia.setMonto(monto);
                        objTransferencia.setDetalle(detalleTransfEnv(monto, objTransferencia, clienteOrigen, clienteDestino));
                        clienteOrigen.getCuenta().getTransferencias().add(objTransferencia);
                        clienteDestino.getCuenta().getTransferencias().add(objTransferencia);
                        System.out.println("transferencia realizada con exito...");

                    } else {
                        System.out.println("no se puede transferir a la misma cuenta");
                    }
                } else {
                    System.out.println("su saldo no le permite realizar esta transferencia");
                }

            }
        }
    }

    public String detalleTransfEnv(Double monto, Transferencia transferencia, Cliente cliente, Cliente clienteDestino) {
        String detalle = "\n" +
                " ID Transferencia: " + transferencia.getIdTransferencia() + "\n"
                + "Fecha de transferencia: " + transferencia.getFechaTransferenc() + "\n"
                + " Nombre: " + cliente.getNombre() + "\n"
                + " Apellido: " + cliente.getApellido() + "\n"
                + " Cuenta de origen: " + cliente.getCuenta().getIdCuenta() + "\n"
                + "------------------------------------------------------------------------" + "\n"
                + " Nombre: " + clienteDestino.getNombre() + "\n"
                + " Apellido: " + clienteDestino.getApellido() + "\n"
                + " Cuenta de destino: " + clienteDestino.getCuenta().getIdCuenta() + "\n"
                + "------------------------------------------------------------------------" + "\n"
                + "Monto de transferencia: " + monto + "\n"
                + "------------------------------------------------------------------------" + "\n";

        return detalle;
    }


}
