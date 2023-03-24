package DbStepdefinitions;


import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.getColumnData;

public class DbStepdefinition {

    // Bir JDBC projesine baslamadan önce ilk is olarak Database sistem yöneticisinden
    // Database Access Information bilgilerini almaliyiz.


    /*
    Database Access Information

	Database_type: mysql
	Database_name: trendlifebuy_trainingtrendlife
	Database_host/id_number: 194.140.198.209
	Database_port_number: 3306

	User_name: trendlifebuy_trainingtrendlifeuser
	Password: rRBMdEbSfj

     */

      String url="jdbc:mysql://194.140.198.209:3306/trendlifebuy_trainingtrendlife";
      String username="trendlifebuy_trainingtrendlifeuser";
      String password="rRBMdEbSfj";


        Connection con;

        Statement st;

        ResultSet rs;

    String query;

    List<Object> emailList = new ArrayList<>();

    @Given("Database ile baglanti kurulur.")
    public void database_ile_baglanti_kurulur() throws SQLException {

              con = DBUtils.getConnection();
              st = DBUtils.getStatement();

        // yaptigimiz islemler ile önce connection create ettik sonra create ettigimiz connection ile
        //bir statement create ettik ve data base baglantisini gerceklestirmis olduk.

    }
    @Given("Query olusturulur.")
    public void query_olusturulur() {

        query="select * from trendlifebuy_trainingtrendlife.users";
    }
    @Given("OLusturulan query statement araciligi ile database gonderilir.")
    public void o_lusturulan_query_statement_araciligi_ile_database_gonderilir() throws SQLException {
                  rs = st.executeQuery(query);
    }
    @Given("Statement ile donen veriler dogrulanir.")
    public void statement_ile_donen_veriler_dogrulanir() throws SQLException {

        rs.first();
        System.out.println(rs.getString("email"));
        String actualEmail= rs.getString("email");
        String expectedEmail= "info@trendlifebuy.com";

        rs.next();
        System.out.println(rs.getString("email"));

        rs.next();
        System.out.println(rs.getString("first_name"));

        System.out.println("°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");

//        rs.absolute(11);
//        while(rs.next()){
//            System.out.println(rs.getString("first_name"));
//        }


      //  assertEquals(expectedEmail,actualEmail);

        emailList = getColumnData(query,"first_name");

        System.out.println(emailList);

    }

    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() throws SQLException {

        rs.close();
        st.close();
        con.close();
    }






}
