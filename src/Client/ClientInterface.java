package Client;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;

public interface ClientInterface {
	
	void sendDataToServer(String input) throws Exception;
}
