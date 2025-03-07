package br.com.cardappio.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CPFSerializer extends JsonSerializer<String> {

    private final String CPF_REGEX = "(\\d{3})(\\d{3})(\\d{3})(\\d{2})";
    private final String CPF_GROUPS = "$1.$2.$3-$4";

    @Override
    public void serialize(String cpf, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(cpf.replaceAll(CPF_REGEX, CPF_GROUPS));
    }
}
