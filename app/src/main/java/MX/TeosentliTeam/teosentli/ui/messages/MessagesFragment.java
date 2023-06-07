package MX.TeosentliTeam.teosentli.ui.messages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentMessagesBinding;

public class /*AQUI*/MessagesFragment extends Fragment {

    /*AQUI*/
    private FragmentMessagesBinding binding;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        MessagesViewModel messagesViewModel =
                new ViewModelProvider(this).get(/*AQUI*/MessagesViewModel.class);

        /*AQUI*/
        binding = FragmentMessagesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*AQUI*/
        //final TextView textView = binding.messagesText;

        /*AQUI*/
        //messagesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMessageFragment("Lemuel");
            }
        });
         binding.button2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 navigateToMessageFragment("Torres");
             }
         });
         binding.button3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                navigateToMessageFragment("Carlos");
             }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMessageFragment("Victor");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMessageFragment("Edgar");
            }
        });         binding.button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMessageFragment("Luis");
            }
        });
    }

    private void navigateToMessageFragment(String contactName) {
        Log.d("ContactName", contactName);
        Bundle bundle = new Bundle();
        bundle.putString("contactName", contactName);

        NavHostFragment.findNavController(MessagesFragment.this)
                .navigate(R.id.action_nav_messagges_to_messageFragmentM, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}