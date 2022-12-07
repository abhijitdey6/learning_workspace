package com.forkNjoin;

import threads.util.DataSet;

import java.util.ArrayList;
import java.util.List;

import static threads.util.LoggerUtil.log;
import static threads.util.CommonUtil.stopWatch;
import static threads.util.CommonUtil.delay;

public class StringTransformation {
    public static void main(String[] args) {
        stopWatch.start();
        List<String> resultSet=new ArrayList<>();
        List<String> names = DataSet.namesList();
        names.forEach((name) -> {
            String newValue = addNameCaseTransformation(name);
            resultSet.add(newValue);
        });
        stopWatch.stop();
        log("Final Result:"+resultSet);
        log("Time taken:"+stopWatch.getTime());
    }

    private static String addNameCaseTransformation(String name) {
        delay(2000);
        return name.length()+"-"+name.toUpperCase();
    }
}
