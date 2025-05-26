package id.neotica.rickpositorylegacy.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.neotica.rickpositorylegacy.domain.CharactersModel;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class CharacterRepositoryImpl {
    private final ApiService apiService;

    @Inject
    public CharacterRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<CharactersModel> getCharacters() {
        return apiService.getCharacters();
    }
}
