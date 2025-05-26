package id.neotica.rickpositorylegacy.data;

import id.neotica.rickpositorylegacy.domain.CharactersModel;
import id.neotica.rickpositorylegacy.utils.Constants;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET(Constants.CHARACTER_PATH)
    Single<CharactersModel> getCharacters();
}
