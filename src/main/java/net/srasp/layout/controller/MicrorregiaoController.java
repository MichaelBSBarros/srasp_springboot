package net.srasp.layout.controller;

import net.srasp.layout.entity.Microrregiao;
import net.srasp.layout.service.MicrorregiaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MicrorregiaoController {

    @Autowired
    private MicrorregiaoService microrregiaoService;
    public static final String endpoint = "/microrregiao";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", "Microrregiao de Saúde");
        model.addAttribute("object_list", microrregiaoService.getAll());
        return "microrregiao/list_microrregiao";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Microrregiao instance = new Microrregiao();
        model.addAttribute("title", "Microrregiao de Saúde");
        model.addAttribute("object", instance);
        return "microrregiao/create_microrregiao";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Microrregiao instance) {
        microrregiaoService.save(instance);
        return "redirect:/microrregiao";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Microrregiao> instance = microrregiaoService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", "Microrregiao de Saúde");
            model.addAttribute("object", instance.get());
            return "microrregiao/update_microrregiao";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Microrregiao instance,
                         Model model) {
        microrregiaoService.update(id, instance);
        return "redirect:/microrregiao";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        microrregiaoService.delete(id);
        return "redirect:/microrregiao";
    }
}
