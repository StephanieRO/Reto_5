package co.edu.utp.misiontic2022.view;

import java.sql.SQLException;
import java.util.ArrayList;
import co.edu.utp.misiontic2022.controller.ControllerRequerimientos;
import co.edu.utp.misiontic2022.model.vo.Requerimiento_1;
import co.edu.utp.misiontic2022.model.vo.Requerimiento_2;
import co.edu.utp.misiontic2022.model.vo.Requerimiento_3;

public class ViewRequerimientos {
    
    public static final ControllerRequerimientos controlador = new ControllerRequerimientos();

    public static void requerimiento1(){
        try{
            ArrayList<Requerimiento_1> listaRequerimiento_1;
            listaRequerimiento_1 = controlador.consultaRequerimiento_1();

            for(Requerimiento_1 rq: listaRequerimiento_1){
                System.out.println(
                    rq.getFechaCompra() + " " +
                    rq.getCodCompra() + " " +
                    rq.getNombreProveedor() + " " +
                    rq.getPagado()
                );
            }
        } catch (SQLException e){
            System.err.println(e);
        }
    }
    
    public static void requerimiento2() {
        try{
            ArrayList<Requerimiento_2> listaRequerimiento_2;
            listaRequerimiento_2 = controlador.consultaRequerimiento_2();

            for (Requerimiento_2 rq: listaRequerimiento_2){
                System.out.println(
                    rq.getFecIni() + " " +
                    rq.getNombreCiudad() + " " +
                    rq.getNomConstructora() + " " +
                    rq.getNombreLider() + " " +
                    rq.getCodigoTipo() + " " +
                    rq.getEstrato()
                );
            }
        } catch (SQLException e){
            System.err.println(e);
        }
    }

    public static void requerimiento3() {
        try{
            ArrayList<Requerimiento_3> listaRequerimiento_3;
            listaRequerimiento_3 = controlador.consultaRequerimiento_3();

            for(Requerimiento_3 rq: listaRequerimiento_3){
                System.out.println(
                    rq.getAbrev()
                );
            }
        } catch(SQLException e){
            System.err.println(e);
        }
    }
}
