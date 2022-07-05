package repository.contract_detail;

import model.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> findAll();
}
