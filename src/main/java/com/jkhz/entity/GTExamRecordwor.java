package com.jkhz.entity;


import lombok.Data;

import javax.persistence.Column;


@Data
public class GTExamRecordwor{
    private Integer questionId;
    private String questionMain;
    private Integer achievement;
    private String descriptName;
    private String anwersMain;
    private Integer anwersId;
    private String questionRemark;
    private String name;
    private String paperName;


}