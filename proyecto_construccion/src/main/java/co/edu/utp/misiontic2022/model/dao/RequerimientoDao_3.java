package co.edu.utp.misiontic2022.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.edu.utp.misiontic2022.model.vo.Requerimiento_3;
import co.edu.utp.misiontic2022.util.JDBCUtilities;

public class RequerimientoDao_3 {
    
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {

        ArrayList<Requerimiento_3> respuesta = new ArrayList<Requerimiento_3>();
        Connection conexion = JDBCUtilities.getConnection();

        try{
            String consulta = "SELECT SUBSTR(l.Nombre,1,3) || SUBSTR(l.Primer_Apellido,1,3) || SUBSTR(l.Segundo_Apellido,1,3) AS 'Abrev' " + 
                              "FROM Lider l ";
            
            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Requerimiento_3 requerimiento_3 = new Requerimiento_3(
                    resultSet.getString("Abrev")
                );
                respuesta.add(requerimiento_3);
            }
            resultSet.close();
            statement.close();

        } catch(SQLException e){
            System.err.println("Error de la consulta SQL Requerimiento_3 -> " + e);
        } finally {
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
}
