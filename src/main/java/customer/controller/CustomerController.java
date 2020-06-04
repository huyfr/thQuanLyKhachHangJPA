package customer.controller;

import customer.model.Customer;
import customer.service.CustomerService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    private static Logger logger = LogManager.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create_customer", method = RequestMethod.GET)
    public ModelAndView showCreateForm() {
        logger.trace("Vao showCreateForm");
        ModelAndView createForm = new ModelAndView("index");
        createForm.addObject("customer", new Customer());
        logger.trace("Thoat showCreateForm");
        return createForm;
    }

    @RequestMapping(value = "/create_customer", method = RequestMethod.POST)
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView result = new ModelAndView("index");
        result.addObject("customer", new Customer());
        result.addObject("message", "New customer created successfully");
        return result;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView loadListCustomer() {
        List<Customer> customers =  customerService.findAll();
        ModelAndView loadListCustomer = new ModelAndView("list");
        loadListCustomer.addObject("customers", customers);
        return loadListCustomer;
    }

    @RequestMapping(value = "/edit_customer/{id}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("id") Long id) {
        Customer customer = customerService.findById(id);
        if (customer != null) {
            ModelAndView editForm = new ModelAndView("edit");
            editForm.addObject("customer", customer);
            return editForm;
        } else {
            return new ModelAndView("error404");
        }
    }

    @RequestMapping(value = "/edit_customer", method = RequestMethod.POST)
    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete_customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Customer customer = customerService.findById(id);
        if(customer != null) {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("customer", customer);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete_customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
