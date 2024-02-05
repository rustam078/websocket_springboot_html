package com.abc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UploadController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadData(@RequestParam String data) {
        messagingTemplate.convertAndSend("/topic/uploadNotification", "Hi "+data+" Data uploaded successfully");       
        return ResponseEntity.ok().build();
    }
}
