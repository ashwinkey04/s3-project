package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Payment;

public class PaymentSQL extends SQLHelper {
	protected static PaymentSQL db = new PaymentSQL();

	@Override
	protected void setTableName() {
		table = "payment";
	}
	
	private String getValuesString(Payment payment) {
		String values = "(" +
						surroundQuote(payment.get_payment_id())+","+
						surroundQuote(payment.get_payment_date())+","+
						surroundQuote(payment.get_alb_id())+","+
						surroundQuote(payment.get_buyer_id())+","+
						")";
		return values;
				
	}

	public Payment[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Payment payment_array[] = new Payment[count];

		while (resultSet.next()) {
			
			payment_array[index] = new Payment();
			payment_array[index].set_payment_id(resultSet.getString("payment_id"));
			payment_array[index].set_payment_date(resultSet.getDate("payment_date"));
			payment_array[index].set_alb_id(resultSet.getString("alb_id"));
			payment_array[index].set_buyer_id(resultSet.getString("buyer_id"));

			index++;
		}
		return payment_array;
	}
	
	public static String generatePaymentId() throws Exception{
		PaymentSQL.initDB();
		db.initTable();
		ResultSet r = execCommand("SELECT payment_id FROM payment ORDER BY payment_id DESC LIMIT 1");
		r.next();
		int new_id=(1+Integer.parseInt(r.getString("payment_id").substring(1)));
		r.close();
		db.close();
		return "P"+new_id;
	}
	
	public static void insert(Payment m) throws Exception {
		PaymentSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(m));
		db.close();
	}

	public static void main(String[] args) throws Exception {
//		PaymentSQL db = new PaymentSQL();
//		PaymentSQL.initDB();
//		db.initTable();
//		System.out.println(generatePaymentId());
//		
//		db.close();
	}

}
