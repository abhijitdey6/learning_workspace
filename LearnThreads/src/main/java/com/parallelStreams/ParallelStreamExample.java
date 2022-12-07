package com.parallelStreams;

import threads.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;

import static threads.util.CommonUtil.delay;
import static threads.util.LoggerUtil.log;
import static threads.util.CommonUtil.stopWatch;

public class ParallelStreamExample {

    public List<String> transform(List<String> namesList){
        return namesList
                //.stream()
                .parallelStream()
                .map(this::addNameCaseTransformation)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        stopWatch.start();
        List<String> names= DataSet.namesList();
        ParallelStreamExample parallelStreamExample=new ParallelStreamExample();
        List<String> resultList=parallelStreamExample.transform(names);
        stopWatch.stop();
        log("Final Result:"+resultList);
        log("Time taken:"+stopWatch.getTime());
    }

    private String addNameCaseTransformation(String name) {
        delay(500);
        return name.length()+"-"+name.toUpperCase();
    }
}
