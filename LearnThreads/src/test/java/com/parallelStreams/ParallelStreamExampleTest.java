package com.parallelStreams;

import org.junit.jupiter.api.Test;
import threads.util.DataSet;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParallelStreamExampleTest{
    ParallelStreamExample parallelStreamExample=new ParallelStreamExample();

    @Test
    public void testTransform() {
        List<String> namesList= DataSet.namesList();

        List<String> resultList=parallelStreamExample.transform(namesList);

        assertEquals(4,resultList.size());
        resultList.forEach((name)->assertTrue(name.contains("-")));
    }
}