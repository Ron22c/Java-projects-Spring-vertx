package com.cranajit.gyanexchange.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {
    private final TemplateEngine engine;
    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return engine.process("MailTemplate", context);
    }
}
