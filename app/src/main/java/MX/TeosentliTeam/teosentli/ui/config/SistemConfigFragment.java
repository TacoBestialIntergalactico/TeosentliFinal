package MX.TeosentliTeam.teosentli.ui.config;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.Prediction;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.Locale;

import MX.TeosentliTeam.teosentli.R;
import MX.TeosentliTeam.teosentli.databinding.FragmentSistemConfigBinding;

public class /*AQUI*/SistemConfigFragment extends Fragment {

    /*AQUI*/
    private FragmentSistemConfigBinding binding;

    private GestureLibrary libreria;
    Context context;
    Resources resources;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /*AQUI*/
        SistemConfigViewModel sistemConfigViewModel =
                new ViewModelProvider(this).get(/*AQUI*/SistemConfigViewModel.class);

        /*AQUI*/
        binding = FragmentSistemConfigBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        Spinner languageSpinner = binding.languageSpinner;
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.language_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Obtén el idioma seleccionado del Spinner
                String selectedLanguage = parent.getItemAtPosition(position).toString();

                // Cambia el idioma de la aplicación
                if (selectedLanguage.equals("English")) {
                    setAppLocale("en"); // Cambia el idioma a inglés
                } else {
                    setAppLocale("es"); // Cambia el idioma a español (idioma por defecto)
                }

                // Actualiza las vistas del fragmento para reflejar el cambio de idioma
                updateViews();

                // No es necesario reiniciar la actividad completa
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se hace nada si no se selecciona ningún idioma
            }
        });

        libreria = GestureLibraries.fromRawResource(getActivity(), R.raw.gestures);
        libreria.load();
        binding.panelGestos.addOnGesturePerformedListener(new GestureOverlayView.OnGesturePerformedListener() {
            @Override
            public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
                //Toast.makeText(MainActivity.this,"Gesto",Toast.LENGTH_SHORT);
                ArrayList<Prediction> predictions = libreria.recognize(gesture);
                if (predictions.size() > 0) {
                    //En este caso solos nos interesa el gesto que más se parezca
                    Prediction prediction = predictions.get(0);
                    //Miramos que tengo un parecido mínimo
                    //Si no supera el 1.5 de fiabilidad..
                    if (prediction.score > 1.5) {
                        //Decimos lo que ha escrito

                        switch (prediction.name){
                            case "Web":
                                busqueda();
                                //Toast.makeText(MainActivity.this, prediction.name,Toast.LENGTH_SHORT).show();
                                break;
                            case "F":
                                facebook();
                                //Toast.makeText(MainActivity.this, prediction.name,Toast.LENGTH_SHORT).show();
                                break;
                            case "Wa":
                                //Toast.makeText(MainActivity.this, prediction.name,Toast.LENGTH_SHORT).show();
                                watts();
                                break;
                            case "Phon":
                                // Toast.makeText(MainActivity.this, prediction.name,Toast.LENGTH_SHORT).show();
                                llamadaTel();
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + prediction.name);
                        }

                    }else {
                        // Toast.makeText(this, "No se ha reconocido.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return root;

    }

    public void llamadaTel() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" +""));
        startActivity(intent);
    }

    public void busqueda() {
        Uri webpage = Uri.parse("https://matias.ma/nsfw/");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);

    }
    public void facebook() {
        Uri uri = Uri.parse("https://www.facebook.com");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        Intent chooser = Intent.createChooser(intent,"Abrir Facebook");
        try {
            startActivity(chooser);
        } catch (ActivityNotFoundException e) {

        }
    }

    public void watts() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.setPackage("com.whatsapp");
        intent.putExtra(Intent.EXTRA_TEXT, "hola desde mi App.");
        try{
            startActivity(intent);
        }catch (ActivityNotFoundException ex){
            //  Toast.makeText(MainActivity.this, "La aplicación Whastapp no se encuentra instalada en el dispositivo.", Toast.LENGTH_SHORT).show();
        }
    }
    private void setAppLocale(String languageCode) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        Locale newLocale = new Locale(languageCode);
        configuration.setLocale(newLocale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    private void updateViews() {
        // Actualiza las vistas del fragmento según el idioma seleccionado
        // Por ejemplo, puedes actualizar los textos de los botones o etiquetas
        // con los recursos correspondientes en el nuevo idioma.
        // binding.textView.setText(R.string.some_text);
        // binding.button.setText(R.string.some_button_label);;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}