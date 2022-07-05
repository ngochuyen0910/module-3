package repository.contract;

import model.Contract;
import repository.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {

    private static final String FIND_ALL = "select * from contract";
    private static final String INSERT = "insert into contract(contract_start_date,contract_end_date,deposit,total_money,employee_id,customer_id,facility_id) " +
            " values (?,?,?,?,?,?,?)";


    @Override
    public List<Contract> findAll() {
        List<Contract> contractList = new ArrayList<>();
        contractList.clear();
        try {
            Connection connection = new BaseRepository().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            Contract contract = null;
            while (resultSet.next()) {
                int contractId = resultSet.getInt("contract_id");
                String contractStartDate = resultSet.getString("contract_start_date");
                String contractEndDate = resultSet.getString("contract_end_date");
                double deposit = resultSet.getDouble("deposit");
                double totalMoney = resultSet.getDouble("total_money");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int facilityId = resultSet.getInt("facility_id");
                contract = new Contract(contractId, contractStartDate, contractEndDate, deposit, totalMoney, employeeId, customerId, facilityId);
                contractList.add(contract);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public void create(Contract contract) {
        Connection connection = new BaseRepository().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, contract.getContractStartDate());
            preparedStatement.setString(2, contract.getContractEndDate());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setDouble(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getFacilityId());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
