package TestData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;

public class TestDataProvider {
    public static <T> T getTestData(String jsonPath, Class<T> valueType) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(jsonPath);
        return objectMapper.readValue(jsonPath, valueType);
    }
    public static <T> T getTestData2(String jsonPath, Class<T> valueType) throws JsonProcessingException {
        File file = new File(jsonPath);
        return new Gson().fromJson(jsonPath, valueType);
    }
}
