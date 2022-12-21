package br.com.kelvin.java19spring3.common;

public record ResponseData(boolean successful, String message, Object data) {
    public static ResponseData success(Object data, String message) {
        return new ResponseData(true, message, data);
    }

    public static ResponseData success(Object data) {
        return new ResponseData(true, null, data);
    }

    public static ResponseData fail(String message) {
        return new ResponseData(false, message, null);
    }

    public static ResponseData fail(String message, Object data) {
        return new ResponseData(false, message, data);
    }
}
