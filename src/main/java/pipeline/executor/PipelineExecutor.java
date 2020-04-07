package pipeline.executor;

import lombok.AllArgsConstructor;
import pipeline.descriptor.PipelineDescriptor;
import pipeline.processor.Processor;
import pipeline.processor.ProcessorFactory;

import java.util.Map;

@AllArgsConstructor
public class PipelineExecutor {
    private final ProcessorFactory processorFactory;

    public void transform(PipelineDescriptor pipelineDescriptor, Map<String, Object> jsonDocument) {
        pipelineDescriptor.getSteps().forEach(pipelineStep -> {
            Processor processor = processorFactory.create(pipelineStep.getProcessorName());
            processor.initialize(pipelineStep.getProcessorConfiguration());

            processor.process(jsonDocument);
        });
    }
}
