package com.components.utils.request;


import com.components.utils.PageDTO;

/**
 * Author : fanjun
 * Date   : 2018/10/20
 * Desc   :
 */
public class PageRequest<T> extends DataRequest<T> {
    private PageDTO page;

    public PageRequest() {
    }

    public PageRequest(T param, PageDTO page) {
        super(param);
        this.page = page;
    }

    public PageDTO getPage() {
        return page;
    }

    public void setPage(PageDTO page) {
        this.page = page;
    }
}
