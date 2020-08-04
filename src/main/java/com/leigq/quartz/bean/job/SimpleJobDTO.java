package com.leigq.quartz.bean.job;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 简单任务 DTO，用户接受 执行任务、暂停任务、恢复任务  请求参数
 * <br/>
 *
 * @author ：leigq
 * @date ：2019/7/22 16:53
 */
@Data
public class SimpleJobDTO {

	/**
	 * 任务全类名
	 */
	@NotEmpty(message = "全类名不能为空！")
	private String jobClassName;

	/**
	 * 任务组名
	 */
	@NotEmpty(message = "任务分组不能为空！")
	private String jobGroupName;

	/**
	 * 密钥
	 */
	@NotEmpty(message = "密钥不能为空！")
	private String secretKey;


}