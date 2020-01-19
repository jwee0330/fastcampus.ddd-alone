package io.github.wotjd243.pokemon.pokemon.ui;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 스프링 부트 테스트는 WebMvcTest는 웹 관련 컨피그레이션만 이니셜라이즈 된다.
 */
@SpringBootTest
@AutoConfigureMockMvc
class PokemonRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void find() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/pokemons/{number}", 120))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").isNumber())
                .andExpect(jsonPath("$.name").isString())
                .andExpect(jsonPath("$.captureRate").isNumber())
        ;
    }

}
