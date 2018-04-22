package com.design.lease.rpc;

import com.alibaba.dubbo.rpc.RpcException;
import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseCollectionDetailBO;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.bo.LandlordDetailBO;
import com.design.lease.bo.PayDetailBO;
import com.design.lease.collection.dao.LeaseHouseCollectionDao;
import com.design.lease.collection.po.LeaseHouseCollectionPO;
import com.design.lease.dto.HouseCollectionDTO;
import com.design.lease.dto.LandlordOrderDTO;
import com.design.lease.dto.PayDetailDTO;
import com.design.lease.helper.TradeHelper;
import com.design.lease.landlord.dao.LeaseLandlordDetailDao;
import com.design.lease.landlord.po.LeaseLandlordDetailPO;
import com.design.lease.pay.dao.LeasePayDetailDao;
import com.design.lease.pay.dao.LeasePayFlowDao;
import com.design.lease.rpc.constant.RpcCommonConstant;
import com.design.lease.rpc.dto.RpcResponseDTO;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TradeRpcServiceImpl extends TradeHelper implements TradeRpcService{

    private static final Logger logger = LoggerFactory.getLogger(TradeRpcService.class);

    @Autowired
    private LeaseHouseCollectionDao collectionDao;

    @Autowired
    private LeasePayDetailDao payDetailDao;

    @Autowired
    private LeaseLandlordDetailDao landlordDetailDao;

    @Autowired
    private LeasePayFlowDao payFlowDao;

    @Autowired
    private HouseRpcService houseRpcService;


    @Override
    public RpcResponseDTO<List<HouseCollectionDetailBO>> queryCollectionList(HouseCollectionDTO collectionDTO) {

        if (collectionDTO == null || collectionDTO.getUid() == null){
            logger.error("执行queryCollectionList方法异常,参数错误.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<List<HouseCollectionDetailBO>>().buildParamErrorResponse();
        }

        List<LeaseHouseCollectionPO> list = collectionDao.queryCollectionList(collectionDTO.getUid());

        if (CollectionUtils.isEmpty(list)){
            logger.error("执行queryCollectionList方法完成,查询结果size = 0.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<List<HouseCollectionDetailBO>>().buildSuccessResponse();
        }

        List<HouseCollectionDetailBO> collectionDetailBOS = this.buildHouseList(list);
        return new RpcResponseDTO<List<HouseCollectionDetailBO>>().buildSuccessResponse(collectionDetailBOS);
    }

    @Override
    public RpcResponseDTO<HouseCollectionDetailBO> queryCollectionDetailByOrderNo(HouseCollectionDTO collectionDTO) {

        if (collectionDTO == null || collectionDTO.getOrderId() == null){
            logger.error("执行queryCollectionDetailByOrderNo方法异常,参数错误.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildParamErrorResponse();
        }

        LeaseHouseCollectionPO leaseHouseCollectionPO = collectionDao.queryCollectionDetailByOrderId(collectionDTO.getOrderId());

        if (leaseHouseCollectionPO == null){
            logger.error("执行queryCollectionDetailByOrderNo方法异常,查询详情为null.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildUnknownErrorResponse();
        }

        HouseCollectionDetailBO houseCollectionDetailBO = this.buildHouseDetail(leaseHouseCollectionPO);
        return new RpcResponseDTO<HouseCollectionDetailBO>().buildSuccessResponse(houseCollectionDetailBO);
    }

    @Override
    public RpcResponseDTO<HouseCollectionDetailBO> queryCollectionDetailByHouseNo(HouseCollectionDTO collectionDTO) {
        if (collectionDTO == null || collectionDTO.getHouseNo() == null || collectionDTO.getUid() == null || collectionDTO.getStatus() == null){
            logger.error("执行queryCollectionDetailByOrderNo方法异常,参数错误.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildParamErrorResponse();
        }

        LeaseHouseCollectionPO leaseHouseCollectionPO = collectionDao.queryCollectionDetailByHouseNo(collectionDTO.getHouseNo(),collectionDTO.getUid(),collectionDTO.getStatus());

        if (leaseHouseCollectionPO == null){
            logger.error("执行queryCollectionDetailByOrderNo方法异常,查询详情为null.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildUnknownErrorResponse();
        }

        HouseCollectionDetailBO houseCollectionDetailBO = this.buildHouseDetail(leaseHouseCollectionPO);
        return new RpcResponseDTO<HouseCollectionDetailBO>().buildSuccessResponse(houseCollectionDetailBO);
    }


    @Override
    public RpcResponseDTO<HouseCollectionDetailBO> collectionHouse(HouseCollectionDTO collectionDTO) {

        if (collectionDTO == null || collectionDTO.getHouseNo() == null || collectionDTO.getUid() == null){
            logger.error("执行collectionHouse方法异常,参数错误.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildParamErrorResponse();
        }

        HouseDto houseDto = this.buildHouseDTO(collectionDTO);

        try {
            HouseDetailBO houseDetailBO = null;
            RpcResponseDTO<HouseDetailBO> responseDTO = houseRpcService.queryHouseDetailByHno(houseDto);

            if (!StringUtils.equals(responseDTO.getCode(), RpcCommonConstant.SUCCESS_CODE) || responseDTO.getDate() == null){
                logger.error("执行collectionHouse方法异常,RPC返回结果错误.collectionDTO = {}",collectionDTO);
                return new RpcResponseDTO<HouseCollectionDetailBO>().buildFailResponse();
            }
            houseDetailBO = responseDTO.getDate();
            LeaseHouseCollectionPO leaseHouseCollectionPO = this.buildHouseCollection(collectionDTO,houseDetailBO);
            collectionDao.insert(leaseHouseCollectionPO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildSuccessResponse();
        }catch (RpcException e){
            logger.error("执行collectionHouse方法异常,RPC异常.collectionDTO = {}",collectionDTO);
            return new RpcResponseDTO<HouseCollectionDetailBO>().buildUnknownErrorResponse();
        }
    }

    @Override
    public RpcResponseDTO<List<LandlordDetailBO>> queryLandlordOrderList(LandlordOrderDTO orderDTO) {

        if (orderDTO == null || orderDTO.getUid() == null){
            logger.error("执行queryLandlordOrderList方法异常,参数错误.orderDTO = {}",orderDTO);
            return new RpcResponseDTO<List<LandlordDetailBO>>().buildParamErrorResponse();
        }

        List<LeaseLandlordDetailPO> list = landlordDetailDao.queryOrderList(orderDTO.getUid());

        if (CollectionUtils.isEmpty(list)){
            logger.error("执行queryCollectionList方法完成,查询结果size = 0.orderDTO = {}",orderDTO);
            return new RpcResponseDTO<List<LandlordDetailBO>>().buildSuccessResponse();
        }

        List<LandlordDetailBO> landlordDetailBOS = this.buildLandlordDetailList(list);
        return new RpcResponseDTO<List<LandlordDetailBO>>().buildSuccessResponse(landlordDetailBOS);

    }

    @Override
    public RpcResponseDTO<LandlordDetailBO> queryOrderDetail(LandlordOrderDTO orderDTO) {
        if (orderDTO == null || orderDTO.getOrderId() == null){
            logger.error("执行queryOrderDetail方法异常,参数错误.orderDTO = {}",orderDTO);
            return new RpcResponseDTO<LandlordDetailBO>().buildParamErrorResponse();
        }

        LeaseLandlordDetailPO leaseLandlordDetailPO = landlordDetailDao.queryOrderDetailByOrderNo(orderDTO.getOrderId());

        if (leaseLandlordDetailPO == null){
            logger.error("执行queryCollectionDetailByOrderNo方法异常,查询详情为null.orderDTO = {}",orderDTO);
            return new RpcResponseDTO<LandlordDetailBO>().buildUnknownErrorResponse();
        }

        LandlordDetailBO houseCollectionDetailBO = this.buildLandlordDetail(leaseLandlordDetailPO);
        return new RpcResponseDTO<LandlordDetailBO>().buildSuccessResponse(houseCollectionDetailBO);
    }

    @Override
    public RpcResponseDTO<PayDetailBO> payRequest(PayDetailDTO payDTO) {
        return null;
    }

    @Override
    public RpcResponseDTO<PayDetailBO> payConfirm(PayDetailDTO payDTO) {
        return null;
    }
}
