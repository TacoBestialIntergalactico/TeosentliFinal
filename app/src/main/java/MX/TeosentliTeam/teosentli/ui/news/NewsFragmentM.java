package MX.TeosentliTeam.teosentli.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import MX.TeosentliTeam.teosentli.databinding.FragmentNewsBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsDronesBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsGroofBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsHydroBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsSustratoBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsVerticalBinding;

public class NewsFragmentM extends Fragment {

    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Recuperar los datos del contacto seleccionado
        Bundle bundle = getArguments();
        if (bundle != null) {
            String contactName = bundle.getString("contactName");
            // Cargar el layout correspondiente según el nombre del contacto
            if (contactName != null) {

                if (contactName.equals("Vertical")) {
                    FragmentNewsVerticalBinding verticalBinding = FragmentNewsVerticalBinding.inflate(inflater, container, false);
                    View verticalView = verticalBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando carlosBinding.elemento
                    return verticalView;
                } else if (contactName.equals("Drones")) {
                    FragmentNewsDronesBinding dronesBinding = FragmentNewsDronesBinding.inflate(inflater, container, false);
                    View dronesView = dronesBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return dronesView;
                }else if (contactName.equals("Groof")) {
                    FragmentNewsGroofBinding groofBinding = FragmentNewsGroofBinding.inflate(inflater, container, false);
                    View groofView = groofBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return groofView;
                }
                else if (contactName.equals("Hydro")) {
                    FragmentNewsHydroBinding hydroBinding = FragmentNewsHydroBinding.inflate(inflater, container, false);
                    View hydroView = hydroBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return hydroView;
                }
                else if (contactName.equals("Sustrato")) {
                    FragmentNewsSustratoBinding sustratoBinding = FragmentNewsSustratoBinding.inflate(inflater, container, false);
                    View sustratoView = sustratoBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return sustratoView;
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