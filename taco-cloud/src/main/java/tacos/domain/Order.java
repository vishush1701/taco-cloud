package tacos.domain;

import lombok.Data;

@Data
public class Order {
	private String name;
	private String city;
	private String street;
	private String state;
	private String zip;
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
}
