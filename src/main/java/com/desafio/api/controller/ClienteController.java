package com.desafio.api.controller;

import com.desafio.api.model.Cliente;
import com.desafio.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping
    public List<Cliente> listaClientes(){
        return  repository.findAll();
    }

    @PostMapping
    public void adicionarClientes(@RequestBody Cliente cliente ){
        repository.save(cliente);
    }

    public Cliente atualizar(@RequestBody Cliente cliente ){
        if (cliente.getId()>0){
            return repository.save(cliente);
        }
        return null;
    }

    public String deletar(@RequestBody Cliente cliente){
        if (cliente.getId()>0) {
            repository.delete(cliente);
            return "Removido";
        }
        return "Falha ao remover";

    }


}
