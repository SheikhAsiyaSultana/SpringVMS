package com.accion.controller;

import java.util.Arrays;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accion.entity.Vendor;
import com.accion.entity.VendorDto;
import com.accion.service.VendorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping(value="/vendor")
public class VendorController {
	
	final static Logger logger = Logger.getLogger(VendorController.class);
	@Autowired
	private VendorService vs;
   
	@RequestMapping(value="/add",method=RequestMethod.POST,produces="application/json")
	public ResponseEntity<Vendor> add(@RequestBody Vendor ven){
			vs.save(ven);
			logger.debug("Added: " + ven);
			return new ResponseEntity<Vendor>(ven,HttpStatus.CREATED);
			
		}
	
	@PutMapping("/app")
	@ResponseBody
	public ResponseEntity<Void> updateVendorById(@RequestBody Vendor ven,@RequestParam("id")long id){
	Vendor vendor=vs.findVendorById(id);
	if(vendor == null){
		logger.debug("Vendor with id " + ven.getId() + " does not exists");
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	else{
		vs.save(ven);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	}
	
	@GetMapping("/app")
	public ResponseEntity<VendorDto> getVendorIdAndName(@RequestParam("name") String name) {
		Vendor ven1 = vs.findVendorByName(name);
		VendorDto vd=new VendorDto();
		vd.setId(ven1.getId());
		vd.setName(ven1.getName());
		
		logger.debug("Found Vendor:: " + ven1);
		return new ResponseEntity<VendorDto>(vd, HttpStatus.OK);
	}
	
	@GetMapping("/app/name")
	public ResponseEntity<Object> getVendorByName(@RequestParam("name") String name) {
		Vendor ven1 = vs.findVendorByName(name);
		if (ven1 == null) {
			logger.debug("Vendor with name " + name + " does not exists");
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found Vendor:: " + ven1);
		return new ResponseEntity<Object>(ven1, HttpStatus.OK);
	}
	
	@GetMapping("/app/status")
	public ResponseEntity<List<Vendor>> getVendorByStatus(@RequestParam("status") String status) {
		List<Vendor> ven1 = (List<Vendor>)vs.findVendorByStatus(status);
		if (ven1.isEmpty()) {
			logger.debug("Vendors with status " + status + " does not exists");
			return new ResponseEntity<List<Vendor>>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found " + ven1.size() + " vendors");
		logger.debug(ven1);
		logger.debug(Arrays.toString(ven1.toArray()));
		return new ResponseEntity<List<Vendor>>(ven1, HttpStatus.OK);
	}
	
	@GetMapping("/app/category")
	public ResponseEntity<List<Vendor>> getVendorByCategory(@RequestParam("category") String category) {
		List<Vendor> vendorlist = (List<Vendor>) vs.findByCategory(category);
		
		if (vendorlist.isEmpty()) {
			logger.debug("Vendors with " + category + " does not exists");
			return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + vendorlist.size() + " vendors");
		logger.debug(vendorlist);
		logger.debug(Arrays.toString(vendorlist.toArray()));
		return new ResponseEntity<List<Vendor>>(vendorlist, HttpStatus.OK);
	}
	
	@GetMapping("/app/id")
	public ResponseEntity<Vendor> getVendorById(@RequestParam("id") long id) {
		Vendor ven = vs.findVendorById(id);
		
		if (ven== null) {
			logger.debug("Vendor with id " + id + " does not exists");
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
		else{
	     logger.debug("Found Vendor with id " + id + " id");
		return new ResponseEntity<Vendor>(ven, HttpStatus.OK);
		}
		}
	
	@GetMapping("/allVendors")
	public ResponseEntity<List<Vendor>> getAllVendors() {
		List<Vendor> vendors = vs.findAll();
		if (vendors.isEmpty()) {
			logger.debug("Vendors does not exists");
			return new ResponseEntity<List<Vendor>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + vendors.size() + " vendors");
		logger.debug(vendors);
		logger.debug(Arrays.toString(vendors.toArray()));
		return new ResponseEntity<List<Vendor>>(vendors, HttpStatus.OK);
	}
   
	@DeleteMapping("/app/byName")
	public ResponseEntity<Void> deleteVendor(@RequestParam("name") String name) {
		Vendor v1 = vs.findVendorByName(name);
		if (v1 == null) {
			logger.debug("Vendor with name " + name + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			vs.delete(v1);
			logger.debug("Vendor with name" + name + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
