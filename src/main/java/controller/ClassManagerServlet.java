package controller;

import Model.ClassManager;
import dao.ClassDAO;
import dao.IClassDAO;
import service.ClassService;
import service.ClassServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ClassManagerServlet", value = "/class")
public class ClassManagerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassDAO classDAO;

    public void init() {
        classDAO = new ClassDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
//                    deleteUser(request, response);
                    break;
                default:
                    listClassManager(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }


    private void showNewForm(HttpServletRequest request, HttpServletResponse response) {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertClassManager(request, response);
                    break;
                case "edit":
                    updateClassManager(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void updateClassManager(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException,SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        ClassManager book = new ClassManager(id,name,description);
        classDAO.updateClassManager(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request,response);
    }

    private void insertClassManager(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        ClassManager newClass = new ClassManager(name,description);
        classDAO.insertClassManager(newClass);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request,response);
    }

    private void listClassManager(HttpServletRequest request, HttpServletResponse response)
            throws SQLException,IOException,ServletException{
        List<ClassManager> listClassManager= classDAO.selectAllClassManager();
        request.setAttribute("listClass",listClassManager);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listClass.jsp");
        dispatcher.forward(request,response);
    }
}
