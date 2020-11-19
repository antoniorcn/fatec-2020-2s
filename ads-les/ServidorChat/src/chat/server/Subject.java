package chat.server;

import java.io.IOException;

public interface Subject {
	
	void update(String msg, TrataCliente self) throws IOException;

}
