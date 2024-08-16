package org.example.todo_back.dto.responses;

import lombok.Data;

@Data
public class GetReponseBases {

    private String message;
    private Object data;

    public GetReponseBases(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public GetReponseBases(String message) {
        this.message = message;
    }
}
