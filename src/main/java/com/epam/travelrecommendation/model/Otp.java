package com.epam.travelrecommendation.model;

import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class Otp {
    private String email;
    private String otp;
    private LocalDateTime expiry;

}
