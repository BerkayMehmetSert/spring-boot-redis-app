package com.bms.springredisapp.core.response;

public class BasePageableResponse {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Long totalItems;
    private Boolean hasNext;
    private Boolean hasPrevious;

    public BasePageableResponse(Integer page, Integer size, Integer totalPages, Long totalItems,
                                Boolean hasNext, Boolean hasPrevious) {
        this.page = page;
        this.size = size;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public Boolean getHasPrevious() {
        return hasPrevious;
    }

}
