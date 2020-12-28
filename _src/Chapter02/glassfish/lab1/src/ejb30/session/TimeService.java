package ejb30.session;

import javax.ejb.Remote;

@Remote
public interface TimeService {
    public String getTime();
}

