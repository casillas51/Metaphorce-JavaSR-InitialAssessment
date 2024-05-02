package mx.metaphorce.boosters.sr.InitialAssessment.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mx.metaphorce.boosters.sr.InitialAssessment.configuration.TestBase;
import mx.metaphorce.boosters.sr.InitialAssessment.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

public class UsuarioControllerTest extends TestBase {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(WebApplicationContext applicationContext) {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UsuarioControllerTest()).build();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void getAllUsersTest() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/usuario")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getUserByIdTest() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/usuario/10")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void getUserByIdTest_whenUserNotExist() throws Exception {
        MvcResult result = this.mockMvc.perform(get("/usuario/100")).andReturn();
        assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    void createUserTest() throws Exception {
        Usuario usuario = new Usuario(null, "UsuarioController",
                "123456", "USER");

        MvcResult result = this.mockMvc.perform(post("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void updateUserTest() throws Exception {
        Usuario usuario = new Usuario(20L, "UsuarioModificarController",
                "123456", "USER");

        MvcResult result = this.mockMvc.perform(put("/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(usuario)))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void updateUserTest_whenUserNotExist() throws Exception {
        Usuario usuario = new Usuario(100L, "UsuarioModificarController",
                "123456", "USER");

        MvcResult result = this.mockMvc.perform(put("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andReturn();

        assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    void deleteUserTest() throws Exception {
        MvcResult result = this.mockMvc.perform(delete("/usuario/20")).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}