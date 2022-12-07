package com.forkNjoin;

import threads.util.DataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import static threads.util.LoggerUtil.log;
import static threads.util.CommonUtil.stopWatch;
import static threads.util.CommonUtil.delay;

public class ForkJoinUsingRecursion extends RecursiveTask<List<String>> {

    private List<String> inputList;
    public ForkJoinUsingRecursion(List<String> inputList) {
        this.inputList = inputList;
    }

    public static void main(String[] args) {
        stopWatch.start();
        List<String> resultSet=new ArrayList<>();
        List<String> names = DataSet.namesList();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinUsingRecursion forkJoinUsingRecursion=new ForkJoinUsingRecursion(names);
        resultSet = forkJoinPool.invoke(forkJoinUsingRecursion);
        stopWatch.stop();
        log("Final Result:"+resultSet);
        log("Time taken:"+stopWatch.getTime());
    }

    @Override
    protected List<String> compute() {
        if(inputList.size()<=1){
            List<String> resultList=new ArrayList<>();
            inputList.forEach((name)->{
                String newValue=addNameCaseTransformation(name);
                resultList.add(newValue);
            });
            return resultList;
        }

        int midpoint = inputList.size()/2;
        ForkJoinTask<List<String>> leftList=new ForkJoinUsingRecursion(inputList.subList(0,midpoint)).fork();
        inputList = inputList.subList(midpoint,inputList.size());
        List<String> rightResult=compute();
        List<String> leftResult=leftList.join();
        leftResult.addAll(rightResult);

        return leftResult;
    }

    private static String addNameCaseTransformation(String name) {
        delay(2000);
        return name.length()+"-"+name.toUpperCase();
    }
}
