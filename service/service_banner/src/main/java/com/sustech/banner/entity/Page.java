package com.sustech.banner.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Page {
    private Integer currentPage;
    private Integer limit;
    private Integer totalNum;
    private List<String> urls = new ArrayList<>();

    public void addURL(String url){
        urls.add(url);
    }
}
