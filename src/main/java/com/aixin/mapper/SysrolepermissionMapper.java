package com.aixin.mapper;

import com.aixin.model.Sysrolepermission;
import com.aixin.model.SysrolepermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysrolepermissionMapper {
    int countByExample(SysrolepermissionExample example);

    int deleteByExample(SysrolepermissionExample example);

    int insert(Sysrolepermission record);

    int insertSelective(Sysrolepermission record);

    List<Sysrolepermission> selectByExample(SysrolepermissionExample example);

    int updateByExampleSelective(@Param("record") Sysrolepermission record, @Param("example") SysrolepermissionExample example);

    int updateByExample(@Param("record") Sysrolepermission record, @Param("example") SysrolepermissionExample example);
}