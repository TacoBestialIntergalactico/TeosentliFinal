package MX.TeosentliTeam.teosentli.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentAboutBinding;

public class /*AQUI*/AboutFragment extends Fragment {

    /*AQUI*/
    private FragmentAboutBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        AboutViewModel aboutViewModel =
                new ViewModelProvider(this).get(/*AQUI*/AboutViewModel.class);

        /*AQUI*/
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*AQUI*/
       // final TextView textView = binding.textoAbout;

        /*AQUI*/
        //aboutViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(AboutFragment.this)
                        .navigate(R.id.action_nav_about_to_politicasFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}