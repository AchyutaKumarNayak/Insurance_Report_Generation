package in.achyuta.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.achyuta.binding.SearchRequest;
import in.achyuta.entity.CitizenInfo;
import in.achyuta.repo.CitizenInfoRepo;
import in.achyuta.utils.EmailUtils;
import in.achyuta.utils.ExcelGenerator;
import in.achyuta.utils.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class CitizenInfoServiceImpl implements CitizenInfoService {
	
	@Autowired
	private CitizenInfoRepo repository;
	
	@Autowired
	ExcelGenerator generatorExcel;
	
	@Autowired
	PdfGenerator generatorPdf;
	
	@Autowired
	EmailUtils email;

	@Override
	public List<String> getPlanNames() {
		return repository.getPlanName();
		
	//get the planNames from Repository and send to Controller
	}

	@Override
	public List<String> getPlanStatus() {
		
		return repository.getPlanStatus();//get the planStatus from Repository and send to Controller
	}
	@Override
	public List<String> getGender() {
		
		return repository.getGender();
	}
	@Override
	public List<CitizenInfo> search(SearchRequest request) {
		//For dynamic Query(Or adding Filter to search button) we have to use Query By Example of dataJpa interface
		//For this 1st we have to create entity Obj
		CitizenInfo entity=new CitizenInfo();
		//After creating we have to copy all the data from binding class(SearchRequest)
		//to entity class
		
		
	//	BeanUtils.copyProperties(request, entity);//here request is source(binding class) and entity is target(Entity class)
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
		    entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
		    entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate=request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(startDate, formatter);
			entity.setStartDate(date);
		}
		if(null!=request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate=request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(endDate, formatter);
			entity.setStartDate(date);
		}
		
		//Creating Example object using entity 
		Example<CitizenInfo> of = Example.of(entity);
		//Pass the Example obj (of) to find all method to add filter corresponds to UI
		return repository.findAll(of);
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		//Retrieve all the records from the DB and
		List<CitizenInfo> plans = repository.findAll();
		//send the data to the generateExcel() method by passing as argument with Servlet response
		generatorExcel.generateExcel(response, plans);
		
		String subject="Sending msg to me";
		String body="<h1> i love u </h1>";
		String to="achyutakumarnayak1234@gmail.com";
		File f=new File("plan.xls");
		email.sendMail(subject, body, to,f);
		f.delete();
		return true;
	}
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		List<CitizenInfo> plans = repository.findAll();
		generatorPdf.generatePdf(response, plans);
		
		String subject="Sending msg to me";
		String body="<h1> i love u </h1>";
		String to="achyutakumarnayak1234@gmail.com";
		File f=new File("plans.pdf");
		email.sendMail(subject, body, to,f);
		f.delete();
		return true;
	}

}
