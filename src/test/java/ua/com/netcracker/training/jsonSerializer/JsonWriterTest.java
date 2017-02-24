package ua.com.netcracker.training.jsonSerializer;

import org.junit.Assert;
import org.junit.Test;
import ua.com.netcracker.training.jsonSerializer.writer.JsonWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Roman Horilyi
 */
public class JsonWriterTest {

    @Test(expected = NullPointerException.class)
    public void testConstructJsonWriterWithNullAsWriter() {
        JsonWriter jsonWriter = new JsonWriter(null);
    }

    @Test
    public void testWriteObjectBegin() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeObjectBegin();
            String expectedExpression = "{";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteObjectEnd() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeObjectEnd();
            String expectedExpression = "}";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteArrayBegin() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeArrayBegin();
            String expectedExpression = "[";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteArrayEnd() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeArrayEnd();
            String expectedExpression = "]";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteString() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            String stringToWrite = "Test string";
            jsonWriter.writeString(stringToWrite);
            String expectedExpression = "\"Test string\"";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteNullString() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeString(null);
            String expectedExpression = "null";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteNumber() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            int numberToWrite = 77;
            jsonWriter.writeNumber(numberToWrite);
            Assert.assertEquals(String.valueOf(numberToWrite), writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteSeparator() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeSeparator();
            String expectedExpression = ",";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWritePropertySeparator() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writePropertySeparator();
            String expectedExpression = ":";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteBoolean() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            boolean booleanToWrite = true;
            jsonWriter.writeBoolean(booleanToWrite);
            Assert.assertEquals(booleanToWrite, Boolean.valueOf(writer.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteNull() {
        try (Writer writer = new StringWriter()) {
            JsonWriter jsonWriter = new JsonWriter(writer);
            jsonWriter.writeNull();
            String expectedExpression = "null";
            Assert.assertEquals(expectedExpression, writer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
