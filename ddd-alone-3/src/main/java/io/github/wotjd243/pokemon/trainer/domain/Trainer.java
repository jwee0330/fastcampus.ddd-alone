package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    private String id;
    @Embedded
    private Level level;

    @ElementCollection
    private List<PokemonCaught> party = new ArrayList<>();

    protected Trainer() {
    }

    public Trainer(final String id) {
        this(id, Level.valueOf(1), new ArrayList<>());
    }

    public Trainer(String id, Level level, List<PokemonCaught> party) {
        this.id = id;
        this.level = level;
//        this.party = Collections.unmodifiableList(party);
        this.party = new ArrayList<>(party);
    }

    public Trainer add(PokemonCaught pokemon) {
        party.add(pokemon);
        return this;
    }

    public Level levelUp() {
        return level.levelUp();
    }
}
