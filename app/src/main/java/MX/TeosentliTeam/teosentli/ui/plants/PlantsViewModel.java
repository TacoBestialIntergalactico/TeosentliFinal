package MX.TeosentliTeam.teosentli.ui.plants;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlantsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PlantsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Texto de Plants");
    }

    public LiveData<String> getText() {
        return mText;
    }
}