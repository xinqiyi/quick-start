package com.example.domain.customer.query;

import com.example.domain.customer.query.dto.EstateRoomAdapterDTO;

/**
 * @Author: jzj
 * @Date: 2022/3/25
 * @Desc:
 */
public interface EstateRoomQueryAdapter {
    EstateRoomAdapterDTO getRoomByRoomUuidOrElseThrow(String roomUuid);

}
