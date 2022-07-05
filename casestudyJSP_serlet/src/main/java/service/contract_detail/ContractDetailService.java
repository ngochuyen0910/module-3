package service.contract_detail;

import model.ContractDetail;
import repository.contract_detail.ContractDetailRepository;
import repository.contract_detail.IContractDetailRepository;

import java.util.List;

public class ContractDetailService implements IContractDetailService {
    private IContractDetailRepository contractFacilityRepository= new ContractDetailRepository();
    @Override
    public List<ContractDetail> findAll() {
        return contractFacilityRepository.findAll();
    }
}
