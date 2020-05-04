package de.kartax.ocptestbackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    public static final String PATH_SIMPLE_GREETING = "hello";
    public static final String SIMPLE_RESPONSE = "Hello there!";

    @GetMapping("/"+PATH_SIMPLE_GREETING)
    public ResponseEntity<String> simpleGreeting(){
        logger.debug("simpleGreeting");
        String host = "unknown";
        try {
            host = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            logger.error("Error getting hostname!", e);
        }
        String response = SIMPLE_RESPONSE + " My hostname is: "+host;
        logger.debug(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
