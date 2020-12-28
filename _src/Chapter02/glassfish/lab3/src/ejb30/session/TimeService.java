package ejb30.session;

import javax.ejb.Remote;

@Remote
public interface TimeService {
    public void init();
    public String getTime();
    public void tidyUp();
}

