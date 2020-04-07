package pipeline.descriptor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.Map;

@Value
public class PipelineStep {
    private final String processorName;

    private final Map<String, String> processorConfiguration;

    public PipelineStep(@JsonProperty("processor") String processorName,
                        @JsonProperty("configuration") Map<String, String> processorConfiguration) {
        this.processorName = processorName;
        this.processorConfiguration = processorConfiguration;
    }
}
