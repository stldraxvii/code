package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.launchcode.cheesemvc.models.CheeseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Matt on 5/18/2017.
 */

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeses", CheeseData.getall());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheese(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }
        CheeseData.add(newCheese);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title","Remove Cheese");
        model.addAttribute("cheeses",CheeseData.getall());
        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheese(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds){
            CheeseData.remove(cheeseId);
        }
        return "redirect:";
    }

    @RequestMapping(value = "edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("cheese", cheese);
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }
       Cheese theCheese = CheeseData.getById(cheese.getCheeseId());
       theCheese.setName(cheese.getName());
       theCheese.setDescription(cheese.getDescription());
       theCheese.setType(cheese.getType());
       return "redirect:";
    }

}
