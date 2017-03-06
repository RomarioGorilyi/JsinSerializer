package ua.com.netcracker.training.jsonSerializer.serializer;

import ua.com.netcracker.training.jsonSerializer.mapper.*;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.io.*;
import java.nio.charset.Charset;
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
        mappersCache.put(Collection.class, new CollectionMapper(this));
        mappersCache.put(String.class, new StringMapper(this));
        mappersCache.put(Character.class, new StringMapper(this));
        mappersCache.put(Number.class, new NumberMapper(this));
        mappersCache.put(Map.class, new MapMapper(this));
        mappersCache.put(Boolean.class, new BooleanMapper(this));
        mappersCache.put(Object[].class, new ObjectArrayMapper(this));
    }

    public boolean isIndent() {
        return indent;
    }

    public void setIndent(boolean indent) {
        this.indent = indent;
    }

    /**
     *
     * @param clazz
     * @return
     */
    public JsonMapper getMapper(Class clazz) {
        if (mappersCache.containsKey(clazz)) {
            return mappersCache.get(clazz);

        } else if (mappersCache.containsKey(clazz.getSuperclass())) {
            return mappersCache.get(clazz.getSuperclass());

        } else if (Map.class.isAssignableFrom(clazz)) {
            return mappersCache.get(Map.class); // TODO or simply return new MapMapper(); ?

        } else if (Collection.class.isAssignableFrom(clazz)) {
            return mappersCache.get(Collection.class); // TODO the same situation as in the previous case

        } else if (clazz.isArray()) {
            if (clazz.getComponentType().isPrimitive()) {
                return new PrimitiveArrayMapper(this);
            } else {
                return new ObjectArrayMapper(this);
            }
        }

        return new PojoMapper(this);
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

    protected void serialize(Object object, JsonWriter jsonWriter) {
        JsonMapper jsonMapper = getMapper(object.getClass());
        jsonMapper.write(object, jsonWriter);
        try {
            jsonWriter.flush();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    // TODO debugging mode
    public static void main(String[] args) {
        JsonSerializer jsonSerializer = new JsonSerializer(false);
        JsonMapper<Collection> jsonMapper = new CollectionMapper(jsonSerializer);

        int[] ints = new int[10];
        System.out.println(ints.getClass().getComponentType().isPrimitive());
        System.out.println(ints.getClass().isArray());


        /*int[] numbers = new int[10];
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
        */
    }
}
