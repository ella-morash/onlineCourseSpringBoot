package com.example.onlinecourse.dto;


import lombok.*;
import net.bytebuddy.asm.Advice;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseDTORequest {

    private String name;
    private String description;
    private String lecturer;
    private LocalDate startsOn;
    private LocalDate endsOn;
}
