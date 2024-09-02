package in.achyuta.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {
	
	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;

}
