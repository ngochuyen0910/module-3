package service.contract;

import model.Contract;
import repository.contract.ContractRepository;
import repository.contract.IContractRepository;

import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository contractRepository = new ContractRepository();

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void create(Contract contract) {
        contractRepository.create(contract);
    }
}
