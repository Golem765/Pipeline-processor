package pipeline.processor.types;

import pipeline.processor.Processor;

import java.util.Map;

public class RemoveFieldProcessor implements Processor {
    public static final String NAME = "RemoveField";

    private static final String FIELD_NAME_KEY = "fieldName";

    private String fieldName;

    @Override
    public void initialize(Map<String, String> configuration) {
        fieldName = configuration.get(FIELD_NAME_KEY);
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.remove(fieldName);
    }
}
