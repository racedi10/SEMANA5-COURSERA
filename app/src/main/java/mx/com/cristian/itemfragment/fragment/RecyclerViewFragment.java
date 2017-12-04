package mx.com.cristian.itemfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.cristian.itemfragment.Presentador.IRecyclerViewFragmentPresenter;
import mx.com.cristian.itemfragment.Presentador.RecyclerViewFragmentPresenter;
import mx.com.cristian.itemfragment.R;
import mx.com.cristian.itemfragment.adapter.contactoAdaptador;
import mx.com.cristian.itemfragment.pojo.Contacto;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview,container, false);

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
        }

    /*
    public void iniciaizarListaContactos(){
        contactos= new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.phone_48,"Cristian Solis","5523078920","cristian.solis.esca@hotmail.com", likes));
        contactos.add(new Contacto(R.drawable.email_48,"Angeles Martinez","5528596456","angels2701@icloud.com", likes));
        contactos.add(new Contacto(R.drawable.email_48,"Silvia Escamilla","5515946276","silvia.escamilla@gmail.com", likes));
        contactos.add(new Contacto(R.drawable.peinadoma3,"Irving Solis","42097007","chiva_susa@hotmail.com", likes));

    }*/



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
    }

    @Override
    public contactoAdaptador CrearAdaptador(ArrayList<Contacto> contactos) {
       contactoAdaptador adaptador = new contactoAdaptador(contactos,getActivity());
        return  adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(contactoAdaptador adaptador) {
        listaContactos.setAdapter(adaptador);
    }
}
