package net.srasp.layout.controller;

import net.srasp.layout.entity.Reclamacao;
import net.srasp.layout.service.ReclamacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ReclamacaoController {

    @Autowired
    private ReclamacaoService reclamacaoService;
    public static final String endpoint = "/reclamacao";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", "Reclamação");
        model.addAttribute("object_list", reclamacaoService.getAll());
        return "reclamacao/list_reclamacao";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Reclamacao instance = new Reclamacao();
        model.addAttribute("title", "Reclamação");
        model.addAttribute("object", instance);
        return "reclamacao/create_reclamacao";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Reclamacao instance) {
        reclamacaoService.save(instance);
        return "redirect:/reclamacao";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Reclamacao> instance = reclamacaoService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", "Reclamação");
            model.addAttribute("object", instance.get());
            return "reclamacao/update_reclamacao";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Reclamacao instance,
                         Model model) {
        reclamacaoService.update(id, instance);
        return "redirect:/reclamacao";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        reclamacaoService.delete(id);
        return "redirect:/reclamacao";
    }
}