package org.bedu.veterinaria.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PetControllerE2ETest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /pets sould return an empty list")
        // Realiza una petición de tipo GET a la ruta /pets y espera que la respuesta sea un código de estado 200 (OK).
    void getPetsTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/pets")).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("[]", content);
    }

    @Test
    @DisplayName("POST /pets should return an error if some data is missing")
        // Realiza un POST a la ruta /owners con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
    void postPetBadRequestTest() throws Exception {
        MvcResult result = mockMvc.perform(post("/pets").contentType("application/json").content("{" +
                        "\"name\":\"Bruce\"" +
                        ",\"species\":\"1\"" +
                        ",\"race\":\"Pug\"" +
                        ",\"ownerId\":\"1\"}" +
                        "}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"La fecha de nacimiento de la mascota no puede ir vacia.\",\"Debe indicar el ID del veterinario que atenderÃ¡ a la mascota.\"]}";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("PUT /pets/id should return an error if some data is missing to update pet")
    void dataMisssingInPutRequestBodyTest() throws Exception {
        //Realiza un PUT a la ruta /pet/{id} con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
        MvcResult result = mockMvc.perform(put("/pets/{idPet}", 1L).contentType("application/json").content("{" +
                        "\"name\":\"Bruce\"" +
                        ",\"species\":\"1\"" +
                        ",\"race\":\"Pug\"" +
                        ",\"ownerId\":\"1\"}" +
                        "}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Debe indicar el ID del veterinario que atenderÃ¡ a la mascota.\",\"La fecha de nacimiento de la mascota no puede ir vacia.\"]}";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("DELETE /pets/id should return an error if pet id is not found")
    void idMissingInRequestBodyTest() throws Exception {
        //Realiza un DELETE a la ruta /pets/{id} con un cuerpo JSON que contiene datos, sino encuentra el id del pet banda un notFounf (404)
        MvcResult result = mockMvc.perform(delete("/pets/{idPet}", 1L).contentType("application/json").content("{\"idPet\": \"1\"}"))
                .andExpect(status().isNotFound()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "";
        assertEquals(expectedResponse, content);
    }

}
