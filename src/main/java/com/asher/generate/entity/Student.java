package com.asher.generate.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Service
public class Student {

    private String id;

    private String name;
}
