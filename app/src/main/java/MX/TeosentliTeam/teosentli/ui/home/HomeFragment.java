package MX.TeosentliTeam.teosentli.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentHomeBinding;
import MX.TeosentliTeam.teosentli.ui.config.ConfigFragment;
import MX.TeosentliTeam.teosentli.ui.messages.MessagesFragment;
import MX.TeosentliTeam.teosentli.ui.teosentli.TeosentliFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_nav_home_to_nav_teosentli2);
            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Agave");
            }
        });
    }

    private void navigateToPlantsFragment(String contactName) {
        Log.d("ContactName", contactName);
        Bundle bundle = new Bundle();
        bundle.putString("contactName", contactName);

        NavHostFragment.findNavController(HomeFragment.this)
                .navigate(R.id.action_nav_home_to_plantFragmentM, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}