package com.HimanshuBagga.projects.lovable_clone_springboot.Service.impl;

import com.HimanshuBagga.projects.lovable_clone_springboot.Service.FileService;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileContentResponse;
import com.HimanshuBagga.projects.lovable_clone_springboot.dto.project.FileNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileNode> getFileTree(Long projectId , Long UserId){
        return null;
    }
    @Override
    public FileContentResponse getFileContent(Long projectId , String path , Long userId){
        return  null;
    }
}
