package kh.com.sbilhbank.paging.repository;

import kh.com.sbilhbank.paging.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
