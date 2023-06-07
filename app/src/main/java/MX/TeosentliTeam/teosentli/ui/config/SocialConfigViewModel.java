package MX.TeosentliTeam.teosentli.ui.config;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class /*AQUI*/SocialConfigViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public SocialConfigViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Prueba");
    }

    public LiveData<String> getText() {
        return mText;
    }
}