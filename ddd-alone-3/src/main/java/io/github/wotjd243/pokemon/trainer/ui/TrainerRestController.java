package io.github.wotjd243.pokemon.trainer.ui;

import io.github.wotjd243.pokemon.trainer.application.TrainerService;
import io.github.wotjd243.pokemon.trainer.domain.PokemonCaught;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class TrainerRestController {
    private final TrainerService trainerService;

    public TrainerRestController(final TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/api/trainers/{id}")
    public ResponseEntity join(@PathVariable final String id) {
        return ResponseEntity.created(URI.create("/api/trainers"))
                .body(trainerService.join(id))
                ;
    }

    @PutMapping("/api/trainers/{id}/level-up")
    public ResponseEntity levelUp(@PathVariable final String id) {
        return ResponseEntity.ok()
                .body(trainerService.levelUp(id));
    }

    @PutMapping("/api/trainers/{id}/poke-caught")
    public ResponseEntity addPokemon(@PathVariable final String id, @RequestBody PokemonCaught pokemonCaught) {
        System.out.println(id);
        System.out.println(pokemonCaught.getName());
        System.out.println(pokemonCaught.getId());
        return ResponseEntity.ok()
                .body(trainerService.addPokemon(id, pokemonCaught))
                ;
    }
}
