package com.parkdt.tml.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.parkdt.tml.taskService")
@EnableScheduling
public class TaskScheduleConfig {



}
