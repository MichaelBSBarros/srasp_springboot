package net.srasp.layout.controller;

import net.srasp.layout.entity.Severidade;
import net.srasp.layout.entity.StatusRecl;
import net.srasp.layout.service.SeveridadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class  SeveridadeController {

    @Autowired
    private SeveridadeService severidadeService;
    public static final String endpoint = "/severidade";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", "Severidade");
        model.addAttribute("object_list", severidadeService.getAll());
        return "severidade/list_severidade";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Severidade instance = new Severidade();
        model.addAttribute("title", "Severidade");
        model.addAttribute("object", instance);
        return "severidade/create_severidade";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Severidade instance) {
        severidadeService.save(instance);
        return "redirect:/severidade";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Severidade> instance = severidadeService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", "Severidade");
            model.addAttribute("object", instance.get());
            return "severidade/update_severidade";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Severidade instance,
                         Model model) {
        severidadeService.update(id, instance);
        return "redirect:/severidade";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        severidadeService.delete(id);
        return "redirect:/severidade";
    }
}
