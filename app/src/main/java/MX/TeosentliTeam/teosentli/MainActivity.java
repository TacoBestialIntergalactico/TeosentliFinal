package MX.TeosentliTeam.teosentli;

//Texto Checador del Github, P**o El Que Lo Lea

import android.gesture.GestureLibrary;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import MX.TeosentliTeam.teosentli.databinding.ActivityMainBinding;
import MX.TeosentliTeam.teosentli.ui.menu.ProfileFragment;
import MX.TeosentliTeam.teosentli.ui.menu.StoreFragment;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    private GestureLibrary gLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //Esto de aui es para añadir el menu de hamburguesa dentro del fragmento, chuequen bien eso, si no lo ponen va intercambiar el icono del menu por una flecha de retroceso
        //Aqui esta las acciones para que los lleve de un lugar a otro, necesitan poner el id del lugar
        //Este id se establece en res/navigation/mobile_navigation necesitan crear antes su fragmento para que les aparesca ahi
        //le dan click a su pantalla del fragmento y muevan el cable del nav_home hasta su fragmento
        //R.id.nav_fragmento ----> R.id.nav_news
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home
                //, R.id.nav_teosentli, R.id.nav_plants, R.id.nav_prueba, R.id.nav_nature, R.id.nav_news
                )
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem storeItem = menu.findItem(R.id.action_store);
        storeItem.setOnMenuItemClickListener(item -> {
            // Open the store fragment
            openStoreFragment();
            return true;
        });

        MenuItem profileItem = menu.findItem(R.id.action_profile);
        profileItem.setOnMenuItemClickListener(item -> {
            // Open the profile fragment
            openProfileFragment();
            return true;
        });

        return true;
    }

    private void openStoreFragment() {
        // Create an instance of the StoreFragment
        StoreFragment storeFragment = new StoreFragment();

        // Replace the current fragment with the StoreFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, storeFragment)
                .addToBackStack(null)
                .commit();
    }

    private void openProfileFragment() {
        // Create an instance of the ProfileFragment
        ProfileFragment profileFragment = new ProfileFragment();

        // Replace the current fragment with the ProfileFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.nav_host_fragment_content_main, profileFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}