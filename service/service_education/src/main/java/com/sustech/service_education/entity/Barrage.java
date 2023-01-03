package com.sustech.service_education.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Barrage {

    private int id;
    private String text;
    private float time;
    private int session_id;
}
