package com.uep.wap.controller;

import com.uep.wap.dto.InteractionDTO;
import com.uep.wap.model.Interaction;
import com.uep.wap.service.InteractionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping(path = "/interactions")
    public String addInteraction(@RequestBody InteractionDTO interactionDTO) {
        Interaction interaction = new Interaction();
        interaction.setTargetID(interactionDTO.getTargetID());
        interaction.setType(interactionDTO.getType());
        interaction.setTimestamp(interactionDTO.getTimestamp());

        interactionService.saveInteraction(interaction);
        return "Interaction added!";
    }

    @GetMapping(path = "/interactions")
    public Iterable<Interaction> getAllInteractions() {
        return interactionService.getAllInteractions();
    }

    @GetMapping(path = "/interactions/{interactionID}")
    public Interaction findInteractionByID(@PathVariable long interactionID) {
        return interactionService.getInteractionById(interactionID);
    }

    @DeleteMapping(path = "/interactions/{interactionID}")
    public void deleteInteractionById(@PathVariable long interactionID) {
        interactionService.deleteInteraction(interactionID);
    }
}
