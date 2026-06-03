package com.HimanshuBagga.projects.lovable_clone_springboot.Controller;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.FileService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileContentResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/files")
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping // get all files
    public ResponseEntity<List<FileNode>> getFileTree(@PathVariable Long projectId){
        Long userId = 1L;
        List<FileNode> fileNodes = fileService.getFileTree(projectId , userId);
        return ResponseEntity.ok(fileNodes);
    }

    @GetMapping("/{*path}") // get a single file
    public ResponseEntity<FileContentResponse> getFile(@PathVariable Long projectId,
                                                       @PathVariable String path){
        Long userId = 1L;
        FileContentResponse fileContentResponse = fileService.getFileContent(projectId , path , userId);
        return ResponseEntity.ok(fileContentResponse);
    }
}
