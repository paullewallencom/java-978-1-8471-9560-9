package ejb30.session;

import javax.ejb.Local;

@Local
public interface NiceDayService {
    public String getMessage();
}

