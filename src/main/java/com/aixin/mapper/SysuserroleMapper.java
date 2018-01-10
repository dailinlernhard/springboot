package com.aixin.mapper;

import com.aixin.model.Sysrole;
import com.aixin.model.Sysuserrole;
import com.aixin.model.SysuserroleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysuserroleMapper {
    int countByExample(SysuserroleExample example);

    int deleteByExample(SysuserroleExample example);

    int insert(Sysuserrole record);

    int insertSelective(Sysuserrole record);

    List<Sysuserrole> selectByExample(SysuserroleExample example);

    int updateByExampleSelective(@Param("record") Sysuserrole record, @Param("example") SysuserroleExample example);

    int updateByExample(@Param("record") Sysuserrole record, @Param("example") SysuserroleExample example);
    List<String> getRoleIdsByUserName(String userName);
}