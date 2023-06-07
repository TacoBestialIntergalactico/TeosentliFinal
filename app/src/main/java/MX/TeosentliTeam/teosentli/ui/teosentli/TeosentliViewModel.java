package MX.TeosentliTeam.teosentli.ui.teosentli;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeosentliViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TeosentliViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Teosentli");
    }

    public LiveData<String> getText() {
        return mText;
    }
}