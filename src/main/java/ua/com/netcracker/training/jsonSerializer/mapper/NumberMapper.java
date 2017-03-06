package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

/**
 * @author Roman Horilyi
 */
public class NumberMapper extends JsonMapper<Number> {

    public NumberMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(Number obj, JsonWriter jsonWriter) {

    }
}
