package com.medicalclinic.api.repositories;

import com.medicalclinic.api.domain.address.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<Address, Long> {

//    @Query("SELECT new com.api.carlossousa.ecommerce.model.product.ProductMinDTO(p.id, p.title, p.shortDescription, " +
//            "p.price, p.quantity, p.photoUrl, d) " +
//            "FROM Product p " +
//            "LEFT JOIN p.deal d " +
//            "INNER JOIN p.categories c " +
//            "WHERE UPPER(p.title) LIKE UPPER(CONCAT('%', :name, '%')) " +
//            "AND (:category = '' OR c.category = :category)")
//    Page<ProductMinDTO> searchByNameProduct(@Param("name") String name, @Param("category") String category, Pageable pageable);
}
