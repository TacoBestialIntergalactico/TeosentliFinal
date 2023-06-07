package MX.TeosentliTeam.teosentli.ui.config;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import MX.TeosentliTeam.teosentli.databinding.FragmentClimaBinding;

public class /*AQUI*/ClimaFragment extends Fragment {

    /*AQUI*/
    private FragmentClimaBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        ClimaViewModel climaViewModel =
                new ViewModelProvider(this).get(/*AQUI*/ClimaViewModel.class);

        /*AQUI*/
        binding = FragmentClimaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*AQUI*/
       // final TextView textView = binding.textPrueba;

        /*AQUI*/
       // climaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}