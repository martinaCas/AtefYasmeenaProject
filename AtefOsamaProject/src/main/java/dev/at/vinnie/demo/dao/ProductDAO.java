package dev.at.vinnie.demo.dao;

import dev.at.vinnie.demo.dbConnection.DBConnection;
import dev.at.vinnie.demo.model.Product;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products ;

    public List<Product>findAll(){

        try (Connection conn = DBConnection.getConnection()){
            String sql = "SELECT * FROM products";
            PreparedStatement ps = conn.prepareStatement( sql );
            ResultSet rs = ps.executeQuery();

            products=new ArrayList<>();

            while (rs.next()){
                Integer id = rs.getInt( "id" );
                String name = rs.getString( "name" );
                String description = rs.getString( "description" );
                Double price = rs.getDouble( "price" );
                Integer quantity = rs.getInt( "quantity" );

                Product product = new Product( id, name, description, price, quantity );

                products.add( product );

            }
            return products;
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }
}
