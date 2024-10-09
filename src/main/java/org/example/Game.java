package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Game {
    private String title;
    private String platform;
    private Integer year;
}
