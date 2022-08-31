package com.example.domain.share.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 事件处理状态
 */
@Getter
@AllArgsConstructor
public enum EventStatusEnum {

    PENDING(0, "待处理"),
    SUCCESS(1, "处理成功"),
    FAILED(2, "处理失败");

    private final Integer code;
    private final String desc;

}
