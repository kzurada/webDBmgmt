package com.web.project.controller;

import com.web.project.model.Contract;
import com.web.project.service.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ContractController {

    @Autowired
    ContractRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String RedirectFromHome(){
        return "redirect:/list-contracts";
    }

    @RequestMapping(value = "/list-contracts", method = RequestMethod.GET)
    public String showContracts(ModelMap model) {
        model.put("contracts", repository.findAll());
        return "list-contracts";
    }

    @RequestMapping(value = "/update-contract", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
        Optional<Contract> contract = repository.findById(id);
        model.put("contract", contract);
        return "contract";
    }

    @RequestMapping(value = "/update-contract", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Contract contract,
                             BindingResult result) {
        repository.save(contract);
        return "redirect:/list-contracts";
    }

    @RequestMapping(value = "/list-contracts-active-true", method = RequestMethod.GET)
    public String showActiveConctracts(ModelMap model) {
        model.put("contracts", repository.findAll());
        return "list-contracts-active-true";
    }

    @RequestMapping(value = "/list-contracts-active-false", method = RequestMethod.GET)
    public String showNonActiveConctracts(ModelMap model) {
        model.put("contracts", repository.findAll());
        return "list-contracts-active-false";
    }

    @RequestMapping(value = "/delete-contract", method = RequestMethod.GET)
    public String deleteContract(@RequestParam int id) {
        repository.deleteById(id);
        return "redirect:/list-contracts";

    }

    @RequestMapping(value = "/add-contract", method = RequestMethod.GET)
    public String showAddContractPage (ModelMap model) {
        model.addAttribute("contract", new Contract(0, "Default", true, "default"));
        return "contract";
    }

    @RequestMapping(value = "/add-contract", method = RequestMethod.POST)
    public String addConctract(ModelMap model, @Valid Contract contract, BindingResult result) {

        if (result.hasErrors()) {
            return "contract";
        }

        repository.save(contract);
        return "redirect:/list-contracts";


    }

}
