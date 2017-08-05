package com.njlabs.showjava.processor;

class Processor {
    static void extract(ProcessService processService) {
        JarExtractor jarExtractor = new JarExtractor(processService);
        jarExtractor.extract();
    }
}
