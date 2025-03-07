package com.jayklef.smart_email_reply.email;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailContent;
    private String tone;
}
