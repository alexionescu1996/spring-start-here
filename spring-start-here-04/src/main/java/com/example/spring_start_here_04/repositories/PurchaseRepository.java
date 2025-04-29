package com.example.spring_start_here_04.repositories;

import com.example.spring_start_here_04.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public PurchaseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase(product, price) values (?, ?)";

        jdbcTemplate.update(sql,
                purchase.getProduct(),
                purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * from purchase";

        RowMapper<Purchase> purchaseRowMapper = (resultSet, i) -> {
            Purchase rowObject = new Purchase();
            rowObject.setId(resultSet.getInt("id"));
            rowObject.setProduct(resultSet.getString("product"));
            rowObject.setPrice(resultSet.getBigDecimal("price"));

            return rowObject;
        };

        return jdbcTemplate.query(sql, purchaseRowMapper);
    }
}
