package com.asher.generate.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Resource
@Getter
@Setter
public class MultiFileUploadForm {

    private String itemname;

    private String description;

    private List<MultipartFile> multiUploadFiles;

    private List<String> des;

}