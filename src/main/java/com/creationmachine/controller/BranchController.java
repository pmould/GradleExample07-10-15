package com.creationmachine.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.creationmachine.model.Branch;
import com.creationmachine.model.Employee;
import com.creationmachine.service.BranchService;
import com.creationmachine.service.EmployeeService;

@Controller
@RequestMapping("/")
public class BranchController {

    @Autowired
    BranchService branchService;    
    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing branches.
     */

    @RequestMapping(value = {"/branches"}, method = RequestMethod.GET)
    public String listBranches(ModelMap model) {
        List<Branch> branches = branchService.findAllBranches();
        model.addAttribute("branches", branches);
        return "branch/allbranches";
    }
    /**
     * This method will provide the medium to add a new branch.
     * @param model
     * @return
     */
    @RequestMapping(value = { "branches/new" }, method = RequestMethod.GET)
    public String newBranch(ModelMap model) {
        Branch branch = new Branch();
        model.addAttribute("branch", branch);
        model.addAttribute("edit", false);
        return "branch/registration";
    }
    /*
     * This method will be called on form submission, handling POST request for
     * saving branch in database. It also validates the user input
     */
    @RequestMapping(value = { "branches/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Branch branch, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "branch/registration";
        }
        branchService.saveBranch(branch);

        model.addAttribute("success", "Branch " + branch.getBranchName() + " " + branch.getBranchLoc() + " registered successfully");
        return "branch/success";
    }

    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{branchId}-branch" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable int branchId, ModelMap model) {
        Branch branch = branchService.findById(branchId);
        model.addAttribute("branch", branch);
        model.addAttribute("edit", true);
        return "branch/registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating branch in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{branchId}-employee" }, method = RequestMethod.POST)
    public String updateBranch(@Valid Branch branch, BindingResult result,
            ModelMap model, @PathVariable int branchId) {

        if (result.hasErrors()) {
            return "employee/registration";
        }

        branchService.updateBranch(branch);

        model.addAttribute("success", "Branch " + branch.getBranchName() + " " + branch.getBranchLoc()	+ " updated successfully");
        return "branch/success";
    }


    /*
     * This method will delete an branch by it's Id value.
     */
    @RequestMapping(value = { "/delete-{branchId}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int branchId) {
        branchService.deleteBranchById(branchId);
        return "redirect:/branches";
    }

}
