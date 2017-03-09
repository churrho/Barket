package barketplace.model.dto;

//ToString, 생성자 설정하기
public class TransactionDTO {
	private int trans_no;
	private int price;
	private int proceed;
	private String sellId;
	private String buyId;
	private String brandName;
	private String productName;
	private String couponBarcode;
	private String expDate;
	private String content;
	private String calender;
	
	public TransactionDTO() {
		super();
	}

	public TransactionDTO(int trans_no, int price, int proceed, String sellId, String buyId, String brandName,
			String productName, String couponBarcode, String expDate, String content, String calender) {
		super();
		this.trans_no = trans_no;
		this.price = price;
		this.proceed = proceed;
		this.sellId = sellId;
		this.buyId = buyId;
		this.brandName = brandName;
		this.productName = productName;
		this.couponBarcode = couponBarcode;
		this.expDate = expDate;
		this.content = content;
		this.calender = calender;
	}
	
	
	public TransactionDTO(int trans_no, int price, int proceed, String sellId, String brandName, String productName,
			String expDate, String content, String calender) {
		super();
		this.trans_no = trans_no;
		this.price = price;
		this.proceed = proceed;
		this.sellId = sellId;
		this.brandName = brandName;
		this.productName = productName;
		this.expDate = expDate;
		this.content = content;
		this.calender = calender;
	}

	public int getTrans_no() {
		return trans_no;
	}

	public void setTrans_no(int trans_no) {
		this.trans_no = trans_no;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProceed() {
		return proceed;
	}

	public void setProceed(int proceed) {
		this.proceed = proceed;
	}

	public String getSellId() {
		return sellId;
	}

	public void setSellId(String sellId) {
		this.sellId = sellId;
	}

	public String getBuyId() {
		return buyId;
	}

	public void setBuyId(String buyId) {
		this.buyId = buyId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCouponBarcode() {
		return couponBarcode;
	}

	public void setCouponBarcode(String couponBarcode) {
		this.couponBarcode = couponBarcode;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCalender() {
		return calender;
	}

	public void setCalender(String calender) {
		this.calender = calender;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		return "TransactionDTO [trans_no=" + trans_no + ", price=" + price + ", proceed=" + proceed + ", sellId="
				+ sellId + ", buyId=" + buyId + ", brandName=" + brandName + ", productName=" + productName
				+ ", couponBarcode=" + couponBarcode + ", expDate=" + expDate + ", content=" + content + ", calender="
				+ calender + "]";
	}
	
}
