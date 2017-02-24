package ua.com.netcracker.training.jsonSerializer.serializer;

import org.reflections.Reflections;
import ua.com.netcracker.training.jsonSerializer.mapper.*;
import ua.com.netcracker.training.jsonSerializer.writer.IndentedJsonWriter;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Horilyi
 */
public class JsonSerializer {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /**
     * Cache of the default {@link JsonMapper} subclasses.
     */
    private Map<Class, JsonMapper> mappersCache;

    /**
     * Flag that shows whether to make indention in a JSON serialized object.
     */
    private boolean indent;

    /**
     * Constructs {@code JsonSerializer} instance that will use indention or not
     * depending on the specialized {@code boolean indent}.
     *
     * @param indent if {@code indent} is {@code true}, an instance will use indention
     */
    public JsonSerializer(boolean indent) {
        mappersCache = new HashMap<>();
        initializeMappersCache();

        this.indent = indent;
    }

    /**
     * Initializes {@link #mappersCache} with default mappers.
     */
    private void initializeMappersCache() {
        mappersCache.put(Collection.class, new CollectionMapper());
        mappersCache.put(String.class, new StringMapper());
        mappersCache.put(Number.class, new NumberMapper());
        mappersCache.put(Map.class, new MapMapper());
        mappersCache.put(Boolean.class, new BooleanMapper());
        mappersCache.put(Object[].class, new ObjectArrayMapper());
    }

    public boolean isIndent() {
        return indent;
    }

    public void setIndent(boolean indent) {
        this.indent = indent;
    }

    public JsonMapper getMapper(Class clazz) {
        return mappersCache.get(clazz);
    }

    public void serialize(Object object) throws IllegalStateException {
        serialize(object, new StringWriter());
    }
    
    public void serialize(Object object, OutputStream stream) {
        serialize(object, stream, DEFAULT_CHARSET);
    }

    public void serialize(Object object, OutputStream stream, Charset charset) {
        serialize(object, new OutputStreamWriter(stream, charset));
    }

    public void serialize(Object object, Writer writer) {
        if (isIndent()) {
            // TODO find the indentSize of object to serialize and to pass it into IndentedJsonWriter() constructor
            //serialize(object, new IndentedJsonWriter(writer, ));
        } else {
            serialize(object, new JsonWriter(writer));
        }
    }


    protected void serialize(Object obj, JsonWriter jsonWriter) {
        // TODO call getMapper(), then a Mapper
        Class clazz = obj.getClass();
        try {
            jsonWriter.flush();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    // TODO debugging mode
    public static void main(String[] args) {
        JsonMapper<Collection> jsonMapper = new CollectionMapper();

        int[] numbers = new int[10];
        System.out.println(numbers.getClass().getSimpleName());
        System.out.println(numbers.getClass());
        System.out.println(numbers.getClass().getName());
        System.out.println();

        char[] chars = new char[10];
        System.out.println(chars.getClass().getSimpleName());
        System.out.println(chars.getClass());
        System.out.println(chars.getClass().getName());
        System.out.println();

        Integer[] integers = new Integer[10];
        System.out.println(integers.getClass().getSimpleName());
        System.out.println(integers.getClass());
        System.out.println(integers.getClass().getName());
        System.out.println();

        Object[] objects = new Object[10];
        System.out.println(objects.getClass().getSimpleName());
        System.out.println(objects.getClass());
        System.out.println(objects.getClass().getName());
        System.out.println();

        Number[] numbers1 = new Number[10];
        System.out.println(numbers1.getClass().getSimpleName());
        System.out.println(numbers1.getClass());
        System.out.println(numbers1.getClass().getName());
        System.out.println();

        System.out.println(numbers1.getClass().getSuperclass());
        System.out.println();

        Integer integer = 5;
        System.out.println(Arrays.toString(integer.getClass().getDeclaredFields()));
    }
}
