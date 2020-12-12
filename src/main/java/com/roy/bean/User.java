package com.roy.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description：
 * author：dingyawu
 * date：created in 17:08 2020-12-12
 * history:
 */
@Data
@TableName(value = "t_user")  //指定对应表
public class User {
		private Long userId;
		private String username;
		private String ustatus;
}

