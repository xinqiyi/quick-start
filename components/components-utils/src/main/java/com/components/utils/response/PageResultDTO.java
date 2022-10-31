package com.components.utils.response;

import com.google.common.collect.Lists;

import java.util.List;

public class PageResultDTO<T> {
    private List<T> items;
    private Long count;

    public PageResultDTO() {
    }

    public PageResultDTO(List<T> items, Long count) {
        this.items = items;
        this.count = count;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public static <T> PageResultDTOBuilder<T> builder() {
        return new PageResultDTOBuilder<T>();
    }

    public static <T> PageResultDTO<T> emptyResult() {
        return new PageResultDTO<T>(Lists.newArrayList(), 0L);
    }

    public static class PageResultDTOBuilder<T> {
        private List<T> items;
        private Long count;

        private PageResultDTOBuilder(){}

        public PageResultDTOBuilder items(List<T> items) {
            this.items = items;
            return this;
        }

        public PageResultDTOBuilder count(Long count) {
            this.count = count;
            return this;
        }

        public PageResultDTO build() {
            return new PageResultDTO(this.items, this.count);
        }
    }
}
