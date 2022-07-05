package repository.contract_detail;

import model.ContractDetail;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository implements IContractDetailRepository {
    static List<ContractDetail> contractDetailList = new ArrayList<>();
    private static final String FIND_ALL = "select * from contract_detail";

    @Override
    public List<ContractDetail> findAll() {
        contractDetailList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            ContractDetail contractDetail = null;
            while (resultSet.next()) {
                int contractDetailId = resultSet.getInt("contract_detail_id");
                int quanity = resultSet.getInt("quanity");
                int contractId = resultSet.getInt("contract_id");
                int attachFacilityId = resultSet.getInt("attach_facility_id");
                contractDetail = new ContractDetail(contractDetailId, quanity, contractId, attachFacilityId);

                contractDetailList.add(contractDetail);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractDetailList;
    }
}
