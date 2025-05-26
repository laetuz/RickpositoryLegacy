package id.neotica.rickpositorylegacy.fragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import id.neotica.rickpositorylegacy.data.CharacterRepositoryImpl;
import id.neotica.rickpositorylegacy.domain.CharactersModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainFragmentViewModel extends ViewModel {
    private final CharacterRepositoryImpl characterRepository;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    private final MutableLiveData<List<CharactersModel>> _charactersLiveData = new MutableLiveData<>();
    public LiveData<List<CharactersModel>> characters = _charactersLiveData;


    private final MutableLiveData<String> _error = new MutableLiveData<>();
    public LiveData<String> error = _error;

    @Inject
    public MainFragmentViewModel(CharacterRepositoryImpl characterRepository) {
        this.characterRepository = characterRepository;
        //load more initial data here
    }

    public void loadCharacters() {
        compositeDisposable.add(characterRepository.getCharacters()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> _charactersLiveData.setValue(response.getResults()),
                        throwable -> _error.setValue(throwable.getMessage())
                )
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear(); //prevent leaks, clearing disposables
    }
}
