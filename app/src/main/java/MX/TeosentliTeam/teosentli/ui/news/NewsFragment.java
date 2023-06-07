package MX.TeosentliTeam.teosentli.ui.news;

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
import MX.TeosentliTeam.teosentli.databinding.FragmentNewsBinding;
import MX.TeosentliTeam.teosentli.ui.messages.MessagesFragment;

public class NewsFragment extends Fragment {

    private FragmentNewsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NewsViewModel newsViewModel =
                new ViewModelProvider(this).get(NewsViewModel.class);

        binding = FragmentNewsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewsFragment("Hydro");
            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewsFragment("Groof");
            }
        });
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewsFragment("Sustrato");
            }
        });
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewsFragment("Vertical");
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewsFragment("Drones");
            }
        });
    }

    private void navigateToNewsFragment(String contactName) {
        Log.d("ContactName", contactName);
        Bundle bundle = new Bundle();
        bundle.putString("contactName", contactName);

        NavHostFragment.findNavController(NewsFragment.this)
                .navigate(R.id.action_nav_news_to_newsFragmentM, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}