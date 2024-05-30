package com.uep.wap.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.Tag;
import com.uep.wap.repository.TagRepository;

import java.util.List;

    @Service
    public class TagService {
        @Autowired
        private TagRepository tagRepository;

        public List<Tag> getAllTags() {
            return tagRepository.findAll();
        }

        public Tag getTagById(Long id) {
            return tagRepository.findById(id).orElse(null);
        }

        public Tag saveTag(Tag tag) {
            return tagRepository.save(tag);
        }

        public void deleteTag(Long id) {
            tagRepository.deleteById(id);
        }
    }

