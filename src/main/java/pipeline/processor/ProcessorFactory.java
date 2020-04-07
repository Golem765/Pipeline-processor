package pipeline.processor;

public interface ProcessorFactory {
    Processor create(String processorName);
}
