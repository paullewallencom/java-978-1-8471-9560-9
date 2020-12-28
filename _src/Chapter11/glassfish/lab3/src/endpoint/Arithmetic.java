package endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;


@WebService(
  name="Maths",
  serviceName="MathsWebService",
  targetNamespace="http://wsimport"
)
public class Arithmetic {
	public Arithmetic() {}

	@WebMethod(operationName="product")
	public int multiply(int a, int b) {
            int c = a * b ;
		return c;
	}
}



