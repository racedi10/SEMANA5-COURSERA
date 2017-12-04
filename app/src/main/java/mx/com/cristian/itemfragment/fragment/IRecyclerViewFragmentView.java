package mx.com.cristian.itemfragment.fragment;

import java.util.ArrayList;

import mx.com.cristian.itemfragment.adapter.contactoAdaptador;
import mx.com.cristian.itemfragment.pojo.Contacto;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public contactoAdaptador CrearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(contactoAdaptador adaptador);


}
