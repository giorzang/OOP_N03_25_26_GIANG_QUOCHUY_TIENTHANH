package com.example.servingwebcontent.exception;
public class InsufficientStockException extends RuntimeException {

    /**
     * Constructor nhận một thông báo lỗi cụ thể.
     * @param message Thông báo mô tả lỗi (ví dụ:
     */
    public InsufficientStockException(String message) {
        super(message);
    }
}