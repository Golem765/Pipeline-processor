package pipeline.executor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pipeline.descriptor.PipelineDescriptor;
import pipeline.descriptor.PipelineDescriptorFactory;
import pipeline.descriptor.impl.JacksonPipelineDescriptorFactory;
import pipeline.processor.impl.DefaultProcessorFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PipelineExecutorTest {
    private static final String FIRST_NAME = "George";
    private static final String FIRST_NAME_FIELD_KEY = "firstName";
    private static final String NUM_OF_FIELDS_TARGET_KEY = "numOfFields";

    private static final String TEST_PIPELINE = "{" +
            "  \"steps\": [" +
            "     {" +
            "       \"processor\": \"AddField\"," +
            "       \"configuration\": {" +
            "           \"fieldName\": \"" + FIRST_NAME_FIELD_KEY + "\"," +
            "           \"fieldValue\": \"" + FIRST_NAME + "\"" +
            "        }" +
            "      }," +
            "      {" +
            "       \"processor\": \"CountNumOfFields\"," +
            "       \"configuration\": {" +
            "           \"targetFieldName\": \"" + NUM_OF_FIELDS_TARGET_KEY + "\"" +
            "        }" +
            "      }" +
            "    ]" +
            "}";

    private PipelineExecutor executor;
    private PipelineDescriptorFactory descriptorFactory;

    @BeforeEach
    void setUp() {
        executor = new PipelineExecutor(new DefaultProcessorFactory());
        descriptorFactory = new JacksonPipelineDescriptorFactory();
    }

    @Test
    void testTransform() {
        int baseNumOfFields = 3;
        Map<String, Object> baseJson = createBaseJson(baseNumOfFields);

        PipelineDescriptor descriptor = descriptorFactory.createDescriptor(TEST_PIPELINE);

        Map<String, Object> testDocument = new HashMap<>(baseJson);
        executor.transform(descriptor, testDocument);

        assertEquals(FIRST_NAME, testDocument.get(FIRST_NAME_FIELD_KEY));
        assertEquals(baseNumOfFields + 1, (Long) testDocument.get(NUM_OF_FIELDS_TARGET_KEY));
        for (Map.Entry<String, Object> baseEntry : baseJson.entrySet()) {
            assertEquals(baseEntry.getValue(), testDocument.get(baseEntry.getKey()));
        }
    }

    private Map<String, Object> createBaseJson(int numOfFields) {
        Map<String, Object> json = new HashMap<>();
        for (int i = 0; i < numOfFields; i++) {
            json.put(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        }
        return json;
    }
}
