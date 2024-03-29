package com.example.springshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BucketDTO {
        private int amountProducts;
        private Double sum;
        private List<BucketDetailDTO> bucketDetails = new ArrayList<>();

        public void aggregate(){
            this.amountProducts = bucketDetails.size();
            this.sum=bucketDetails.stream()
                    .map(BucketDetailDTO::getSum)
                    .mapToDouble(Double::doubleValue)
                    .sum();
        }
}
