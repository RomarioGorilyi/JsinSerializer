package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

/**
 * @author Roman Horilyi
 */
public class StringMapper extends JsonMapper<String> {

    public StringMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(String obj, JsonWriter jsonWriter) {

    }
}
