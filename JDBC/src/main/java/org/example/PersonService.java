package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public int getAmountOfPersonsByCityId(int cityId) {
        String sql = "select * from person where city = " + cityId;
        int amountOfPerson = 0;
        try (ResultSet resultSet = Controller.executeQuery(sql)){
            while (resultSet.next()) {
                amountOfPerson++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return amountOfPerson;
    }
}
