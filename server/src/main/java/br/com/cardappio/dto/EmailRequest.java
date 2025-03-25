package br.com.cardappio.dto;

public record EmailRequest(
        String receiver,
        String subject,
        String content
) {}
