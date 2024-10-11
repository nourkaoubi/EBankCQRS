package com.example.demo.commonapi.events;

public class BaseEvent <T>{
    private T id ;

    public T getId() {
        return id;
    }

    public BaseEvent(T id ){
        this.id=id;
    }
}
