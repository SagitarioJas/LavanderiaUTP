package pe.edu.utp.overux.controllers;

import pe.edu.utp.overux.models.domain.Region;
import pe.edu.utp.overux.models.domain.Usuario;
import pe.edu.utp.overux.services.HrService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "LoginUsuController", urlPatterns = "/LoginUsu")
public class LoginUsuController extends javax.servlet.http.HttpServlet {
    HrService service;
    String url;

    public LoginUsuController() {
        super();
        service = new HrService();
        url = "";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("POST", request, response);
    }


    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest("GET", request, response);
    }

    private void processRequest(String method,
                                HttpServletRequest request,
                                HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        String action = request.getParameter("action");
        if(method.equals("GET")) {

            if(action.equals("indexUsu")) {
                url = "loginUsuario.jsp";
            }
            if(action.equals("indexCli")) {
                url = "loginCliente.jsp";
            }

            if(action.equals("new")) {
                url = "newUsuario.jsp";
            }


        }
        if(method.equals("POST")) {

            if(action.equals("logearse")) {
                String name = request.getParameter("user_name");
                String password = request.getParameter("user_password");
                int perfil=Integer.parseInt(request.getParameter("user_perfil"));
                int opc = service.finByLogin(name,password,perfil);
                if (opc == 0)
                {
                    url = "errorLogin.jsp";
                }
                else{
                    if (perfil == 2)
                    {
                        url = "Clientes.jsp";
                    }
                    else{
                        url = "perfilCliente.jsp";
                    }

                }

            }
            // action == create
            if(action.equals("create")) {
                String name = request.getParameter("user_name");
                String password = request.getParameter("user_password");
                int perfil=Integer.parseInt(request.getParameter("user_perfil"));
                Usuario usuario=service.createUsuario(name,password,perfil);
                url = "loginUsuario.jsp";
            }

        }

        request.getRequestDispatcher(url).forward(request, response);
    }
}
