package ua.com.netcracker.training.jsonSerializer.writer;

import lombok.Data;

import java.io.Writer;

/**
 * @author Roman Horilyi
 */
@Data
public class IndentedJsonWriter extends JsonWriter {

    /**
     * Number of indention levels.
     */
    private int indentSize;

    /**
     * Current level of indention.
     */
    private int currentLevel;

    public IndentedJsonWriter(Writer writer, int indentSize) {
        super(writer);
        this.indentSize = indentSize;
        currentLevel = 0;
    }

    // TODO complete this class
}
