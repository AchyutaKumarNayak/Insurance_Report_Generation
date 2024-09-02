package in.achyuta.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.achyuta.entity.CitizenInfo;
@Repository
public interface CitizenInfoRepo extends JpaRepository<CitizenInfo, Integer> {
	
	@Query("select distinct(planName) from CitizenInfo")
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from CitizenInfo")
	public List<String> getPlanStatus();
	
	@Query("select distinct(gender) from CitizenInfo")
	public List<String> getGender();

}
