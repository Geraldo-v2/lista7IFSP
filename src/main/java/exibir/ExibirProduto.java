package exibir;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ProdutoDao;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ExibirProduto extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        final PrintWriter saida = resp.getWriter();
        final ProdutoDao dao = new ProdutoDao();
        final Gson gson = new Gson();
        String produtoJsonStr = "";

        List<Produto> lstProd = new ArrayList<>();

        try {
            lstProd = dao.pesquisar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        for (Produto prod : lstProd) 
        {
           produtoJsonStr += gson.toJson(prod);
        }

        saida.println(produtoJsonStr);

        saida.flush();
        saida.close();
    }
    
}