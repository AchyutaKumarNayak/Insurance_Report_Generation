package in.achyuta.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CITIZEN_INFO")
public class CitizenInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "CITIZEN_ID")
	private Integer id;
	@Column(name = "CITIZEN_NAME")
	private String name;
	@Column(name = "CITIZEN_MOBILE")
	private String phnNo;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
	@Column(name = "BENEFIT_AMOUNT")
	private Double benefitAmt;
	@Column(name = "DENEIAL_REASON")
	private String denialRsn;
	@Column(name = "TERMINATE_DATE")
	private LocalDate terminatedDate;
	@Column(name = "TERMINATION_REASON")
	private String terminationRsn;

}
