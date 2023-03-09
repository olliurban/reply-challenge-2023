package entities;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<Grid.Field> fields = new ArrayList<Grid.Field>();

    public void addField(Grid.Field field) {
        fields.add(field);
    }

    public int getValue() {
        int pathValue = 0;
        for (Grid.Field field : fields) {
            pathValue = pathValue + field.value;
        }
        return pathValue;
    }
}
