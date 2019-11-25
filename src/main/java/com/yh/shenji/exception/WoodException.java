package com.yh.shenji.exception;

/**
 * Demo WoodException
 *
 * @author YangDongYu
 * @date 2019/11/23 14:10
 */
public class WoodException extends RuntimeException {
    public WoodException() {
        super();
    }

    public WoodException(String message) {
        super(message);
    }

    public WoodException(String message, Throwable cause) {
        super(message, cause);
    }

    public WoodException(Throwable cause) {
        super(cause);
    }
}
