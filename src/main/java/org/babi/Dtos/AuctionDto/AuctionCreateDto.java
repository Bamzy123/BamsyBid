package org.babi.Dtos.AuctionDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AuctionCreateDto {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private double startingPrice;
    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
}
