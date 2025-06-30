package com.example.service;

public interface ExternalApi {
    String getData();
    void updateData(String id, int value);
    void deleteData();
    void start();
    void process();
    void end();
}
