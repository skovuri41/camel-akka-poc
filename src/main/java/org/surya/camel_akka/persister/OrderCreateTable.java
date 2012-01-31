package org.surya.camel_akka.persister;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @version $Revision: 85 $
 */
public class OrderCreateTable {
	protected transient Logger log = LoggerFactory.getLogger(getClass());

	public OrderCreateTable(CamelContext camelContext) {
		DataSource ds = camelContext.getRegistry().lookup("myDataSource",
				DataSource.class);
		JdbcTemplate jdbc = new JdbcTemplate(ds);

		try {
			jdbc.execute("drop table input_order");
			log.info("Dropped Table");
		} catch (Exception e) {
			// ignore as the table may not already exists
		}
		jdbc.execute("create table input_order"
				+ "( customer_id varchar(10), ref_no varchar(10), part_id varchar(10), amount varchar(10) )");
		log.info("Created Table");
	}

}
