package techproed.jdbcExamples;
import java.sql.* ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//ilgili driveri yukle//
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//baglanti olustur//
		Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","123");
		
		// sql komutlari icin bir statement nesnesi olustur.
		Statement st = con.createStatement();
		// 4) SQL ifadeleri yazabiliriz. 
	    // (Personel tablosundaki personel_id’si 7369 olan personelin adini sorgulayiniz)
		ResultSet isim = st.executeQuery("SELECT personel_isim FROM personel WHERE personel_id=7369");
		
		// sonuclari aldik ve isledik. isim yerine rs (resultset kullaniliyo)
		while(isim.next()) {
    		System.out.println("Personel Adi: "+isim.getString("personel_isim"));
    	//	System.out.println("Personel Adi: "+isim.getString("1")); personel ismi executeQueryde 1. sirada
		}
		// olusturulan nesneleri bellekten kaldiralim.
		con.close();
		st.close();
		isim.close();
	}

}
