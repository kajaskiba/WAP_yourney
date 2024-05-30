package com.uep.wap.controller;

import com.uep.wap.dto.TagDTO;
import com.uep.wap.model.Tag;
import com.uep.wap.service.TagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping(path = "/tags")
    public String addTag(@RequestBody TagDTO tagDTO) {
        Tag tag = new Tag();
        tag.setTagID(tagDTO.getTagID());
        tag.setName(tagDTO.getName());

        tagService.saveTag(tag);
        return "Tag added!";
    }

    @GetMapping(path = "/tags")
    public Iterable<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping(path = "/tags/{tagID}")
    public Tag findTagByID(@PathVariable long tagID) {
        return tagService.getTagById(tagID);
    }

    @DeleteMapping(path = "/tags/{tagID}")
    public void deleteTagById(@PathVariable long tagID) {
        tagService.deleteTag(tagID);
    }
}
