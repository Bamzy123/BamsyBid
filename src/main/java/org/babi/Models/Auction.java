package org.babi.Models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "auctions")
public class Auction {
    @Id
    private String id;
    private String title;
    private String description;
    private String sellerId;
    private double startingPrice = 100000;
    private double highestBid = 100000;
    private String highestBidderId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean active = true;
}
