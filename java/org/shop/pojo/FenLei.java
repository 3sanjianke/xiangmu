package org.shop.pojo;

public class FenLei {
    private Integer sortId;

    private String sortName;

    private String sortDescribe;

    private String sortRemark;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public String getSortDescribe() {
        return sortDescribe;
    }

    public void setSortDescribe(String sortDescribe) {
        this.sortDescribe = sortDescribe == null ? null : sortDescribe.trim();
    }

    public String getSortRemark() {
        return sortRemark;
    }

    public void setSortRemark(String sortRemark) {
        this.sortRemark = sortRemark == null ? null : sortRemark.trim();
    }

	@Override
	public String toString() {
		return "FenLei [sortId=" + sortId + ", sortName=" + sortName + ", sortDescribe=" + sortDescribe
				+ ", sortRemark=" + sortRemark + "]";
	}
    
}