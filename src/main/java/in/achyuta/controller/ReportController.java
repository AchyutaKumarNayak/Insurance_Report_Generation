package in.achyuta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.achyuta.binding.SearchRequest;
import in.achyuta.service.CitizenInfoService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {
	
	@Autowired
	private CitizenInfoService service;
	
	@GetMapping("/pdf")
    public void exportPdf(HttpServletResponse response) throws Exception {
        // Set the content type to application/pdf to indicate a file download
        response.setContentType("application/pdf");
        
        // Set the Content-Disposition header to tell the browser to treat it as an attachment
        response.setHeader("Content-Disposition", "attachment; filename=\"plan.pdf\"");

        // Call the service method that generates the Excel file and writes it to the response
        service.exportPdf(response);
	}
	
	@GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws Exception {
        // Set the content type to application/octet-stream to indicate a file download
        response.setContentType("application/octet-stream");
        
        // Set the Content-Disposition header to tell the browser to treat it as an attachment
        response.setHeader("Content-Disposition", "attachment; filename=\"plan.xls\"");

        // Call the service method that generates the Excel file and writes it to the response
        service.exportExcel(response);
	}
	//This method is used for handle the search request calling by index(Model model)
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search,Model model) {
		//in the above @modelAttribute is used to store the input value from UI which is the type of SearchRequest.
		System.out.println(search);
		//while requesting a GetMapping and PostMapping ,and response should be in one page
		//there is problem to get response in same page to resolve this we have to take init() method 
		init(model);
		//This method add the model obj in (key,value pair) where key is getPlans and 
		//Further use in index.jsp to iterate the data in c:foreach loop
		//items="${getPlans}"  in index.jsp
		model.addAttribute("getPlans", service.search(search));
		//Here by passing the @modalAttribute value as parameter in line 30 to restore our dropdown with user input from UI
		return "index";
	}
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("search", new SearchRequest());
		//while requesting a GetMapping and PostMapping ,and response should be in one page
		//there is problem to get response in same page to resolve this we have to take init() method 
		init(model);
		return "index";
	}

	private void init(Model model) {
		//In line no 43 by it in the init() and always create new obj for every req so the SearchRequest 
		//fields are assigned with null hence it do not hold the dropdown value for every req this can be solved in line 21.
	//	model.addAttribute("search", new SearchRequest());//creating the form binding obj and send to Ui
		model.addAttribute("plans", service.getPlanNames());//Get the plan names from service and send to UI
		model.addAttribute("status", service.getPlanStatus());//Get the plan names from service and send to UI
		model.addAttribute("gender", service.getGender());
	}

}
