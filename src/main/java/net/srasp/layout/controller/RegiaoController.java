package net.srasp.layout.controller;

import net.srasp.layout.entity.Regiao;
import net.srasp.layout.service.RegiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RegiaoController {

    @Autowired
    private RegiaoService regiaoService;
    public static final String endpoint = "/regiao";
    public static String titulo = "Região de Saúde";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", titulo);
        model.addAttribute("object_list", regiaoService.getAll());
        return "regiao/list_regiao";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Regiao instance = new Regiao();
        model.addAttribute("title", titulo);
        model.addAttribute("object", instance);
        return "regiao/create_regiao";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Regiao instance) {
        regiaoService.save(instance);
        return "redirect:/regiao";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Regiao> instance = regiaoService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", titulo);
            model.addAttribute("object", instance.get());
            return "regiao/update_regiao";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Regiao instance,
                         Model model) {
        regiaoService.update(id, instance);
        return "redirect:/regiao";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        regiaoService.delete(id);
        return "redirect:/regiao";
    }
}
