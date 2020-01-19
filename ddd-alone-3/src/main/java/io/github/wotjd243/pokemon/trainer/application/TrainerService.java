package io.github.wotjd243.pokemon.trainer.application;

import io.github.wotjd243.pokemon.trainer.domain.PokemonCaught;
import io.github.wotjd243.pokemon.trainer.domain.Trainer;
import io.github.wotjd243.pokemon.trainer.domain.TrainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(final TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Transactional
    public Trainer join(final String id) {
        return trainerRepository.save(new Trainer(id));
    }

    @Transactional(readOnly = true)
    public Trainer find(String id) {
        return trainerRepository.findById(id).get();
    }

    @Transactional
    public Trainer levelUp(String id) {
        Trainer foundTrainer = trainerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        foundTrainer.levelUp();
        return foundTrainer;
    }

    @Transactional
    public Trainer addPokemon(String trainerId, PokemonCaught pokemonCaught) {
        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow(IllegalArgumentException::new);
        return trainer.add(pokemonCaught);
    }
}
