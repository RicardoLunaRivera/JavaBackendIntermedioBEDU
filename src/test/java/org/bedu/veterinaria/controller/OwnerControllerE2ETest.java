package org.bedu.veterinaria.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
class OwnerControllerE2ETest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /owners sould return an empty list")
        // Realiza una petición de tipo GET a la ruta /owners y espera que la respuesta sea un código de estado 200 (OK).
    void emptyList() throws Exception {
        MvcResult result = mockMvc.perform(get("/owners")).andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        assertEquals("[]", content);
    }

    @Test
    @DisplayName("POST /owners should return an error if some data is missing")
        // Realiza un POST a la ruta /owners con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
    void dataMissingInRequestBodyTest() throws Exception {
        MvcResult result = mockMvc.perform(post("/owners").contentType("application/json").content("{\"name\":\"Ricardo\",\"lastname\":\"Luna\", \"address\": \"avenida siempre viva\", \"phone\": \"1234567890\"}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"must not be null\",\"Debe proporcionar un email\"]}";
        JSONAssert.assertEquals(expectedResponse, content,false);
    }

    @Test
    @DisplayName("PUT /owners/id should return an error if some data is missing to update owner")
    void dataMisssingInPutRequestBodyTest() throws Exception {
        //Realiza un PUT a la ruta /owners/{id} con un cuerpo JSON que contiene datos faltantes y espera que la respuesta sea un código de estado 400 (Bad Request).
        MvcResult result = mockMvc.perform(put("/owners/{idOwner}", 1L).contentType("application/json").content("{\"idOwner\": \"1\",\"name\":\"Ricardo\",\"lastname\":\"Luna\", \"address\": \"avenida siempre viva\", \"phone\": \"1234567890\"}"))
                .andExpect(status().isBadRequest()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_VALID\",\"message\":\"Los datos de entrada contiene errores\",\"details\":[\"must not be null\"]}";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("DELETE /owners/id should return an error if owner id is not found")
    void idMissingInRequestBodyTest() throws Exception {
        //Realiza un DELETE a la ruta /owners/{id} con un cuerpo JSON que contiene datos, sino encuentra el id del owner manda un notFound (404)
        MvcResult result = mockMvc.perform(delete("/owners/{idOwner}", 1L).contentType("application/json").content("{\"idOwner\": \"1\"}"))
                .andExpect(status().isNotFound()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "";
        assertEquals(expectedResponse, content);
    }

    @Test
    @DisplayName("DELETE /owners/id should return Ok if owner is delete")
    void deleteIsOk() throws Exception {
        MvcResult result = mockMvc.perform(delete("/owners/{idOwner}", "1L").contentType("application/json").content("{\"idOwner\": \"1L\",\"name\":\"Ricardo\",\"lastname\":\"Luna\", \"address\": \"avenida siempre viva\", \"phone\": \"1234567890\", \"email\":\"ricardo@mail.com\"}"))
                .andExpect(status().isOk()).andReturn();

        String content = result.getResponse().getContentAsString();
        String expectedResponse = "{\"code\":\"ERR_UNKNOWN\",\"message\":\"OcurriÃ³ un error inesperado ...\",\"details\":null}";
        assertEquals(expectedResponse, content);
    }

}
