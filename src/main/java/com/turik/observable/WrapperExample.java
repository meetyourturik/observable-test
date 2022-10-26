package com.turik.observable;

import rx.Observable;

public class WrapperExample {

    static Observable<String> apply(String format) {
        return Worker.executeFunctionWithWrapper(str -> {
                    System.out.printf(format, "test");
                    return Observable.just(str);
                }, format)
                .doOnError(e -> System.out.println("there was an exception: " + e));
    }

    public static void main(String[] args) {
        apply("%d").subscribe((m) -> {}, (e) -> {});
    }
}
