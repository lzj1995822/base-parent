package com.asher.generate.web.controller;

import com.asher.generate.dao.TeacherDao;
import com.asher.generate.entity.FormA;
import com.asher.generate.entity.MultiFileUploadForm;
import com.asher.generate.entity.Student;
import com.asher.generate.entity.Teacher;
import io.swagger.annotations.Api;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "test")
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TeacherDao teacherDao;

    @GetMapping("/")
    @ResponseBody
    public int test() {
        return 1;
    }

    @RequestMapping(value = "/forma", method = RequestMethod.POST)
    public String form(Teacher teacher) {
        teacherDao.save(teacher);
        return "items/success";
    }

    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public String uploadFile(MultiFileUploadForm multiFileUploadForm) {
        List<String> fileNames = new ArrayList<String>();
        List<MultipartFile> requestFiles = new ArrayList<MultipartFile>();
/*        System.out.println(multiFileUploadForm.getItemname());
        System.out.println(multiFileUploadForm.getDescription());
        requestFiles = multiFileUploadForm.getMultiUploadFiles();*/
        if (null != requestFiles && requestFiles.size() > 0) {
            for (MultipartFile mf : requestFiles) {
                fileNames.add(mf.getOriginalFilename());
                try {
                    mf.transferTo(new File("E:/Upload/"
                            + mf.getOriginalFilename()));
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String file : fileNames) {
            System.out.println(file);
        }
        return "items/success";
    }

    @Test
    public void s() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("src\\main\\resources\\applicationContext.xml");
        Student student = (Student) applicationContext.getBean("student");
        student.setName("1223");
        System.out.println(student.getName());
    }
}
