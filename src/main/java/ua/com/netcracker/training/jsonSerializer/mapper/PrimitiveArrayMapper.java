package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.lang.reflect.Array;

/**
 * @author Roman Horilyi
 */
public class PrimitiveArrayMapper extends JsonMapper<Array> {

    public PrimitiveArrayMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(Array obj, JsonWriter jsonWriter) {

    }
}
