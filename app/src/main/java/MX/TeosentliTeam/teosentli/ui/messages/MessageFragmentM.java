package MX.TeosentliTeam.teosentli.ui.messages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import MX.TeosentliTeam.teosentli.databinding.FragmentMessageCarlosBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessageEdgarBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessageLemuelBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessageLuisBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessageTorresBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessageVictorBinding;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessagesBinding;

public class /*AQUI*/MessageFragmentM extends Fragment {

    /*AQUI*/
    private FragmentMessagesBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMessagesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Recuperar los datos del contacto seleccionado
        Bundle bundle = getArguments();
        if (bundle != null) {
            String contactName = bundle.getString("contactName");
            // Cargar el layout correspondiente según el nombre del contacto
            if (contactName != null) {

                if (contactName.equals("Carlos")) {
                    FragmentMessageCarlosBinding carlosBinding = FragmentMessageCarlosBinding.inflate(inflater, container, false);
                    View carlosView = carlosBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando carlosBinding.elemento
                    return carlosView;
                } else if (contactName.equals("Luis")) {
                    FragmentMessageLuisBinding luisBinding = FragmentMessageLuisBinding.inflate(inflater, container, false);
                    View luisView = luisBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return luisView;
                }else if (contactName.equals("Edgar")) {
                FragmentMessageEdgarBinding edgarBinding = FragmentMessageEdgarBinding.inflate(inflater, container, false);
                View edgarView = edgarBinding.getRoot();
                // Configurar la vista según sea necesario
                // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                return edgarView;
            }else if (contactName.equals("Lemuel")) {
                    FragmentMessageLemuelBinding lemuelBinding = FragmentMessageLemuelBinding.inflate(inflater, container, false);
                    View lemuelView = lemuelBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return lemuelView;
                }else if (contactName.equals("Torres")) {
                    FragmentMessageTorresBinding torresBinding = FragmentMessageTorresBinding.inflate(inflater, container, false);
                    View torresView = torresBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return torresView;
                }else if (contactName.equals("Victor")) {
                    FragmentMessageVictorBinding victorBinding = FragmentMessageVictorBinding.inflate(inflater, container, false);
                    View victorView = victorBinding.getRoot();
                    // Configurar la vista según sea necesario
                    // Por ejemplo, puedes acceder a los elementos de la vista usando luisBinding.elemento
                    return victorView;
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