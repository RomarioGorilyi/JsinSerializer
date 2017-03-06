package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

/**
 * @author Roman Horilyi
 */
public class BooleanMapper extends JsonMapper<Boolean> {

    public BooleanMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(Boolean obj, JsonWriter jsonWriter) {

    }
}
