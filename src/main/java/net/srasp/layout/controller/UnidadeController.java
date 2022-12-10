package net.srasp.layout.controller;

import net.srasp.layout.entity.Unidade;
import net.srasp.layout.service.UnidadeService;
import net.srasp.layout.service.RegiaoService;
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
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;
    @Autowired
    private RegiaoService regiaoService;
    @Autowired
    private MicrorregiaoService microrregiaoService;
    public static final String endpoint = "/unidade";

    public static String titulo = "Unidade Pública";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", titulo);
        model.addAttribute("object_list", unidadeService.getAll());
        return "unidade/list_unidade";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Unidade instance = new Unidade();
        model.addAttribute("title", titulo);
        model.addAttribute("object", instance);
        model.addAttribute("regiao", regiaoService.getAll());
        model.addAttribute("microrregiao", microrregiaoService.getAll());
        return "unidade/create_unidade";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Unidade instance) {
        unidadeService.save(instance);
        return "redirect:/unidade";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Unidade> instance = unidadeService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", titulo);
            model.addAttribute("object", instance.get());
            model.addAttribute("regiao", regiaoService.getAll());
            model.addAttribute("microrregiao", microrregiaoService.getAll());
            return "unidade/update_unidade";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Unidade instance,
                         Model model) {
        unidadeService.update(id, instance);
        return "redirect:/unidade";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        unidadeService.delete(id);
        return "redirect:/unidade";
    }
}
