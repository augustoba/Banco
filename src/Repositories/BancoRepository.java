package Repositories;

import DataBase.BancoDB;
import Entities.Sucursal;

import java.util.List;

public class BancoRepository extends BancoDB {

    public BancoRepository(List<Sucursal> BancoList) {
        super(BancoList);
    }

    @Override
    public void agregarSucursal(Sucursal sucursal) {
        BancoList.add(sucursal);
    }

    @Override
    public List<Sucursal> listaSucursales() {
        return BancoList;
    }

    @Override
    public void modificarSucursal(Sucursal sucursal) {
        for (int i = 0; i < BancoList.size(); i++) {
            Sucursal bancoAux = BancoList.get(i);
            if (sucursal.getNumeroSuc()==(bancoAux.getNumeroSuc())) {
                BancoList.set(i, sucursal);
                break;
            }
        }
    }

    @Override
    public void eliminarSucursal(Sucursal sucursal) {
        for (int i = 0; i < BancoList.size(); i++) {
            Sucursal bancoAux = BancoList.get(i);
            if (bancoAux.getNumeroSuc() ==(sucursal.getNumeroSuc()) ) {
                BancoList.remove(i);
                break;
            }
        }

    }
}
