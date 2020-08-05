package com.leigq.quartz.task;

import com.leigq.quartz.bean.job.TaskExecute;
import com.leigq.quartz.service.QuartzJobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * 最简单的Quartz
 * <p>
 * 创建人：LeiGQ <br>
 * 创建时间：2019-03-05 16:28 <br>
 * <p>
 * 修改人： <br>
 * 修改时间： <br>
 * 修改备注： <br>
 * </p>
 */
@Slf4j
@Component
public class HelloQuartz2 extends TaskExecute implements Serializable {

    // 实现序列化接口、防止重启应用出现quartz Couldn't retrieve job because a required class was not found 的问题
    private static final long serialVersionUID = 8969855105016200770L;

    @Autowired
    private QuartzJobService quartzJobService;

    // */2 * * * * ?
    @Override
    public void execute(Map<String, Object> dataMap) {
        log.warn(">>>>>>>>>Hello Quartz start!");
        final String value = dataMap.get("aaa") + "";
        log.warn("value:{}", value);
        // 测试是否获取到 bean
        log.error("quartzJobService: {}", quartzJobService);
    }
}