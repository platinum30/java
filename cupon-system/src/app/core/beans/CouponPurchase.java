package app.core.beans;

public class CouponPurchase {
	int customerId;
	int couponId;

	@Override
	public String toString() {
		return "CouponPurchase [customerId=" + customerId + ", couponId=" + couponId + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
}
