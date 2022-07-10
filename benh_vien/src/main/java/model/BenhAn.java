package model;

public class BenhAn {
    private int maBenhAn;
    private String tenBenhAn;

    public BenhAn() {
    }

    public BenhAn(int maBenhAn, String tenBenhAn) {
        this.maBenhAn = maBenhAn;
        this.tenBenhAn = tenBenhAn;
    }

    public int getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(int maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getTenBenhAn() {
        return tenBenhAn;
    }

    public void setTenBenhAn(String tenBenhAn) {
        this.tenBenhAn = tenBenhAn;
    }
}
