package com.example.project.bookmyshowbackend.dto.EntryRequest;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserEntryDto {

    String name;
    String mobNo;
}
