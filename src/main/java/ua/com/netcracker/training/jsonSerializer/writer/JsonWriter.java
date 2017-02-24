package ua.com.netcracker.training.jsonSerializer.writer;

import lombok.Data;
import lombok.NonNull;

import java.io.IOException;
import java.io.Writer;

/**
 * @author Roman Horilyi
 */
@Data
public class JsonWriter {

    @NonNull
    private Writer writer;

    public void writeObjectBegin() throws IOException {
        writer.write("{");
    }

    public void writeObjectEnd() throws IOException {
        writer.write("}");
    }

    public void writeArrayBegin() throws IOException {
        writer.write("[");
    }

    public void writeArrayEnd() throws IOException {
        writer.write("]");
    }

    public void writeString(String string) throws IOException {
        if (string != null) {
            writer.write("\"" + string + "\"");
        } else {
            writeNull();
        }
    }

    public void writeNumber(Number number) throws IOException {
        writer.write(String.valueOf(number));
    }

    public void writeSeparator() throws IOException {
        writer.write(",");
    }

    public void writePropertySeparator() throws IOException {
        writer.write(":");
    }

    public void writeBoolean(boolean booleanValue) throws IOException {
        writer.write(String.valueOf(booleanValue));
    }

    public void writeNull() throws IOException {
        writer.write("null");
    }

    public void flush() throws IOException {
        writer.flush();
    }
}
