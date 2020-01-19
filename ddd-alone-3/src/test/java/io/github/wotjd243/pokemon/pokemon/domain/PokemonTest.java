package io.github.wotjd243.pokemon.pokemon.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class PokemonTest {
    @Test
    void constructor() {
        // given
        // when
        // then
        new Pokemon(1, "이상해씨", 45);
    }

    @DisplayName("일정 포획률 이상일 때 포켓몬은 잡힌다.")
    @ParameterizedTest
    @ValueSource(ints = {50, 100, 150})
    void capturePokemon(final int captureRate) {
        // given
        final Pokemon 이상해씨 = new Pokemon(1, "이상해씨", 45);

        // when
        final boolean capture = 이상해씨.capture(captureRate);

        // then
        assertThat(capture).isTrue();
    }
}
