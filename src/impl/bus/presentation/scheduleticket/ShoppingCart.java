package impl.bus.presentation.scheduleticket;

public class ShoppingCart {
	
	private String id;
	private String vueltaId;
	private String code;

	public String getVueltaId() {
		return vueltaId;
	}

	public void setVueltaId(String vueltaId) {
		this.vueltaId = vueltaId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [id= " + id + ", vueltaId= " + vueltaId + ", code= " + code + "]"; 
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
