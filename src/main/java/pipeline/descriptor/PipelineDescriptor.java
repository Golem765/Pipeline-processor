package pipeline.descriptor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class PipelineDescriptor {
    private final List<PipelineStep> steps;

    public PipelineDescriptor(@JsonProperty("steps") List<PipelineStep> steps) {
        this.steps = steps;
    }
}
