package MX.TeosentliTeam.teosentli.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import MX.TeosentliTeam.teosentli.databinding.FragmentPoliticasBinding;

public class /*AQUI*/PoliticasFragment extends Fragment {

    /*AQUI*/
    private FragmentPoliticasBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        PoliticasViewModel politicasViewModel =
                new ViewModelProvider(this).get(/*AQUI*/PoliticasViewModel.class);

        /*AQUI*/
        binding = FragmentPoliticasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*AQUI*/
        //final TextView textView = binding.textPrueba;

        /*AQUI*/
        //politicasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}