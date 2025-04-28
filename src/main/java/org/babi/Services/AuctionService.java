package org.babi.Services;

import org.babi.Dtos.AuctionDto.AuctionCreateDto;
import org.babi.Models.Auction;
import org.babi.Repositories.AuctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;
    private final ValidationService validationService;

    public AuctionService(AuctionRepository auctionRepository, ValidationService validationService) {
        this.auctionRepository = auctionRepository;
        this.validationService = validationService;
    }

    public Auction CreateAuction(AuctionCreateDto auctionCreateDto, String sellerId) {
        validationService.validateAuctionCreation(auctionCreateDto);
        Auction auction = new Auction();
        auction.setTitle(auctionCreateDto.getTitle());
        auction.setDescription(auctionCreateDto.getDescription());
        auction.setSellerId(sellerId);
        auction.setStartingPrice(auctionCreateDto.getStartingPrice());
        auction.setHighestBid(auctionCreateDto.getStartingPrice());
        auction.setStartTime(auctionCreateDto.getStartTime());
        auction.setEndTime(auctionCreateDto.getEndTime());
        auction.setActive(true);
        return auctionRepository.save(auction);
    }
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }
    public Auction getAuction(String auctionId) {
        return auctionRepository.findById(auctionId).orElseThrow();
    }
    public void deleteAuction(String auctionId) {
        Auction auction = auctionRepository.findById(auctionId).orElseThrow();
        auction.setActive(false);
        auctionRepository.delete(auction);
        auctionRepository.save(auction);
    }
}
