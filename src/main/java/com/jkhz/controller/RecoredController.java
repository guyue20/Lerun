package com.jkhz.controller;


import com.jkhz.entity.GTExamRecord;
import com.jkhz.entity.GTExamRecordwor;
import com.jkhz.entity.GTExamRecordwors;
import com.jkhz.entity.Requestbodywor;
import com.jkhz.mapper.GTExamRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/recode")
public class RecoredController {
    @Autowired
    GTExamRecordMapper gtExamRecordMapper;
    @RequestMapping("/getlist")
    @ResponseBody
    @CrossOrigin
    public List<GTExamRecord>  getList(){
        List<GTExamRecord> gtExamRecords = gtExamRecordMapper.finall();
       return gtExamRecords;
    }
    @RequestMapping("/add")
    @ResponseBody
    @CrossOrigin
    public String addRecord(GTExamRecord record){
        int insert = gtExamRecordMapper.insertUseGeneratedKeys(record);
        if(insert>0){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @CrossOrigin
    public String deleteRecord(Integer id){
        int i = gtExamRecordMapper.deleteByPrimaryKey(id);
        if(i>0){
            return "success";
        }else{
            return "fail";
        }
    }
    @RequestMapping("/selectworall")
    @ResponseBody
    @CrossOrigin
    public List<GTExamRecordwors> selectworall(Requestbodywor wor){
        String wors=wor.getWor().substring(0,wor.getWor().length()-1);
        List<GTExamRecordwors> findworall = gtExamRecordMapper.findworall(wors);
        return findworall;
    }
}
