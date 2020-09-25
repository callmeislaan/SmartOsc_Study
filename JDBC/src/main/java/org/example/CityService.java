package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityService {
    public List<Integer> getAllCityId() {
        String sql = "select ID from city";
        List<Integer> cityIds = new ArrayList<>();
        try (ResultSet resultSet = Controller.executeQuery(sql)) {

            while (resultSet.next()) {
                cityIds.add(resultSet.getInt(1));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return cityIds;
    }

    public String getCityName(int cityId) {
        String sql = "SELECT `name` FROM `city` WHERE ID =" + cityId;
        String cityName = null;
        try (ResultSet resultSet = Controller.executeQuery(sql)) {
            while (resultSet.next()) {
                cityName = resultSet.getString("name");
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return cityName;
    }
}
