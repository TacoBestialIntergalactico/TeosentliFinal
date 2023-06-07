package MX.TeosentliTeam.teosentli.ui.nature;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NatureViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NatureViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Nature");
    }

    public LiveData<String> getText() {
        return mText;
    }
}