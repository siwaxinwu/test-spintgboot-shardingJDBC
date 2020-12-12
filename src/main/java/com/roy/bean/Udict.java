package com.roy.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * description：
 * author：dingyawu
 * date：created in 19:04 2020-12-12
 * history:
 */
@Data
@TableName(value = "t_udict")
public class Udict {

		private Long dictid;

		private String ustatus;

		private String uvalue;

}
