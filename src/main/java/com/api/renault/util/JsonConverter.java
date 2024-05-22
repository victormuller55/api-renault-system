package com.api.renault.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {
      public static JsonNode convertToJson(String value) throws JsonProcessingException {
          ObjectMapper objectMapper = new ObjectMapper();
          try {
              return objectMapper.readTree(value);
          } catch (Exception e) {
              throw e;
          }
      }

}
