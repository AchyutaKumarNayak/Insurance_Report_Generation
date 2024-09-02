package in.achyuta.loader;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.achyuta.entity.CitizenInfo;
import in.achyuta.repo.CitizenInfoRepo;
@Component
public class DataLoader implements ApplicationRunner{
	
	@Autowired
	private CitizenInfoRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		CitizenInfo c1=new CitizenInfo();
		c1.setName("Achyuta");
		c1.setPhnNo("6370218171");
		c1.setPlanName("Food");
		c1.setPlanStatus("Approved");
		c1.setStartDate(LocalDate.now());
		c1.setEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		c1.setGender("Male");
		
		CitizenInfo c2=new CitizenInfo();
		c2.setName("Suman");
		c2.setPhnNo("7978218171");
		c2.setPlanName("Food");
		c2.setPlanStatus("Denied");
		c2.setGender("Male");
		c2.setDenialRsn("Employed");
		
		CitizenInfo c3= new  CitizenInfo();
		c3.setName("Rashmi");
		c3.setPhnNo("7978636181");
		c3.setPlanName("Food");
		c3.setPlanStatus("Terminated");
		c3.setStartDate(LocalDate.now().minusMonths(5));
		c3.setEndDate(LocalDate.now().plusMonths(1));
		c3.setBenefitAmt(5000.00);
		c3.setGender("Female");
		c3.setTerminationRsn("Govt job");
		c3.setTerminatedDate(LocalDate.now().minusMonths(1));
		
		CitizenInfo c4=new CitizenInfo();
		c4.setName("Anil");
		c4.setPhnNo("9140466024");
		c4.setPlanName("Cash");
		c4.setPlanStatus("Approved");
		c4.setStartDate(LocalDate.now());
		c4.setEndDate(LocalDate.now().plusMonths(5));
		c4.setBenefitAmt(7000.00);
		c4.setGender("Male");
		
		CitizenInfo c5=new CitizenInfo();
		c5.setName("Spr");
		c5.setPhnNo("7064634547");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Denied");
		c5.setGender("Female");
		c5.setDenialRsn("Invalid Document");
		
		CitizenInfo c6= new  CitizenInfo();
		c6.setName("Milan");
		c6.setPhnNo("9090453217");
		c6.setPlanName("Cash");
		c6.setPlanStatus("Terminated");
		c6.setStartDate(LocalDate.now().minusMonths(7));
		c6.setEndDate(LocalDate.now());
		c6.setBenefitAmt(5000.00);
		c6.setGender("Male");
		c6.setTerminationRsn("Govt job");
		c6.setTerminatedDate(LocalDate.now().minusMonths(2));
		
		
		CitizenInfo c7=new CitizenInfo();
		c7.setName("Muna");
		c7.setPhnNo("9665562345");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setStartDate(LocalDate.now());
		c7.setEndDate(LocalDate.now().plusMonths(10));
		c7.setBenefitAmt(15000.00);
		c7.setGender("Male");
		
		CitizenInfo c8=new CitizenInfo();
		c8.setName("Laxmi");
		c8.setPhnNo("8984431045");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setGender("Female");
		c8.setDenialRsn("Employed");
		
		CitizenInfo c9= new  CitizenInfo();
		c9.setName("Ashok");
		c9.setPhnNo("7854082364");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setStartDate(LocalDate.now().minusMonths(4));
		c9.setEndDate(LocalDate.now().plusMonths(6));
		c9.setBenefitAmt(7500.00);
		c9.setGender("Female");
		c9.setTerminationRsn("Govt job");
		c9.setTerminatedDate(LocalDate.now());
		
		
		CitizenInfo c10=new CitizenInfo();
		c10.setName("Bharat");
		c10.setPhnNo("9348900930");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setStartDate(LocalDate.now());
		c10.setEndDate(LocalDate.now().plusMonths(12));
		c10.setBenefitAmt(13000.00);
		c10.setGender("Male");
		
		CitizenInfo c11=new CitizenInfo();
		c11.setName("Rekha");
		c11.setPhnNo("6582147654");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setGender("Female");
		c11.setDenialRsn("Employed");
		
		CitizenInfo c12= new  CitizenInfo();
		c12.setName("SubhraJit");
		c12.setPhnNo("7847056321");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setStartDate(LocalDate.now().minusMonths(5));
		c12.setEndDate(LocalDate.now().plusMonths(3));
		c12.setBenefitAmt(5000.00);
		c12.setGender("Male");
		c12.setTerminationRsn("Govt job");
		c12.setTerminatedDate(LocalDate.now());
		
		List<CitizenInfo> asList = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		
		
		
		repo.saveAll(asList);
		
		
		
	}

}
