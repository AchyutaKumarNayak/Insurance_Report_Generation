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
		
        Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(new File("plans.pdf")));
		
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
		
		PdfPTable table = new PdfPTable(8);
		
	    table.setSpacingBefore(5);
		
		table.addCell("Id");
		table.addCell("Holder Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Gender");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benefit Amt");
		
		
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
		
		document.add(table);
		
		document.close();
		
	}

}
