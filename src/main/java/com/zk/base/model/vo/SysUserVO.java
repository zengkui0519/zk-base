package com.zk.base.model.vo;

import com.zk.base.model.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserVO extends SysUser {

    List<Integer> roleIdList;

}