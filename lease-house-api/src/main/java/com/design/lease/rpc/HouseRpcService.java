package com.design.lease.rpc;

import com.design.lease.account.dto.HouseDto;
import com.design.lease.bo.HouseDetailBO;
import com.design.lease.bo.HouseRelationDetailBO;
import com.design.lease.rpc.dto.RpcResponseDTO;

import java.util.List;

public interface HouseRpcService {

    public RpcResponseDTO<List<HouseDetailBO>> queryHouse(HouseDto houseDto);

    public RpcResponseDTO<HouseDetailBO> queryHouseDetailByHno(HouseDto houseDto);

    public RpcResponseDTO<HouseRelationDetailBO> queryHouseRelationDetailByHno(HouseDto houseDto);

    public RpcResponseDTO<List<HouseRelationDetailBO>> queryHouseRelationDetailList(HouseDto houseDto);

}
