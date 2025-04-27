package org.babi.Dtos.BidDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BidCreateDto {
    @NotBlank
    private String auctionId;
    @NotNull
    private double amount;
}
