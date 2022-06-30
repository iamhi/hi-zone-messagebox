package com.github.iamhi.hizone.messagebox.in.message;

public record SendMessageRequest(
    String content,
    String receiver
) {
}
