package com.HimanshuBagga.projects.lovable_clone_springboot.error;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class BadRequestException extends RuntimeException{
    String message;
}
