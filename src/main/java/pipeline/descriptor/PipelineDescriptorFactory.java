package pipeline.descriptor;

public interface PipelineDescriptorFactory {
    PipelineDescriptor createDescriptor(String json) throws IllegalArgumentException;
}
