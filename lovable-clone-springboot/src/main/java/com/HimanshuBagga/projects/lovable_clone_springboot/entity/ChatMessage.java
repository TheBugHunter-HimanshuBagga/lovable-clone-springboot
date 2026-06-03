package com.HimanshuBagga.projects.lovable_clone_springboot.entity;

import com.HimanshuBagga.projects.lovable_clone_springboot.enums.MessageRole;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    Long id;
    ChatSession chatSession;

    String content;
    MessageRole role;
    String toolCalls;

    Instant createdAt;

}
