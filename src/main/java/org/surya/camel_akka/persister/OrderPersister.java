package org.surya.camel_akka.persister;

import javax.sql.DataSource;

import org.apache.camel.spi.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.surya.camel_akka.message.InputOrder;

public class OrderPersister {
	protected transient Logger log = LoggerFactory.getLogger(getClass());

	public void save(InputOrder order, Registry registry) {
		DataSource ds = registry.lookup("myDataSource", DataSource.class);
		JdbcTemplate jdbc = new JdbcTemplate(ds);

		Object[] args = new Object[] { order.getCustomerId(), order.getRefNo(),
				order.getPartId(), order.getAmount() };
		jdbc.update(
				"insert into input_order (customer_id, ref_no, part_id, amount) values (?, ?, ?, ?)",
				args);
		log.info("OrderNo: {} Persisted Successfully", order.getRefNo());

	}

}
