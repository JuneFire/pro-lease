package com.design.lease.rpc;

import com.design.lease.bo.HouseCollectionDetailBO;
import com.design.lease.bo.LandlordDetailBO;
import com.design.lease.bo.PayDetailBO;
import com.design.lease.dto.HouseCollectionDTO;
import com.design.lease.dto.LandlordOrderDTO;
import com.design.lease.dto.PayDetailDTO;
import com.design.lease.rpc.dto.RpcResponseDTO;

import java.util.List;

public interface TradeRpcService {

    public RpcResponseDTO<List<HouseCollectionDetailBO>> queryCollectionList(HouseCollectionDTO collectionDTO);

    public RpcResponseDTO<HouseCollectionDetailBO> queryCollectionDetailByOrderNo(HouseCollectionDTO collectionDTO);

    public RpcResponseDTO<HouseCollectionDetailBO> queryCollectionDetailByHouseNo(HouseCollectionDTO collectionDTO);

    public RpcResponseDTO<HouseCollectionDetailBO> collectionHouse(HouseCollectionDTO collectionDTO);

    public RpcResponseDTO<List<LandlordDetailBO>> queryLandlordOrderList(LandlordOrderDTO orderDTO);

    public RpcResponseDTO<LandlordDetailBO> queryOrderDetail(LandlordOrderDTO orderDTO);

    public RpcResponseDTO<PayDetailBO> payRequest(PayDetailDTO payDTO);

    public RpcResponseDTO<PayDetailBO> payConfirm(PayDetailDTO payDTO);


}
