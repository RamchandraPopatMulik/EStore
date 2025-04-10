package com.lcwd.electronic.store.ElectronicStore1.helper;

import com.lcwd.electronic.store.ElectronicStore1.dtos.PageableResponse;
import com.lcwd.electronic.store.ElectronicStore1.dtos.UserDto;
import com.lcwd.electronic.store.ElectronicStore1.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    public static <U,V> PageableResponse<V> getPageableResposne(Page<U> page,Class<V> type)
    {

        List<U> entity = page.getContent();
        List<V> dtoList = entity.stream().map(object -> new ModelMapper().map(object,type)).collect(Collectors.toList());
        PageableResponse<V> response = new  PageableResponse<V>();

        response.setContent(dtoList);
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setLastPage(page.isLast());
        return response;
    }

}
