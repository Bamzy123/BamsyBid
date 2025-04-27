package org.babi.Services;

import org.babi.Dtos.AuctionDto.AuctionCreateDto;
import org.babi.Dtos.BidDto.BidCreateDto;
import org.babi.Dtos.UserDto.UserRegisterDto;
import org.babi.Exceptions.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ValidationService {
    public void validateUserRegister(UserRegisterDto userRegisterDto) {
        if(userRegisterDto.getUsername().length() < 3 || userRegisterDto.getUsername().length() > 16) {
            throw new UserNameToShortAndLongException("username should be between 1 to 16");
        }
        if(!List.of("Admin", "Bidder", "Seller").contains(userRegisterDto.getRole().toUpperCase())) {
            throw new InvalidRoleException("Invalid role");
        }
    }
    public void validateAuctionCreation(AuctionCreateDto auctionCreateDto) {
        if (auctionCreateDto.getStartingPrice() < 100000) {
            throw new InvalidStartingPriceException("Starting price must be at least 100,000");
        }
        if (auctionCreateDto.getEndTime().isBefore(auctionCreateDto.getStartTime())) {
            throw new EndTimeMustBeAfterStartTimeException("End time must be after start time");
        }
    }
    public void validateBid(BidCreateDto bidCreateDto, double minAmount, boolean auctionActive,
                            LocalDateTime now, LocalDateTime start, LocalDateTime end) {
        if(!auctionActive) {
            throw new AuctionNotActiveException("Auction is not active");
        }
        if (now.isBefore(start) || now.isAfter(end)) {
            throw new BiddingNotAllowAtThisTimeException("Bidding is not allowed at this time");
        }
        if(bidCreateDto.getAmount() <= minAmount) {
            throw new BidMustBeHigherException("Bid must be higher than current highest bid");
        }
    }
}
