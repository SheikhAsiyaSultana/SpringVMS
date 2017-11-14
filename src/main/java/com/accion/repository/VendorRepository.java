package com.accion.repository;




import java.util.List;
//import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accion.entity.Vendor;
@Repository


public interface VendorRepository extends JpaRepository <Vendor, Integer> {
  public List<Vendor> findByStatus(@Param("status")String status);
  public Vendor findByName(@Param("name")String name);
  public Vendor findById(@Param("id")Long id);
  public List<Vendor> findByCategory(@Param("category")String category);
  public List<Vendor> findAll();
  @SuppressWarnings("unchecked")
  public Vendor save(Vendor ven);
  public void delete(Vendor ven);
  
  
}
