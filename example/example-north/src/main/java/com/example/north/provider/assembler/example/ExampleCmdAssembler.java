package com.example.north.provider.assembler.example;

import com.components.utils.BeanUtils;
import com.example.app.commond.cmd.example.CreateExampleAppCmd;
import com.example.app.commond.cmd.example.DeleteExampleAppCmd;
import com.example.app.commond.cmd.example.UpdateExampleAppCmd;
import com.example.app.commond.result.example.CreateExampleAppResult;
import com.example.app.commond.result.example.UpdateExampleAppResult;
import com.example.north.provider.request.example.CreateExampleReqDTO;
import com.example.north.provider.request.example.DeleteExampleReqDTO;
import com.example.north.provider.request.example.UpdateExampleReqDTO;
import com.example.north.provider.response.example.CreateExampleRespDTO;
import com.example.north.provider.response.example.UpdateExampleRespDTO;
import lombok.experimental.UtilityClass;


/**
 * 命名(增删改)接口参数 组装类
 *
 * @author jzj
 */
@UtilityClass
public class ExampleCmdAssembler {
    /**
     * 方法命名：to+请求参数类名
     *
     * @param reqDTO
     * @return
     */
    public static CreateExampleAppCmd toCreateExampleAppCmd(CreateExampleReqDTO reqDTO) {
        // 如果 需要组装入参和返参字段一致, 建议在组装类内新建组装方法
        return BeanUtils.copy(reqDTO, CreateExampleAppCmd.class);
    }

    /**
     * 方法命名：to+响应参数类名
     *
     * @param appResult
     * @return
     */
    public static CreateExampleRespDTO toCreateExampleRespDTO(CreateExampleAppResult appResult) {
        return BeanUtils.copy(appResult, CreateExampleRespDTO.class);
    }


    public UpdateExampleAppCmd toUpdateExampleAppCmd(UpdateExampleReqDTO reqDTO) {
        return BeanUtils.copy(reqDTO, UpdateExampleAppCmd.class);
    }

    public static UpdateExampleRespDTO toUpdateExampleRespDTO(UpdateExampleAppResult appResult) {
        return BeanUtils.copy(appResult, UpdateExampleRespDTO.class);
    }

    public static DeleteExampleAppCmd toDeleteExampleAppCmd(DeleteExampleReqDTO reqDTO) {
        return BeanUtils.copy(reqDTO, DeleteExampleAppCmd.class);
    }
}
