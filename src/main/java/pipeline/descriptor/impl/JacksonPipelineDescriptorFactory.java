package pipeline.descriptor.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import pipeline.descriptor.PipelineDescriptor;
import pipeline.descriptor.PipelineDescriptorFactory;

import java.io.IOException;

public class JacksonPipelineDescriptorFactory implements PipelineDescriptorFactory {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public PipelineDescriptor createDescriptor(String json) throws IllegalArgumentException {
        try {
            return mapper.readValue(json, PipelineDescriptor.class);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
