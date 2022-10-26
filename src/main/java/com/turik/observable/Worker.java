package com.turik.observable;

import rx.Observable;

import java.util.function.Function;

public class Worker {

    public static Observable<String> executeFunction(Function<String, Observable<String>> function, String message) {
        System.out.println("executing function");
        try {
            return function.apply(message);
        } finally {
            System.out.println("final block");
        }
    }

    public static Observable<String> executeFunctionWithWrapper(Function<String, Observable<String>> function, String message) {
        System.out.println("executing function");
        try {
            return function.apply(message);
        } catch (Exception e) {
            return Observable.error(e);
        } finally {
            System.out.println("final block");
        }
    }

}
