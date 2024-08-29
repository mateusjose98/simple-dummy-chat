package org.mateusjose98.simplechat.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.mateusjose98.simplechat.dto.ConversationDTO;
import org.mateusjose98.simplechat.dto.ConversationDetailsDTO;
import org.mateusjose98.simplechat.dto.SendMessageRequestDTO;
import org.mateusjose98.simplechat.entity.Message;
import org.mateusjose98.simplechat.service.ConversationService;
import org.mateusjose98.simplechat.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversation")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Long> createConversation(@RequestBody ConversationDTO conversationDto) {
        Long id = conversationService.createConversation(conversationDto);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/{id}/messages")
    public ResponseEntity<Void> sendMessage(
            @PathVariable Long id,
            @RequestBody SendMessageRequestDTO request) {
        conversationService.sendMessage(id, request.getSenderId(), request.getMessage());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConversationDetailsDTO> getMessage(@PathVariable Long id) {
        return ResponseEntity.ok(conversationService.findDetails(id).orElseThrow());
    }
}
