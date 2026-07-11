package spring_learn.controller;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import spring_learn.security.JwtUtil;

@RestController
public class AuthController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        LOGGER.info("Start authenticate method");
        
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            LOGGER.warn("Missing or invalid Authorization header");
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Unauthorized");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
        }

        try {
            String base64Credentials = authHeader.substring("Basic ".length()).trim();
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            
            String[] values = credentials.split(":", 2);
            String username = values[0];
            
            LOGGER.info("Decoded username: {}", username);

            String token = jwtUtil.generateToken(username);
            
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            
            LOGGER.info("End authenticate method");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOGGER.error("Error during decoding credentials", e);
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid authorization format");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
