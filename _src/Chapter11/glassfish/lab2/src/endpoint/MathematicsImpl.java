package endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService(endpointInterface = "endpoint.Mathematics")
public class MathematicsImpl implements Mathematics {
	public MathematicsImpl() {}

	//@WebMethod
	public int multiply(int a, int b) {
            int c = a * b ;
		return c;
	}

      public int add(int a, int b) {
            int c = a + b ;
		return c;
	}
}
