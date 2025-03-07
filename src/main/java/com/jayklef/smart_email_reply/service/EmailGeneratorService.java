package com.jayklef.smart_email_reply.service;

import com.jayklef.smart_email_reply.email.EmailRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailGeneratorService {
    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String generateEmail(EmailRequest emailRequest){
        //Build the prompt
        String prompt = buildPrompt(emailRequest);

        // craft a response
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                      Map.of("parts", new Object[]{
                              Map.of("text", prompt)
                      })
                }
        );

        //Do a request and get a reply


        // return a response
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();

        prompt.append("Generate a professional email reply for the following email content. Please don't generate a subject line");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append("");
        }

        prompt.append("\noriginal email: \n").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
