package com.example.project.bookmyshowbackend.converter;

import com.example.project.bookmyshowbackend.Model.ShowEntity;
import com.example.project.bookmyshowbackend.dto.ShowDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {
    public static ShowEntity convertDtoToEntity(ShowDto showDto){
        return ShowEntity.builder().showDate(showDto.getShowDate()).showTime(showDto.getShowTime()).build();
    }

    public static ShowDto convertEntityToDto(ShowEntity showEntity){
        return ShowDto.builder().showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime()).build();
    }
}
