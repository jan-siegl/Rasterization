package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) {
        int[][] coordinates = new int[3][2];
        int i = 0;
        for (Coordinate filledCoordinate : getSelectedPoints()) {
            coordinates[i][0] = filledCoordinate.getX();
            coordinates[i][1] = filledCoordinate.getY();
            i++;
        }
        double x = (coordinate.getX() - coordinates[1][0]) * (coordinates[2][1] - coordinates[1][1]) - (coordinate.getY() - coordinates[1][1]) * (coordinates[2][0] - coordinates[1][0]);
        double y = (coordinate.getX() - coordinates[2][0]) * (coordinates[0][1] - coordinates[2][1]) - (coordinate.getY() - coordinates[2][1]) * (coordinates[0][0] - coordinates[2][0]);
        double z = (coordinate.getX() - coordinates[0][0]) * (coordinates[1][1] - coordinates[0][1]) - (coordinate.getY() - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0]);
        if (x < 0 && y < 0 && z < 0){
            return true;
        } else {
            return false;
        }
    }
}
