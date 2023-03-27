package com.bms.springredisapp.response;

import com.bms.springredisapp.core.response.BasePageableResponse;
import com.bms.springredisapp.dto.EmployeeDto;

import java.io.Serializable;
import java.util.List;

public class EmployeeResponse extends BasePageableResponse implements Serializable {
    private List<EmployeeDto> items;

    public EmployeeResponse(Integer page, Integer size, Integer totalPages, Long totalItems,
                            Boolean hasNext, Boolean hasPrevious, List<EmployeeDto> items) {
        super(page, size, totalPages, totalItems, hasNext, hasPrevious);
        this.items = items;
    }

    public List<EmployeeDto> getItems() {
        return items;
    }
}
