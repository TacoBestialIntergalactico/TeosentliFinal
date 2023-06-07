package MX.TeosentliTeam.teosentli.ui.plants;

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
import MX.TeosentliTeam.teosentli.databinding.FragmentPlantsBinding;
import MX.TeosentliTeam.teosentli.ui.home.HomeFragment;
import MX.TeosentliTeam.teosentli.ui.messages.MessagesFragment;

public class PlantsFragment extends Fragment {

    private FragmentPlantsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlantsViewModel plantsViewModel =
                new ViewModelProvider(this).get(PlantsViewModel.class);

        binding = FragmentPlantsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Carrot");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Avocado");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Potatoe");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToPlantsFragment("Wheat");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
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

        NavHostFragment.findNavController(PlantsFragment.this)
                .navigate(R.id.action_nav_plants_to_plantFragmentM, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}