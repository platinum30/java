package app.core.beans;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private ArrayList<Coupon> coupons;
}
