package com.HimanshuBagga.projects.lovable_clone_springboot.error;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ApiError(
    HttpStatus status,
    String message,
    Instant timeStamp
) {
    public ApiError(HttpStatus status , String message){
        this(status,message,Instant.now());
    }
}

/*

This will be returned if any kind of error ouccers
 */

/*

    working

1. My Api is called
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Long userId = 1L;
        ProjectResponse projectResponse = projectService.getUserProjectById(id , userId);
        return ResponseEntity.ok(projectResponse);
    }
2. Now it has 2 options Since its Optional
    (i) it will return a response if the element with that id is present in there
        {
            "id": 1,
            "name": "name update 1",
            "createdAt": "2026-06-05T06:37:36.039060Z",
            "updatedAt": "2026-06-05T11:42:00.623261Z",
            "owner": {
                        "id": 1,
                        "email": "himanshu@example.com",
                        "name": "Himanshu Bagga",
                        "avatarUrl": "https://i.pravatar.cc/150?img=1"
                     }
        }

    (ii) if {project with id} does not exist then:
            it will class orElseThrow in which i have defined:
                () -> new ResourceNotFoundException("Project",id.toString())
                now this will call directly yo my GlobalExceptionHandler and check where my ResourceNotFoundException is defined

                    @ExceptionHandler(ResourceNotFoundException.class)
                    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException exception){
                    ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exception.getResourceName() + " with id " + exception.getResourceId() + " not found");
                    log.error(apiError.toString());
                    return ResponseEntity.status(apiError.status()).body(apiError);
                    }

 */