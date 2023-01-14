package net.srasp.layout.controller;

import net.srasp.layout.entity.Area;
import net.srasp.layout.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;
    public static final String endpoint = "/area";
    public static String titulo = "Área";

    @GetMapping(endpoint)
    public String list(HttpServletRequest request, Model model) {
        model.addAttribute("title", titulo);
        model.addAttribute("object_list", areaService.getAll());
        return "area/list_area";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Area instance = new Area();
        model.addAttribute("title", titulo);
        model.addAttribute("object", instance);
        return "area/create_area";
    }

    @PostMapping(endpoint)
    public String save(@ModelAttribute("object") Area instance) {
        areaService.save(instance);
        return "redirect:/area";
    }

    @GetMapping(endpoint + "/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Optional<Area> instance = areaService.get(id);
        if (instance.isPresent()) {
            model.addAttribute("title", titulo);
            model.addAttribute("object", instance.get());
            return "area/update_area";
        } else {
            return "/general/404";
        }
    }

    @PostMapping(endpoint + "/{id}")
    public String update(@PathVariable String id,
                         @ModelAttribute("object") Area instance,
                         Model model) {
        areaService.update(id, instance);
        return "redirect:/area";
    }

    @GetMapping(endpoint + "/{id}")
    public String delete(@PathVariable Long id) {
        areaService.delete(id);
        return "redirect:/area";
    }
}
