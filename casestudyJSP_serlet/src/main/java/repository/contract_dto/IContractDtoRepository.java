package repository.contract_dto;

import dto.ContractDTO;

import java.util.List;

public interface IContractDtoRepository {
    List<ContractDTO> findAll();
}
