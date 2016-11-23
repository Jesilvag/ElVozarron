package co.edu.uniquindio.android.electiva.elvozarron.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.elvozarron.R;
import co.edu.uniquindio.android.electiva.elvozarron.util.EntrenadorAdapter;
import co.edu.uniquindio.android.electiva.elvozarron.vo.Entrenador;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaDeEntrenadoresFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ListaDeEntrenadoresFragment extends Fragment implements EntrenadorAdapter.OnClickAdaptadorDeEntrenador{


    private EntrenadorAdapter adaptador;
    private RecyclerView listadoEntrenadores;
    private ArrayList<Entrenador> entrenadores;

    private OnFragmentInteractionListener mListener;

    private OnEntrenadorSeleccionadoListener listener;

    public ListaDeEntrenadoresFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listadoEntrenadores= (RecyclerView) getView().findViewById(R.id.listaEntrenadores);
        adaptador = new EntrenadorAdapter(entrenadores,this);
        listadoEntrenadores.setAdapter(adaptador);
        listadoEntrenadores.setLayoutManager( new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_entrenadores, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e)
            {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnEntrenadorSeleccionadoListener");
            }

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }



    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
    }


}
