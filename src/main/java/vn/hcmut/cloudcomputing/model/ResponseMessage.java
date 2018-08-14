package vn.hcmut.cloudcomputing.model;

public class ResponseMessage {
    private ResponseCode code;
    private String message;
    private byte[] result;

    public ResponseMessage(ResponseCode code, String message, byte[] result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public ResponseCode getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public byte[] getResult() {
        return result;
    }

    public void setResult(byte[] result) {
        this.result = result;
    }
}
