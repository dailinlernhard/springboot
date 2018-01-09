package com.aixin.mapper;

import com.aixin.model.Sysrole;
import com.aixin.model.SysroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysroleMapper {
    int countByExample(SysroleExample example);

    int deleteByExample(SysroleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    List<Sysrole> selectByExample(SysroleExample example);

    Sysrole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Sysrole record, @Param("example") SysroleExample example);

    int updateByExample(@Param("record") Sysrole record, @Param("example") SysroleExample example);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);
}