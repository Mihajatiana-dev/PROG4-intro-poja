package com.my.company.endpoint.rest.controller;

import static com.my.company.endpoint.rest.controller.health.PingController.OK;

import com.my.company.PojaGenerated;
import com.my.company.mail.Email;
import com.my.company.mail.Mailer;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@AllArgsConstructor
public class HelloWorldController {

  Mailer mailer;

  @GetMapping("/hello")
  public ResponseEntity<String> helloWorld(@RequestParam String to) throws AddressException {
    var email =
            new Email(
                    new InternetAddress(to),
                    List.of(),
                    List.of(),
                    "Hello world",
                    "... world!",
                    List.of());

    mailer.accept(email);
    return OK;
  }
}