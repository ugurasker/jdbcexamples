package techproed.jdbcExamples;
import java.sql.* ;

public class Jdbc2Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String yol = "jdbc:oracle:thin:@localhost:1521/xe";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection(yol,"hr","123");
		
		Statement st = con.createStatement();
		
        // bolumler tablosundaki tum kaydi goster.
		
		ResultSet rs = st.executeQuery("SELECT * FROM  bolumler");
	
		while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}	
		System.out.println("=================================");
/*=======================================================================
ORNEK3: SATIS ve MUHASABE bolumlerinde calisan personelin isimlerini ve 
	 maaslarini maas sirali olarak listeleyiniz
========================================================================*/
		String q2= "SELECT personel_isim,maas "
					+ "FROM personel WHERE bolum_id IN (10,30) ORDER by maas";
			ResultSet t2=st.executeQuery(q2);
			while(t2.next()) {
				System.out.println(t2.getString(1)+" "+t2.getInt(2));
			}
			System.out.println("=================================");
/*=======================================================================
ORNEK4: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
 ve maaslarini bolum ve maas siraali listeleyiniz. NOT: calisani olmasa
 bile bolum ismi gosterilmelidir.
========================================================================*/
		String q3= "SELECT B.bolum_isim, P.personel_isim,P.maas "
				+ "FROM bolumler B "
				+ "FULL JOIN personel P "
				+ "ON P.bolum_id=B.bolum_id "
				+ "ORDER BY B.bolum_isim, P.maas";
		ResultSet t3 =st.executeQuery(q3);
		while(t3.next()) {
			System.out.println(t3.getString(1)+" "+t3.getString(2)+" "+t3.getInt(3));
		}
/*=======================================================================
ORNEK5: Maasi en yuksek 10 kisiyinin bolumunu,adini ve maasini listeyiniz
========================================================================*/	

		
		con.close();
		st.close();
		rs.close();
   
	}

}
