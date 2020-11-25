package chat.server;

import java.io.IOException;

public interface Assinante {
	
	void update(String msg, TrataCliente self) throws IOException;

}
