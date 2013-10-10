package Conexion;


import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class conexion {
    
public String bd = "db_prefectura";
public String login = "root";
public String password = "root_app";
public String url = "jdbc:mysql://localhost/"+bd;
Connection conn = null;
Statement st=null;
public Statement conectar() {
    try {
        Class.forName("org.gjt.mm.mysql.Driver");
        conn = DriverManager.getConnection(url, login, password);
        if (conn != null)
        {
             System.out.println("Yeah, hemos conectado con  "+url+" ... Ok");
             st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //conn.close();
        }
    }
    catch(SQLException ex) {
        System.out.println(ex);
        JOptionPane.showMessageDialog(null,"Hubo un problema al conectar con la base de datos\nEl sistema no puede proseguir","Error grave de conexion",JOptionPane.ERROR_MESSAGE,new ImageIcon(conexion.class.getResource ("imagen/cancel.png")));
        System.exit(0);
    }
    catch(ClassNotFoundException ex) {
        System.out.println(ex);
    }
       return st;
}
/**
*
*Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return estado regresa el estado de la ejecución, true(éxito) o false(error)
*
*/
public boolean ejecutarSQL(String sql)
{
   try {
      st.executeUpdate(sql);
//      conn.close();
   } catch (SQLException ex) {
      ex.printStackTrace();
      return false;
   } 
   return true;
}
 
/**
*
*Método utilizado para realizar la instrucción SELECT
*@param sql Cadena que contiene la instrucción SQL a ejecutar
*@return resultado regresa los registros generados por la consulta
*
*/
public ResultSet ejecutarSQLSelect(String sql)
{   
    ResultSet resultado;
   try {
      resultado = st.executeQuery(sql);
//      conn.close();
   } catch (SQLException ex) {
      ex.printStackTrace();
      return null;
   }
 
   return resultado;
}

}