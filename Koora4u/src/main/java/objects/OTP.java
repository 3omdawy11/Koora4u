package objects;

import java.util.Random;

public class OTP {
protected int number;
	public OTP() {
		// TODO Auto-generated constructor stub
	}
	public String generateOTP()
	{
		Random rnd = new Random();
		number = rnd.nextInt(999999);
		return String.format("%06d",number);
				
	}

}
