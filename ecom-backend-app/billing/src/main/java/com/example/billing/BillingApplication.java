package com.example.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.Versioned;

import java.util.Map;

@SpringBootApplication
public class BillingApplication {
	@Autowired
    private VaultTemplate vaultTemplate;
	public static void main(String[] args) {
		SpringApplication.run(BillingApplication.class, args);
	}
	@Bean
     CommandLineRunner start(){
		return args -> {
			Versioned.Metadata rep= vaultTemplate
					.opsForVersionedKeyValue("secret")
					.put("pairKey", Map.of("prvKey","123","pubKey","222"));
		};
		//donc en a partager ces key a chaque microservice pour connecter a vault et recuperer les secret
	 }
}
