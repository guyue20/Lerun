package com.jkhz.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name ="GT_Exam_Record")
public class GTExamRecord implements Serializable {


    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;


    @Transient
    private String paperName;
    private Integer paperId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date recordsDate;

    private String takeTime;

    private Integer score;

    private String wrongIds;

    private String analysis;

    private String reverly;

    private Integer wrongs;

}