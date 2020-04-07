package pipeline.processor.impl;

import pipeline.processor.Processor;
import pipeline.processor.ProcessorFactory;
import pipeline.processor.types.AddFieldProcessor;
import pipeline.processor.types.CountNumOfFieldsProcessor;
import pipeline.processor.types.RemoveFieldProcessor;

public class DefaultProcessorFactory implements ProcessorFactory {
    @Override
    public Processor create(String processorName) {
        switch (processorName) {
            case AddFieldProcessor.NAME: {
                return new AddFieldProcessor();
            }
            case RemoveFieldProcessor.NAME: {
                return new RemoveFieldProcessor();
            }
            case CountNumOfFieldsProcessor.NAME: {
                return new CountNumOfFieldsProcessor();
            }
            default: {
                throw new IllegalArgumentException(processorName);
            }
        }
    }
}
