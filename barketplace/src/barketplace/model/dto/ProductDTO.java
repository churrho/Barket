package barketplace.model.dto;

//ToString, 생성자 설정하기
public class ProductDTO {
	private String brandName;
	private String productName;

	public ProductDTO() {
		super();
	}
	
	public ProductDTO(String brandName, String productName) {
		super();
		this.brandName = brandName;
		this.productName = productName;
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

	/*
	 * public String toString() { StringBuilder builder = new StringBuilder();
	 * return "ProductDTO [brandName=" + brandName + ", productName=" +
	 * productName + "]"; }
	 */

}
