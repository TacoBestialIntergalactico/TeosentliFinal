package MX.TeosentliTeam.teosentli.ui.messages;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class /*AQUI*/MessagesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    //Chequen bien los nombres de las cosas, cambien Prueba por el nombre de su pantalla
    public MessagesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Mensajes");
    }

    public LiveData<String> getText() {
        return mText;
    }
}