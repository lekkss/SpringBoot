package com.lekkss.ch2;

public record JsonResponse<T>(
        boolean status, String message, T data) {
}
