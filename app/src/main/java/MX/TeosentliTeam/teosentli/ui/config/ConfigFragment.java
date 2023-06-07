package MX.TeosentliTeam.teosentli.ui.config;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentConfigBinding;

public class /*AQUI*/ConfigFragment extends Fragment {

    /*AQUI*/
    private FragmentConfigBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        ConfigViewModel configViewModel =
                new ViewModelProvider(this).get(/*AQUI*/ConfigViewModel.class);

        /*AQUI*/
        binding = FragmentConfigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*AQUI*/
       // final TextView textView = binding.textoConfig;

        /*AQUI*/
        //configViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_sistemConfigFragment2);
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_climaFragment);
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_teoFragment);
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_socialConfigFragment);
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_privacidadFragment);
            }
        });
        binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ConfigFragment.this)
                        .navigate(R.id.action_nav_configuration_to_ayudaFragment);
            }
        });
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}