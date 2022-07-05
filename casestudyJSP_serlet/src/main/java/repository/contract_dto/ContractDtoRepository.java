package repository.contract_dto;

import dto.ContractDTO;

import java.util.List;

public class ContractDtoRepository implements  IContractDtoRepository {

    private static final String FIND_ALL = "select * from ";

    @Override
    public List<ContractDTO> findAll() {
        return null;
    }
}
