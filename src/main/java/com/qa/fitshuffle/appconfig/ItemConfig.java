package com.qa.fitshuffle.appconfig;

import com.qa.fitshuffle.domain.Item;
import com.qa.fitshuffle.repo.ItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Configuration
public class ItemConfig {

    @Bean
    @Scope("singleton")
    CommandLineRunner commandLineRunner(
            ItemRepo repo) {
        return args -> {
            Item uniqlo = new Item(
                    1L,
                    "Uniqlo hoodie",
                    "Top",
                    "Hoodie",
                    "Uniqlo",
                    "Pink"
            );
            Item sunspel = new Item(
                    2L,
                    "Sunspel hoodie",
                    "Top",
                    "Hoodie",
                    "Sunspel",
                    "Indigo"
            );
            repo.saveAll(List.of(uniqlo, sunspel)
            );
        };

    }
}
