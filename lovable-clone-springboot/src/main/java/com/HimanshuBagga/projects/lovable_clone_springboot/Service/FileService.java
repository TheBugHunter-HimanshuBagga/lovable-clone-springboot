package com.HimanshuBagga.projects.lovable_clone_springboot.Service;

import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileContentResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileNode;

import java.util.List;

public interface FileService {
    List<FileNode> getFileTree(Long projectId , Long UserId);
    FileContentResponse getFileContent(Long projectId , String path ,Long userId);
}
