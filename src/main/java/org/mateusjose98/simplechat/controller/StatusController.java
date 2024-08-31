package org.mateusjose98.simplechat.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @GetMapping
    public String getStatus() throws UnknownHostException {
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("IP da instância: " + ip.getHostAddress());
        return ">>>>> OK >>>>> IP " + ip.getCanonicalHostName();
    }
}
