package ru.otus.spring.domain;

public class Answer {
    private String response;
    private TypeResponse type;

    public Answer( String response, TypeResponse type) {
        this.response = response;
        this.type = type;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setType(TypeResponse type) {
        this.type = type;
    }

    public TypeResponse getType() {
        return type;
    }
}
