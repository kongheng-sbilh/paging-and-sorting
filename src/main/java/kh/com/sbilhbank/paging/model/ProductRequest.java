package kh.com.sbilhbank.paging.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private Double price;
}
