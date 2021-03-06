package co.edu.utp.misiontic2022.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import co.edu.utp.misiontic2022.model.vo.Requerimiento_2;
import co.edu.utp.misiontic2022.util.JDBCUtilities;

public class RequerimientoDao_2 {
    
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {

        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();
        Connection conexion = JDBCUtilities.getConnection();
        
        try {
            String consulta = "SELECT p.Fecha_Inicio AS 'fec. Ini.', p.Ciudad AS 'Nombre Ciudad', " +
                              "p.Constructora AS 'Nom. Constructora', l.Nombre || ' ' || l.Segundo_Apellido AS 'Nombre Lider', " +  
                              "t.Codigo_Tipo AS 'Codigo Tipo', t.Estrato " +
                              "FROM Proyecto p INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider) " +
                              "INNER JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo) " +
                              "WHERE p.Fecha_Inicio BETWEEN '2020-01-01' AND '2020-07-09' AND p.Ciudad = 'Ibague' ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Requerimiento_2 requerimiento_2 = new Requerimiento_2(
                    resultSet.getString("Fec. Ini."),
                    resultSet.getString("Nombre Ciudad"),
                    resultSet.getString("Nom. Constructora"),
                    resultSet.getString("Nombre Lider"),
                    resultSet.getInt("Codigo Tipo"),
                    resultSet.getInt("Estrato")
                );
                respuesta.add(requerimiento_2);

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e){
            System.err.println("Error consulta SQL Requerimiento_2 -> " + e);
        } finally{
            if (conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
    
    public ArrayList<Requerimiento_2> requerimiento2(String fIni, String fFin, String ciu) throws SQLException {

        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();
        Connection conexion = JDBCUtilities.getConnection();
        
        try {
            String consulta = "SELECT p.Fecha_Inicio AS 'fec. Ini.', p.Ciudad AS 'Nombre Ciudad', " +
                              "p.Constructora AS 'Nom. Constructora', l.Nombre || ' ' || l.Segundo_Apellido AS 'Nombre Lider', " +  
                              "t.Codigo_Tipo AS 'Codigo Tipo', t.Estrato " +
                              "FROM Proyecto p INNER JOIN Lider l ON (p.ID_Lider = l.ID_Lider) " +
                              "INNER JOIN Tipo t ON (p.ID_Tipo = t.ID_Tipo) " +
                              "WHERE p.Fecha_Inicio BETWEEN '" + fIni + "' AND '" + fFin + "' AND p.Ciudad = '" + ciu + "' ";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Requerimiento_2 requerimiento_2 = new Requerimiento_2(
                    resultSet.getString("Fec. Ini."),
                    resultSet.getString("Nombre Ciudad"),
                    resultSet.getString("Nom. Constructora"),
                    resultSet.getString("Nombre Lider"),
                    resultSet.getInt("Codigo Tipo"),
                    resultSet.getInt("Estrato")
                );
                respuesta.add(requerimiento_2);

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e){
            System.err.println("Error consulta SQL Requerimiento_2 -> " + e);
        } finally{
            if (conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
}
