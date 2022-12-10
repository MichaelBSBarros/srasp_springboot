package net.srasp.layout.controller;

import net.srasp.layout.entity.Secretaria;
import net.srasp.layout.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;
    public static final String endpoint = "/secretaria";

    public static String titulo = "Secretaria";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", titulo);
        model.addAttribute("object_list", secretariaService.getAll());
        return "secretaria/list_secretaria";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Secretaria instance = new Secretaria();
        model.addAttribute("title", titulo);
        model.addAttribute("object", instance);
        return "secretaria/create_secretaria";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Secretaria instance) {
        secretariaService.save(instance);
        return "redirect:/secretaria";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Secretaria> instance = secretariaService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", titulo);
            model.addAttribute("object", instance.get());
            return "secretaria/update_secretaria";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Secretaria instance,
                         Model model) {
        secretariaService.update(id, instance);
        return "redirect:/secretaria";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        secretariaService.delete(id);
        return "redirect:/secretaria";
    }
}
