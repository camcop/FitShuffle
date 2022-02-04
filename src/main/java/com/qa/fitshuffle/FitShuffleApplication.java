package com.qa.fitshuffle;

import com.qa.fitshuffle.domain.Item;
import com.qa.fitshuffle.repo.ItemRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class FitShuffleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitShuffleApplication.class, args);
	}



	}