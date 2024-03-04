package com.lekkss.database.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper moduleMapper = new ModelMapper();
        moduleMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return moduleMapper;
    }
}
