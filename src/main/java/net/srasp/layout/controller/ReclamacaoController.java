package net.srasp.layout.controller;

import net.srasp.layout.entity.Reclamacao;
import net.srasp.layout.entity.Unidade;
import net.srasp.layout.service.ReclamacaoService;
import net.srasp.layout.service.SeveridadeService;
import net.srasp.layout.service.StatusReclService;
import net.srasp.layout.service.UnidadeService;
import net.srasp.layout.service.SecretariaService;
import net.srasp.layout.service.AreaService;
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
    private StatusReclService statusReclService;
    @Autowired
    private SeveridadeService severidadeService;
    @Autowired
    private ReclamacaoService reclamacaoService;
    @Autowired
    private UnidadeService unidadeService;
    @Autowired
    private SecretariaService secretariaService;
    @Autowired
    private AreaService areaService;
    public static final String endpoint = "/reclamacao";

    public static String titulo = "Reclamação";

    @GetMapping(endpoint)
    public String list(Model model) {
        model.addAttribute("title", titulo);
        model.addAttribute("object_list", reclamacaoService.getAll());
        return "reclamacao/list_reclamacao";
    }

    @GetMapping(endpoint + "/new")
    public String createForm(Model model) {
        Reclamacao instance = new Reclamacao();
        model.addAttribute("title", titulo);
        model.addAttribute("object", instance);
        model.addAttribute("statusRecl", statusReclService.getAll());
        model.addAttribute("severidade", severidadeService.getAll());
        model.addAttribute("unidade", unidadeService.getAll());
        model.addAttribute("secretaria", secretariaService.getAll());
        model.addAttribute("area", areaService.getAll());
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
            model.addAttribute("title", titulo);
            model.addAttribute("object", instance.get());
            model.addAttribute("statusRecl", statusReclService.getAll());
            model.addAttribute("severidade", severidadeService.getAll());
            model.addAttribute("unidade", unidadeService.getAll());
            model.addAttribute("secretaria", secretariaService.getAll());
            model.addAttribute("area", areaService.getAll());
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