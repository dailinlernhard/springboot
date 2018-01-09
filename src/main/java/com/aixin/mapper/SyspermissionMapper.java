package com.aixin.mapper;

import com.aixin.model.Syspermission;
import com.aixin.model.SyspermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyspermissionMapper {
    int countByExample(SyspermissionExample example);

    int deleteByExample(SyspermissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Syspermission record);

    int insertSelective(Syspermission record);

    List<Syspermission> selectByExample(SyspermissionExample example);

    Syspermission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Syspermission record, @Param("example") SyspermissionExample example);

    int updateByExample(@Param("record") Syspermission record, @Param("example") SyspermissionExample example);

    int updateByPrimaryKeySelective(Syspermission record);

    int updateByPrimaryKey(Syspermission record);
}