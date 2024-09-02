package in.achyuta.service;

import java.util.List;

import in.achyuta.binding.SearchRequest;
import in.achyuta.entity.CitizenInfo;
import jakarta.servlet.http.HttpServletResponse;


public interface CitizenInfoService {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<String> getGender();
	
	public List<CitizenInfo> search(SearchRequest request);
	
	public boolean exportPdf(HttpServletResponse response) throws Exception;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;

}
