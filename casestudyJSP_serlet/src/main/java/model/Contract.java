package model;

public class Contract {
    private int contractId;
    private String contractStartDate;
    private String contractEndDate;
    private double deposit;
    private int employeeId;
    private int customerId;
    private int facilityId;

    public Contract() {
    }

    public Contract(int contractId, String contractStartDate, String contractEndDate, double deposit, int employeeId, int customerId, int facilityId) {
        this.contractId = contractId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.deposit = deposit;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.facilityId = facilityId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }
}
