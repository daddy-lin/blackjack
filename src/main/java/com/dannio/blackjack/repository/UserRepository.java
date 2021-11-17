package com.dannio.blackjack.repository;

import com.dannio.blackjack.entry.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
