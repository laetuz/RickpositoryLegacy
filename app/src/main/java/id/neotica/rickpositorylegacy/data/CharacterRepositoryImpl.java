package id.neotica.rickpositorylegacy.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.neotica.rickpositorylegacy.domain.CharacterApiResponse;
import io.reactivex.rxjava3.core.Single;

@Singleton
public class CharacterRepositoryImpl {
    private final ApiService apiService;

    @Inject
    public CharacterRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<CharacterApiResponse> getCharacters() {
        return apiService.getCharacters();
    }
}
