package com.example.mycrud.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mycrud.Model.Story2;
import com.example.mycrud.Repository.StoryRepository;



@RestController
@RequestMapping(value = "/story")
public class StoryController2 {

    @Autowired
    StoryRepository storyRepository;

    @ResponseBody
    @RequestMapping(value = "/stories")
    public List<Story2> getBookDetails() {
        List<Story2> storyresponse = (List<Story2>) storyRepository.findAll();

        return storyresponse;
    }
}
