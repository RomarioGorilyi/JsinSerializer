package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.util.Collection;

/**
 * @author Roman Horilyi
 */
public class CollectionMapper extends JsonMapper<Collection> {

    public CollectionMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(Collection obj, JsonWriter jsonWriter) {

    }
}
