package id.neotica.rickpositorylegacy.domain;

import java.util.List;

public class CharacterApiResponse {
    private final InfoModel info;
    private final List<CharactersModel> results; // List of Character objects

    public CharacterApiResponse(InfoModel info, List<CharactersModel> results) {
        this.info = info;
        this.results = results;
    }

    public InfoModel getInfo() { return info; }
    public List<CharactersModel> getResults() { return results; }

}