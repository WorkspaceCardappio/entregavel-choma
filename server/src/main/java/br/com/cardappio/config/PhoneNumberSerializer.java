package br.com.cardappio.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class PhoneNumberSerializer extends JsonSerializer<String> {

    private final String PHONE_NUMBER_REGEX = "(\\d{2})(\\d{5})(\\d{4})";
    private final String PHONE_NUMBER_GROUPS = "($1) $2-$3";

    @Override
    public void serialize(String phoneNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeString(phoneNumber.replaceAll(PHONE_NUMBER_REGEX, PHONE_NUMBER_GROUPS));
    }
}
