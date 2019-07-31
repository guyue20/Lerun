package com.jkhz.mapper;

import com.jkhz.entity.GTExamRecord;
import com.jkhz.entity.GTExamRecordwor;
import com.jkhz.entity.GTExamRecordwors;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

public interface GTExamRecordMapper extends Mapper<GTExamRecord>, MySqlMapper<GTExamRecord> {
    @Select("SELECT r.id,r.paper_id,r.records_date,r.take_time,r.score,r.wrong_ids,r.analysis,r.reverly,r.wrongs,p.paper_name FROM GT_Exam_Record r left join GT_Exam_Paper  p on p.paper_id=r.paper_id")
    public List<GTExamRecord> finall();
    @Select("select  t.question_id,\n" +
            "        t.question_main,\n" +
            "        t.achievement,\n" +
            "\t\ttd.descript_name,\n" +
            "        tc.anwers_main,\n" +
            "\t\tta.anwers_id,\n" +
            "\t\tta.question_remark as questionremark,\n" +
            "\t\ttcon.name,\n" +
            "\t\ttp.paper_name\n" +
            "FROM GT_Exam_Questionsbank t left join GT_Exam_Descript td on t.describe_id=td.descript_id \n" +
            "left join GT_Exam_Choice tc on t.question_id=tc.question_id\n" +
            "left join GT_Exam_AI ta on  t.question_id=ta.question_id\n" +
            "left join GT_Exam_Course tcon on tcon.subject_id=t.subject_id\n" +
            "left join GT_Exam_Record tr on tr.wrong_ids=#{wors}\n" +
            "left join GT_Exam_Paper tp on tr.paper_id=tp.paper_id where t.question_id in(${wrdss})")
    public List<GTExamRecordwors> findworall(@Param("wors") String wors,@Param("wrdss") String wrdss);
}