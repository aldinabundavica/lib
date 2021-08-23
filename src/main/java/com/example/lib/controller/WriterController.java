package com.example.lib.controller;

import com.example.lib.model.Student;
import com.example.lib.model.Writer;
import com.example.lib.service.WriterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriterController {

    public WriterService _writerService;

    public WriterController(WriterService _writerService) {
        this._writerService = _writerService;
    }

    @GetMapping("/writers")
    public String getAllWriters(Model model) {
        model.addAttribute("writers", _writerService.getAllWriters());
        return "allWriters";
    }

    @RequestMapping("/deleteWriter/{id}")
    public String deleteWriterById(Model model, @PathVariable long id) {
        _writerService.deleteWriterById(id);
        return "redirect:/writers";
    }

    //adding writers
    @GetMapping("/writers/add")
    public String showCreateWriterForm(Model model) {
        model.addAttribute("writer", new Writer());
        return "addWriter";
    }

    @PostMapping("/addWriter")
    public String createWriter(Writer writer) {
        Writer newWriter = _writerService.createWriter(writer);
        if(newWriter != null) {
            return "redirect:/writers";
        }
        return "";
    }
}
