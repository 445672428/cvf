package db.handler.manager;

import java.sql.Connection;

public interface ConnectionProxy extends Connection{
	Connection getCurrentConnection();
}
