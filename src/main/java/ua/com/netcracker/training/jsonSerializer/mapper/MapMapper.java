package ua.com.netcracker.training.jsonSerializer.mapper;

import ua.com.netcracker.training.jsonSerializer.serializer.JsonSerializer;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.util.Map;

/**
 * @author Roman Horilyi
 */
public class MapMapper extends JsonMapper<Map> {

    public MapMapper(JsonSerializer jsonSerializer) {
        super(jsonSerializer);
    }

    @Override
    public void write(Map obj, JsonWriter jsonWriter) {

    }
}
