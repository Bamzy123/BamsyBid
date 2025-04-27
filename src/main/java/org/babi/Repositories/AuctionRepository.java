package org.babi.Repositories;

import org.babi.Models.Auction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuctionRepository extends MongoRepository<Auction, String> {
    List<Auction> findByActive(boolean active);
}
