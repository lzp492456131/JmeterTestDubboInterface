package com.jjshome.Consumer;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;

public class TestCou {
    public  static  void main(String args[]){
        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(new Arguments());
        ConsumerClient consumerClient = new ConsumerClient();
        consumerClient.setupTest(javaSamplerContext);
        consumerClient.runTest(javaSamplerContext);
        consumerClient.teardownTest(javaSamplerContext);
    }
}
