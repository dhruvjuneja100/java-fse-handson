package com.exercises.mockexamples;

public class MyService {

    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void pushData(String data) {
        externalApi.sendData(data);
    }
}
