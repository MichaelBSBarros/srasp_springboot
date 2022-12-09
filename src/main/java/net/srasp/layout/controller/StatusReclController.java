package net.srasp.layout.controller;

import net.srasp.layout.entity.StatusRecl;
import net.srasp.layout.service.StatusReclService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;
import java.util.Optional;

@Controller
public class StatusReclController {

    @Autowired
    private StatusReclService statusReclService;
    public static final String endpoint = "/statusrecl";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", "Status de Reclamação");
        model.addAttribute("object_list", statusReclService.getAll());
        return "statusrecl/list";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        StatusRecl instance = new StatusRecl();
        model.addAttribute("title", "Status de Reclamação");
        model.addAttribute("object", instance);
        return "statusrecl/create";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") StatusRecl instance) {
        statusReclService.save(instance);
        return "redirect:/statusrecl";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<StatusRecl> instance = statusReclService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", "Status de Reclamação");
            model.addAttribute("object", instance.get());
            return "statusrecl/update_form";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                                @ModelAttribute("object") StatusRecl instance,
                                Model model) {
        statusReclService.update(id, instance);
        return "redirect:/statusrecl";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        statusReclService.delete(id);
        return "redirect:/statusrecl";
    }
	
}
