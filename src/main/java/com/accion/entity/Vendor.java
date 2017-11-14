
package com.accion.entity;



import java.io.File;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.springframework.web.multipart.MultipartFile;



@Entity
@Table(name="vendors")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "vendor_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="category")
	private String category;
	 
	@Column(name="start_date")
	private  Date startDate;
	
	@Column(name="end_date")
	private  Date endDate;
	
	@Column(name="resource_count")
	private  int resourceCount;
	
	@Column(name="email_id")
	private  String emailId;
	
	@Column(name="status")
	private  String status;
	
	@Column(name="address_line1")
	private  String address1;
	
	@Column(name="address_line2")
	private  String address2;
	
	@Column(name="contact_number")
	private  Long number;
	
	@Column(name="files")
	private  File files;
	
	@Column(name="comment")
	private  String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public File getFiles() {
		return files;
	}

	public void setFiles(File files) {
		this.files = files;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Vendor(Long id, String name, String category, Date startDate, Date endDate, int resourceCount,
			String emailId, String status, String address1, String address2, Long number, File files,
			String comment) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceCount = resourceCount;
		this.emailId = emailId;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.number = number;
		this.files = files;
		this.comment = comment;
	}

	public Vendor(String name, String category, Date startDate, Date endDate, int resourceCount, String emailId,
			String status, String address1, String address2, Long number, File files, String comment) {
		this.name = name;
		this.category = category;
		this.startDate = startDate;
		this.endDate = endDate;
		this.resourceCount = resourceCount;
		this.emailId = emailId;
		this.status = status;
		this.address1 = address1;
		this.address2 = address2;
		this.number = number;
		this.files = files;
		this.comment = comment;
	}

	public Vendor() {
	}
	
	
	
	
	

	
	 
}

