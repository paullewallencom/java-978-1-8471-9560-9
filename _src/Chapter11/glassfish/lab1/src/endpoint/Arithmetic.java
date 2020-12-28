package endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;  

@WebService
public class Arithmetic {
	public Arithmetic() {}

	@WebMethod
	public int multiply(int a, int b) {
            int c = a * b ;
		return c;
	}
}
