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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class VeterinarianControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /veterinarians sould return an empty list")
        // Realiza una petición de tipo GET a la ruta /veterinarians y espera que la respuesta sea un código de estado 200 (OK).
    void getVeterinariansTest() throws Exception {
        MvcResult result = mockMvc.perform(get("/veterinarians")).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("[]", content);
    }
/*
    @Test
    @DisplayName("POST /veterinarians should return an error if some data is missing")
        // Realiza un POST a la ruta /veterinarians con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
    void postVeterinariansBadRequestTest() throws Exception {
        MvcResult result = mockMvc.perform(post("/veterinarians").contentType("application/json").content("{" +
                        "\"name\":\"Diana\",\"lastname\":\"Luna\",\"specialty\":\"Cardiologa\"}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Missing phone\"]}";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("PUT /veterinarians/id should return an error if some data is missing to update owner")
    void putVeterinariansBadRequestTest() throws Exception {
        //Realiza un PUT a la ruta /veterinarians/{id} con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
        MvcResult result = mockMvc.perform(put("/veterinarians/{idVeterinarian}", 1L).contentType("application/json").content("{" +
                        "\"name\":\"Diana\",\"lastname\":\"Luna\",\"specialty\":\"Cardiologa\"}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"Missing phone\"]}";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("DELETE /veterinarians/id should return an error if owner id is not found")
    void deleteVeterinarianTest() throws Exception {
        //Realiza un DELETE a la ruta /veterinarians/{id} con un cuerpo JSON que contiene datos, sino encuentra el id del owner manda un notFound (404)
        MvcResult result = mockMvc.perform(delete("/veterinarians/{idVeterinarian}", 1L).contentType("application/json").content("{\"idOwner\": \"1\"}"))
                .andExpect(status().isNotFound()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "Veterinarian Deleted";
        assertEquals(expectedResponse, content);
    }
*/
}
