package MX.TeosentliTeam.teosentli.ui.config;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class /*AQUI*/ConfigViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public ConfigViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Configuracion");
    }

    public LiveData<String> getText() {
        return mText;
    }
}