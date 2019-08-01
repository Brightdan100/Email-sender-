package com.emailservice.autoemailsender.coontrollers;

import com.emailservice.autoemailsender.services.EmailSenderService;
import com.emailservice.autoemailsender.services.ExtractionOfEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;


@RestController
public class Controllers {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ExtractionOfEmailService extractionOfEmailService;

    public Controllers() { }

    @GetMapping("/")
    public String test() {
        return "Working Fine";
    }

    @PostMapping("/users")
    public void sendToAll(@NotNull @RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        emailSenderService.sendAll(extractionOfEmailService.getEmailInFileAsList(fileName));
    }
}
