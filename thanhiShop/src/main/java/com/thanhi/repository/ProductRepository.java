package com.thanhi.repository;

import com.thanhi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select p.* from tb_products p join tb_sub_category tsc on p.sub_cate_id = tsc.id join tb_category tc on tsc.cate_id = tc.id where tc.id = ?1", nativeQuery = true)
    List<Product> findByCategoryId(Integer cid);
}