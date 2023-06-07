package MX.TeosentliTeam.teosentli.ui.teosentli;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentTeosentliBinding;
import MX.TeosentliTeam.teosentli.ui.messages.MessagesFragment;

public class TeosentliFragment extends Fragment {

    private FragmentTeosentliBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TeosentliViewModel teosentliViewModel =
                new ViewModelProvider(this).get(TeosentliViewModel.class);

        binding = FragmentTeosentliBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Avocado");
            }
        });
    }

    private void navigateToPlantsFragment(String contactName) {
        Log.d("ContactName", contactName);
        Bundle bundle = new Bundle();
        bundle.putString("contactName", contactName);

        NavHostFragment.findNavController(TeosentliFragment.this)
                .navigate(R.id.action_nav_teosentli_to_plantFragmentM, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}