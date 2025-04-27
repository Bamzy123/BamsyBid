package org.babi.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Bid {
    @Id
    private String id;
    private String auctionId;
    private String bidderId;
    private double amount;
    private LocalDateTime bidTime;
}
