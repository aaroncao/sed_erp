package com.iverson.erp.dto;

import com.iverson.erp.pojo.OrderDetail;
import lombok.Data;

import java.util.List;

/**
 * class orderDTO
 * @author Iverson
 * @date 2019/07/13
 */

@Data
public class OrderDTO {
    /** 订单编号 */
    private String orderNo;
    /** 商店编号 */
    private String shopNo;
    /** 商店名称 */
    private String shopName;
    /** 机器编号 */
    private String machineNo;
    /** 机器名称 */
    private String machineName;
    /** 员工编号 */
    private String staffNo;
    /** 员工姓名 */
    private String name;
    /** 订单总金额 */
    private Double orderAmount;
    /** 订单状态 */
    private Integer orderStatus;
    /** 支付状态 */
    private Integer payStatus;
    /** 订单详情 */
    List<OrderDetail> orderDetails;
}
