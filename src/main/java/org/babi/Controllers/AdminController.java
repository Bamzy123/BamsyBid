package org.babi.Controllers;

import org.babi.Models.Auction;
import org.babi.Models.User;
import org.babi.Services.AuctionService;
import org.babi.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final AuctionService auctionService;

    public AdminController(UserService userService, AuctionService auctionService) {
        this.userService = userService;
        this.auctionService = auctionService;
    }

    @GetMapping("/auctions")
    public List<Auction> getAllAuctions() {
        return auctionService.getAllAuctions();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/user/{id}/ban")
    public void banUser(@PathVariable String id) {
        userService.banUser(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}

