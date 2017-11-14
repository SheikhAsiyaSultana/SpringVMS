package com.accion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accion.entity.Vendor;
import com.accion.repository.VendorRepository;


@Service
public class VendorService {
	@Autowired
	private VendorRepository venResp;
	
	public List<Vendor> findAll(){
		return venResp.findAll();
	}
	
	 public Vendor save(Vendor ven){
		 return venResp.save(ven);
	 }
	public void delete(Vendor ven){
		venResp.delete(ven);
	}
	public List<Vendor> findVendorByStatus(String status){
		return (List<Vendor>)venResp.findByStatus(status);
	}
	public List<Vendor> findByCategory(String category){
		return (List<Vendor>) venResp.findByCategory(category);
	}
	public Vendor findVendorByName(String name){
		return venResp.findByName(name);
	}
	public Vendor findVendorById(long id){
		return venResp.findById(id);
	}
	  
	
}
