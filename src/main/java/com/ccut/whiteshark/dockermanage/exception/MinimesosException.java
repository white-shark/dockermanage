package com.ccut.whiteshark.dockermanage.exception;

/**
 * @author WhiteShark
 * @version 1.0
 * @date 2021/5/3 11:29 下午
 */
public class MinimesosException extends RuntimeException {

    public MinimesosException(String message) {
        super(message);
    }

    public MinimesosException(String message, Throwable cause) {
        super(message, cause);
    }

}
