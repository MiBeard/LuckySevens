/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.luckysevensjsps;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jamesbond
 */
@WebServlet(name = "LuckySevensJSPServlet", urlPatterns = {"/LuckySevensJSPServlet"})
public class LuckySevensJSPServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String inputAmount = request.getParameter("inputAmount");
        int betAmount = Integer.parseInt(inputAmount);
        int turns = 0, maxVal = 0, maxTurn = 0;
        int dieOne, dieTwo;

        do {

            turns++;

            dieOne = 1 + (int) (6 * Math.random());
            dieTwo = 1 + (int) (6 * Math.random());

            int dieTotal = dieOne + dieTwo;

            if (dieTotal == 7) {
                betAmount += 4;
            } else if (dieTotal != 7) {
                betAmount -= 1;
            }

            if (betAmount > maxVal) {
                maxVal = betAmount;
                maxTurn = turns++;
            }

        } while (betAmount > 0);

        request.setAttribute("inputAmount", inputAmount);
        request.setAttribute("dieOne", dieOne);
        request.setAttribute("dieTwo", dieTwo);
        request.setAttribute("betAmount", betAmount);
        request.setAttribute("turns", turns);
        request.setAttribute("maxVal", maxVal);
        request.setAttribute("maxTurn", maxTurn);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}