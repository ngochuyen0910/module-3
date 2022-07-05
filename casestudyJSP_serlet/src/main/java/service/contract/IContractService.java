package service.contract;

import model.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();

    void create(Contract contract);
}
