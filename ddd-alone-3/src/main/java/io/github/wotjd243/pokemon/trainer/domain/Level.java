package io.github.wotjd243.pokemon.trainer.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Level {
    private int level;

    protected Level() {
    }

    private Level(int level) {
        this.level = level;
    }

    public static Level valueOf(final int level) {
        return new Level(level);
    }

    public Level levelUp() {
        return new Level(level + 1);
    }
}
