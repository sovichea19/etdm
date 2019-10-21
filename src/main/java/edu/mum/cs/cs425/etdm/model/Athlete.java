package edu.mum.cs.cs425.etdm.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "Athlete")
public class Athlete {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long athleteId;
	
    @NotNull(message = "* SSN is required")
    @Digits(integer = 9, fraction = 0, message = "* SSN must be numeric; and a positive, integral value")
    @Column(name = "ssn", nullable = false, unique = true)
    private Long ssn;
    
    @NotNull(message = "* Full Name is required")
    @NotBlank(message = "* Full Name is required")
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;
    
    @NotNull(message = "* Date of birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    
    @NotNull(message = "* Date of Registration is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_registration", nullable = false)
    private LocalDate dateOfRegistration;
    
    @Column(name = "total_number_of_medals_won", nullable = false)
    private Integer totalNumberOfMedalsWon;
    
    @Column(name = "monthly_salary", nullable = false)
    private double monthlySalary;
    
    @Column(name = "email_address", nullable = true)
    private String emailAddress;
    
    public Athlete() {}

	public Athlete(long athleteId,
			@NotNull(message = "* SSN is required") @Digits(integer = 9, fraction = 0, message = "* SSN must be numeric; and a positive, integral value") Long ssn,
			@NotNull(message = "* Full Name is required") @NotBlank(message = "* Full Name is required") String fullName,
			String phoneNumber, @NotNull(message = "* Date of birth is required") LocalDate dateOfBirth,
			@NotNull(message = "* Date of Registration is required") LocalDate dateOfRegistration,
			Integer totalNumberOfMedalsWon, double monthlySalary, String emailAddress) {
		super();
		this.athleteId = athleteId;
		this.ssn = ssn;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.dateOfRegistration = dateOfRegistration;
		this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
		this.monthlySalary = monthlySalary;
		this.emailAddress = emailAddress;
	}

	public long getAthleteId() {
		return athleteId;
	}

	public void setAthleteId(long athleteId) {
		this.athleteId = athleteId;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public LocalDate getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(LocalDate dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Integer getTotalNumberOfMedalsWon() {
		return totalNumberOfMedalsWon;
	}

	public void setTotalNumberOfMedalsWon(Integer totalNumberOfMedalsWon) {
		this.totalNumberOfMedalsWon = totalNumberOfMedalsWon;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "Athlete [athleteId=" + athleteId + ", ssn=" + ssn + ", fullName=" + fullName + ", phoneNumber="
				+ phoneNumber + ", dateOfBirth=" + dateOfBirth + ", dateOfRegistration=" + dateOfRegistration
				+ ", totalNumberOfMedalsWon=" + totalNumberOfMedalsWon + ", monthlySalary=" + monthlySalary
				+ ", emailAddress=" + emailAddress + "]";
	}
	
	
    
    
    
    

}
