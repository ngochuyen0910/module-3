package dto;

public class ContractDTO {
    private int contractId;
    private int facilityId;
    private int customerId;
    private String contractStartDate;
    private String contractEndDate;
    private double deposit;
    private double totalMoney;
    private int attachFacilityId;
    private String attachFacilityName;
    private double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;

    public ContractDTO() {
    }

    public ContractDTO(int contractId, int facilityId, int customerId, String contractStartDate, String contractEndDate, double deposit, double totalMoney, int attachFacilityId, String attachFacilityName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus) {
        this.contractId = contractId;
        this.facilityId = facilityId;
        this.customerId = customerId;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.attachFacilityId = attachFacilityId;
        this.attachFacilityName = attachFacilityName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(int attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
