package com.example.service;

public class MyService {
    private final ExternalApi api;
    
    public MyService(ExternalApi api) {
        this.api = api;
    }
    
    public void fetchData() {
        api.getData();
    }
    
    public void processData(String id, int value) {
        api.updateData(id, value);
    }
    
    public void complexOperation() {
        api.start();
        api.process();
        api.end();
    }
}