package org.babi.Repositories;

import org.babi.Models.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BidRepository extends MongoRepository<Bid, String> {
    List<Bid> findByAuctionId(String auctionId);
}
