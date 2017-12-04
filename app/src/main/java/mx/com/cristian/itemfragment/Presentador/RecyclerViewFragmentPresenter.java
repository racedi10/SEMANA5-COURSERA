package mx.com.cristian.itemfragment.Presentador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mx.com.cristian.itemfragment.adapter.contactoAdaptador;
import mx.com.cristian.itemfragment.db.ConstructorContactos;
import mx.com.cristian.itemfragment.fragment.IRecyclerViewFragmentView;
import mx.com.cristian.itemfragment.pojo.Contacto;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;




    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerContatos();
    }

    @Override
    public void obtenerContatos() {
        constructorContactos= new ConstructorContactos(context);
        contactos = constructorContactos.obtenerContactos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.CrearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}

