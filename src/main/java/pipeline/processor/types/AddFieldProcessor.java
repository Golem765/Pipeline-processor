package pipeline.processor.types;

import pipeline.processor.Processor;

import java.util.Map;

public class AddFieldProcessor implements Processor {
    public static final String NAME = "AddField";

    private static final String FIELD_NAME_KEY = "fieldName";
    private static final String FIELD_VALUE_KEY = "fieldValue";

    private String fieldName;
    private String fieldValue;

    @Override
    public void initialize(Map<String, String> configuration) {
        fieldName = configuration.get(FIELD_NAME_KEY);
        fieldValue = configuration.get(FIELD_VALUE_KEY);
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        jsonDocument.put(fieldName, fieldValue);
    }
}
