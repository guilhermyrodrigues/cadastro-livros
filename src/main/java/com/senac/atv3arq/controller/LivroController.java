package com.senac.atv3arq.controller;

import com.senac.atv3arq.model.LivroModel;
import com.senac.atv3arq.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping("/")
    public String redirectToLivros() {
        return "redirect:/livros";
    }

    @GetMapping("/livros")
    public String listaLivros(Model model) {
        List<LivroModel> livros = livroRepository.findAll();
        model.addAttribute("livros", livroRepository.findAll());
        return "lista-livros";
    }

    @GetMapping("/addLivro")
    public String adicionarLivroForm(Model model) {
        model.addAttribute("livro", new LivroModel());
        return "livro-form";
    }

    @PostMapping("/addLivro")
    public String addUser(@ModelAttribute("user") LivroModel livro) {
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    @GetMapping("/delete/{id}")
    public String deletarLivro(@PathVariable Integer id) {
        livroRepository.deleteById(id);
        return "redirect:/";
    }

}
