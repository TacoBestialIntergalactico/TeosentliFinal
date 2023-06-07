package MX.TeosentliTeam.teosentli.ui.about;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class /*AQUI*/AboutViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public AboutViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de About");
    }

    public LiveData<String> getText() {
        return mText;
    }
}