package com.github.laoxingtalk.example.convert;

import com.github.laoxingtalk.example.dto.ChangeOrderStateDTO;
import com.github.laoxingtalk.example.dto.CreateOrderDTO;
import com.github.laoxingtalk.example.vo.ChangeOrderStateVO;
import com.github.laoxingtalk.example.vo.CreateOrderVO;
import org.springframework.beans.BeanUtils;

public class OrderConverts {

    private OrderConverts() {
    }

    public static CreateOrderDTO toCreateOrderDTO(CreateOrderVO vo) {
        CreateOrderDTO dto = new CreateOrderDTO();
        BeanUtils.copyProperties(vo, dto);
        return dto;
    }

    public static ChangeOrderStateDTO toChangeOrderStateDTO(ChangeOrderStateVO vo) {
        ChangeOrderStateDTO dto = new ChangeOrderStateDTO();
        BeanUtils.copyProperties(vo, dto);
        return dto;
    }
}
