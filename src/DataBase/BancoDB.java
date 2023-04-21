package DataBase;

import Entities.Sucursal;

import java.util.ArrayList;
import java.util.List;

public abstract class BancoDB {
    protected List<Sucursal>BancoList=new ArrayList<>();

    public BancoDB() {

    }

    public BancoDB(List<Sucursal> BancoList) {
        this.BancoList = BancoList;
    }

    public abstract void agregarSucursal(Sucursal sucursal);

    public abstract List<Sucursal> listaSucursales();

    public abstract void modificarSucursal(Sucursal sucursal);

    public abstract void eliminarSucursal(Sucursal sucursal);

    }





