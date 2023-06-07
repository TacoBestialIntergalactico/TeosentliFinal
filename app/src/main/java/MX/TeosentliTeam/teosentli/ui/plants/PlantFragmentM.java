package MX.TeosentliTeam.teosentli.ui.plants;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import MX.TeosentliTeam.teosentli.databinding.FragmentPlantAgaveBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantAvocadoBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantCarrotBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantWheatBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantsBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantPotatoeBinding;

public class PlantFragmentM extends Fragment {

    private FragmentPlantsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPlantsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Recuperar los datos del contacto seleccionado
        Bundle bundle = getArguments();
        if (bundle != null) {
            String contactName = bundle.getString("contactName");
            // Cargar el layout correspondiente según el nombre del contacto
            if (contactName != null) {

                if (contactName.equals("Potatoe")) {
                    FragmentPlantPotatoeBinding potatoeBinding = FragmentPlantPotatoeBinding.inflate(inflater, container, false);
                    View potatoeView = potatoeBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando carlosBinding.elemento
                    return potatoeView;
                } else if (contactName.equals("Carrot")) {
                    FragmentPlantCarrotBinding carrotBinding = FragmentPlantCarrotBinding.inflate(inflater, container, false);
                    View carrotView = carrotBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return carrotView;
                }else if (contactName.equals("Avocado")) {
                    FragmentPlantAvocadoBinding avocadoBinding = FragmentPlantAvocadoBinding.inflate(inflater, container, false);
                    View avocadoView = avocadoBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return avocadoView;
                }else if (contactName.equals("Wheat")) {
                    FragmentPlantWheatBinding wheatBinding = FragmentPlantWheatBinding.inflate(inflater, container, false);
                    View wheatView = wheatBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return wheatView;
                }else if (contactName.equals("Agave")) {
                    FragmentPlantAgaveBinding agaveBinding = FragmentPlantAgaveBinding.inflate(inflater, container, false);
                    View agaveView = agaveBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return agaveView;
                }
            }}
        // En caso de que el contacto seleccionado no sea Carlos ni Luis
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}