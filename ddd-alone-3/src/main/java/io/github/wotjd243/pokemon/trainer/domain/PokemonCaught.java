package io.github.wotjd243.pokemon.trainer.domain;

import io.github.wotjd243.pokemon.pokemon.domain.Pokemon;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class PokemonCaught {
    private int id;
    private String name;

    public PokemonCaught() {
    }

    public PokemonCaught(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
