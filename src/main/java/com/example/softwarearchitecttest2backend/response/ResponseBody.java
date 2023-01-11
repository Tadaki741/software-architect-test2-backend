package com.example.softwarearchitecttest2backend.response;

public class ResponseBody {

    private Object data;

    private String message;

    public ResponseBody(Object data, String message) {
        this.data = data;
        this.message = message;
    }

    public ResponseBody(Object data) {
        this.data = data;
    }

    public ResponseBody() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

