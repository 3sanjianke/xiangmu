package org.shop.pojo;

public class ChuKu {
    private Integer chukuId;

    private String shopName;

    private String shopFenlei;

    private Integer chukuShuliang;

    private String chukuDate;

    public Integer getChukuId() {
        return chukuId;
    }

    public void setChukuId(Integer chukuId) {
        this.chukuId = chukuId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getShopFenlei() {
        return shopFenlei;
    }

    public void setShopFenlei(String shopFenlei) {
        this.shopFenlei = shopFenlei == null ? null : shopFenlei.trim();
    }

    public Integer getChukuShuliang() {
        return chukuShuliang;
    }

    public void setChukuShuliang(Integer chukuShuliang) {
        this.chukuShuliang = chukuShuliang;
    }

    public String getChukuDate() {
        return chukuDate;
    }

    public void setChukuDate(String chukuDate) {
        this.chukuDate = chukuDate == null ? null : chukuDate.trim();
    }

	@Override
	public String toString() {
		return "ChuKu [chukuId=" + chukuId + ", shopName=" + shopName + ", shopFenlei=" + shopFenlei
				+ ", chukuShuliang=" + chukuShuliang + ", chukuDate=" + chukuDate + "]";
	}
    
    
}