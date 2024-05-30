package com.uep.wap.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uep.wap.model.Interaction;
import com.uep.wap.repository.InteractionRepository;

import java.util.List;

    @Service
    public class InteractionService {
        @Autowired
        private InteractionRepository interactionRepository;

        public List<Interaction> getAllInteractions() {
            return interactionRepository.findAll();
        }

        public Interaction getInteractionById(Long id) {
            return interactionRepository.findById(id).orElse(null);
        }

        public Interaction saveInteraction(Interaction interaction) {
            return interactionRepository.save(interaction);
        }

        public void deleteInteraction(Long id) {
            interactionRepository.deleteById(id);
        }
    }


