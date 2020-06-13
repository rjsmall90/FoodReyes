package com.foodreyes.menu.core.email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class EmailTemplate {

    private String from;
    private String to;
    private String subject;
    private String text;
    private String[] bccAddresses;
}
