package pipeline.processor.types;

import pipeline.processor.Processor;

import java.util.Map;

public class CountNumOfFieldsProcessor implements Processor {
    public static final String NAME = "CountNumOfFields";

    private static final String TARGET_FIELD_NAME_KEY = "targetFieldName";

    private String targetFieldName;

    @Override
    public void initialize(Map<String, String> configuration) {
        targetFieldName = configuration.get(TARGET_FIELD_NAME_KEY);
    }

    @Override
    public void process(Map<String, Object> jsonDocument) {
        long numOfFields = jsonDocument.keySet().stream()
                .filter(s -> !s.equals(targetFieldName))
                .count();
        jsonDocument.put(targetFieldName, numOfFields);
    }
}
