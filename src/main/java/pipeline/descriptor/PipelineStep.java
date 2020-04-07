package pipeline.descriptor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PipelineStep {
    @JsonProperty("processor")
    private String processorName;
    @JsonProperty("configuration")
    private Map<String, String> processorConfiguration;
}
