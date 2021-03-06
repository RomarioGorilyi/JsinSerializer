package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

/**
 * @author Roman Horilyi
 */
public abstract class JsonMapper<T> {

    private JsonSerializer jsonSerializer;

    public JsonMapper(JsonSerializer jsonSerializer) {
        this.jsonSerializer = jsonSerializer;
    }

    public abstract void write(T obj, JsonWriter jsonWriter);
}
