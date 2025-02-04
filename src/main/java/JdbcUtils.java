
//4- jdbc için gerekli olan nesnelerin hazırlığı

import java.sql.*;

public class JdbcUtils {
    /*jbbc için gerekli olan malzemeler yani kullanıcaklar için bu classı oluşturdum*/

    public static Connection connection;
    public static Statement st;
    public static PreparedStatement prst;

    //4-a: connection oluşturma methodu;
    public static void setConnection(){
        //url,username,password
        try {
            connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcStudentManagement",
                    "techpro","password");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //4-b: statement oluşturma methodu;
    public static void setStatement(){
    /*connetciton nesnemizin createstatement methodu bize bir tane statemetn nesnesi veriyordu*/

        try {
            st=connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //4-c: preparedStatement oluşturma methodu;

    public static void setPreparedStatement(String sql){

        /*connection nesnemizin prepared Statement methodu bu bize geriye bir prepared statement nesnesi döndürüyor*/
        /*ben methoda string olarka bir sql sorgusu vericem.bu sql sorugusunu verdiğimde preparedstatement methodu
        * sql sorgusundan bana bir prst nesnesi oluşturucak.yani prepared statment in hazırlanması için elimizde
        * sql sorgusunun string olarak hazır olması gerekiyor*/

        try {
            prst=connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
