package in.achyuta.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.achyuta.entity.CitizenInfo;
import jakarta.servlet.ServletResponse;

@Component
public class PdfGenerator {
	public void generatePdf(ServletResponse response,List<CitizenInfo> plans) throws Exception {
		//Create document object for pdf of paper size A4
        Document document=new Document(PageSize.A4);
		//Create PdfWriter object for doc and response from browser
		PdfWriter.getInstance(document, response.getOutputStream());
		//Create PdfWriter object for doc and create one file in local
		PdfWriter.getInstance(document, new FileOutputStream(new File("plans.pdf")));
		//open the document for writing
		document.open();
		
		// Creating font
	    // Setting font style and size
	    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    fontTiltle.setSize(20);
	    // Creating paragraph
	    Paragraph heading = new Paragraph("Citizen's Plan", fontTiltle);
	    // Aligning the paragraph in the document
	    heading.setAlignment(Paragraph.ALIGN_CENTER);
	    
	    // Adding the created paragraph in the document
		document.add(heading);
		//Creating PdfPTable object with required no. of columns
		PdfPTable table = new PdfPTable(8);
		//padding from header
	    table.setSpacingBefore(5);
		//Add headers
		table.addCell("Id");
		table.addCell("Holder Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Gender");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amt");
		
		//fetch the data from ArrayList and store this in corresponding column
		for(CitizenInfo plan:plans) {
			
			table.addCell(String.valueOf(plan.getId()));
			table.addCell(plan.getName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getGender());
			if (null !=plan.getStartDate()) {
				table.addCell(plan.getStartDate()+"");
			}else {
			    table.addCell("N/A");
			}
			if (null !=plan.getStartDate()) {
				table.addCell(plan.getEndDate()+"");
			}else {
			    table.addCell("N/A");
			}
			if (null !=plan.getStartDate()) {
				table.addCell(String.valueOf(plan.getBenefitAmt()));
			}else {
			    table.addCell("N/A");
			}
			
		}
		
		//Add the table in document object 
		document.add(table);
		//Then close the document
		document.close();
		
	}

}
