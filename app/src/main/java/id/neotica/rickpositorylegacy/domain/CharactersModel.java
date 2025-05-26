package id.neotica.rickpositorylegacy.domain;

public class CharactersModel {
    private final int id;
    private final String name;
    private final String status;
    private final String species;
    private final String type;
    private final String gender;

    public CharactersModel(
            int id,
            String name,
            String status,
            String species,
            String type,
            String gender
    ) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }
}
