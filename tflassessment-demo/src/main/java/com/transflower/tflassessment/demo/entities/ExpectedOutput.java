package com.transflower.tflassessment.demo.entities;


public class ExpectedOutput {

    private String message;
    private boolean status;

    // Default constructor
    public ExpectedOutput() { }

    // Parameterized constructor
    public ExpectedOutput(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for status
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
