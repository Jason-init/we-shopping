package com.qizhang.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.qizhang.canal.config.RabbitMQConfig;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@CanalEventListener
public class BusinessListener {

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 监听对应数据库，数据表的变化
     * @param eventType 当前操作数据库的类型
     * @param rowData 当前操作数据库的数据
     */
    @ListenPoint(schema = "changgou_business", table = "tb_ad")
    public void adUpdate(CanalEntry.EventType eventType, CanalEntry.RowData rowData) {
        System.out.println("广告表中数据发生变化");
//        rowData.getBeforeColumnsList().forEach((column) -> System.out.println("改变前的数据：" + column.getName() + ": " + column.getValue()));
//        rowData.getAfterColumnsList().forEach(column -> System.out.println("改变后的数据" + column.getName() + ": " + column.getValue()));
        for (CanalEntry.Column column : rowData.getAfterColumnsList()) {
            if ("position".equals(column.getName())) {
                System.out.println("发送最新的position数据到MQ: " + column.getValue());
                rabbitTemplate.convertAndSend("", RabbitMQConfig.AD_UPDATE_QUEUE, column.getValue());
            }
        }
    }
}
