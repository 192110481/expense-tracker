package com.expensetracker.config;

import com.expensetracker.entity.Role;
import com.expensetracker.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.expensetracker.entity.Category;
import com.expensetracker.repository.CategoryRepository;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadData(RoleRepository roleRepository, CategoryRepository categoryRepository) {
        return args -> {

            if (roleRepository.findByRoleName("ADMIN").isEmpty()) {
                roleRepository.save(new Role("ADMIN"));
            }

            if (roleRepository.findByRoleName("USER").isEmpty()) {
                roleRepository.save(new Role("USER"));
            }

            if(categoryRepository.count() == 0){
                categoryRepository.save(new Category("Food"));
                categoryRepository.save(new Category("Travel"));
                categoryRepository.save(new Category("Shopping"));
                categoryRepository.save(new Category("Bills"));
                categoryRepository.save(new Category("Salary"));
            }
        };
    }
}