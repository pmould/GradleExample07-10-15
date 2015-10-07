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
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    @Autowired
    BranchService branchService;    
    @Autowired
    MessageSource messageSource;

    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = { "/", "/employees" }, method = RequestMethod.GET)
    public String listEmployees(ModelMap model) {

        List<Employee> employees = employeeService.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/allemployees";
    }
    /**
     * This method will provide the medium to add a new employee.
     * @param model
     * @return
     */
    @RequestMapping(value = { "employees/new" }, method = RequestMethod.GET)
    public String newEmployee(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        model.addAttribute("edit", false);
        return "employee/registration";
    }
    

    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "employees/new" }, method = RequestMethod.POST)
    public String saveEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "employee/registration";
        }

        /*
         * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
         * and applying it on field [ssn] of Model class [Employee].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!employeeService.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "employee/registration";
        }

        employeeService.saveEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getFirstName() + " " + employee.getLastName() + " registered successfully");
        return "employee/success";
    }


    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
    public String editEmployee(@PathVariable String ssn, ModelMap model) {
        Employee employee = employeeService.findEmployeeBySsn(ssn);
        model.addAttribute("employee", employee);
        model.addAttribute("edit", true);
        return "employee/registration";
    }

    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
    public String updateEmployee(@Valid Employee employee, BindingResult result,
            ModelMap model, @PathVariable String ssn) {

        if (result.hasErrors()) {
            return "employee/registration";
        }

        if(!employeeService.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
            FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            result.addError(ssnError);
            return "employee/registration";
        }

        employeeService.updateEmployee(employee);

        model.addAttribute("success", "Employee " + employee.getFirstName() + " " + employee.getLastName()	+ " updated successfully");
        return "employee/success";
    }


    /*
     * This method will delete an employee by it's SSN value.
     */
    @RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String ssn) {
        employeeService.deleteEmployeeBySsn(ssn);
        return "redirect:/employees";
    }

}
