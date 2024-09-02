package in.achyuta.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.achyuta.entity.CitizenInfo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;

@Component
public class ExcelGenerator {
	public void generateExcel(ServletResponse response,List<CitizenInfo> plans) throws Exception{
		//Create workbook of Excel Where workbook is an interface and HSSFWorkbook is implemented class
				Workbook workbook=new HSSFWorkbook();
				//Creating Sheet on workbook
				Sheet sheet = workbook.createSheet();
				//Crating a row (Headings) at 0th index i.e 1st row as heading 
				Row headerRow = sheet.createRow(0);
				//set cell value for heading 
					headerRow.createCell(0).setCellValue("ID");
					headerRow.createCell(1).setCellValue("Holder name");
					headerRow.createCell(2).setCellValue("Plan name");
					headerRow.createCell(3).setCellValue("Plan status");
					headerRow.createCell(4).setCellValue("Start date");
					headerRow.createCell(5).setCellValue("End date");
					headerRow.createCell(6).setCellValue("Benfit amt");
					
				//After heading(0th) to copy data from 1st index	
					int dataRowIndex=1;
					
					for (CitizenInfo plan:plans) {
						//Creating dataRow for storing data After heading
						Row dataRow = sheet.createRow(dataRowIndex);
						//set cell value for data 
						dataRow.createCell(0).setCellValue(String.valueOf(plan.getId()));
						dataRow.createCell(1).setCellValue(plan.getName());
						dataRow.createCell(2).setCellValue(plan.getPlanName());
						dataRow.createCell(3).setCellValue(plan.getPlanStatus());
						if (null !=plan.getStartDate()) {
							dataRow.createCell(4).setCellValue(plan.getStartDate()+"");
						}else {
							dataRow.createCell(4).setCellValue("N/A");
						}
						if (null !=plan.getEndDate()) {
							dataRow.createCell(5).setCellValue(plan.getEndDate()+"");
						}else {
							dataRow.createCell(5).setCellValue("N/A");
						}
						if (null !=plan.getBenefitAmt()) {
							dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
						}else {
							dataRow.createCell(6).setCellValue("N/A");
						}
						dataRowIndex++;
					}
					//to create a excel file in local project folder(From this file we can send through mail as an attachment)
					FileOutputStream fos =new FileOutputStream(new File("plan.xls"));
					//to write the same data into this plan.xls file
					workbook.write(fos);
					//close the local file
					fos.close();
					
					//Get the outputStream from the response to browser
					 ServletOutputStream outputStream = response.getOutputStream();
					 //write the outputStream(data) to the  workbook
					 workbook.write(outputStream);
					 //close the work book
					 workbook.close();
	}

}
