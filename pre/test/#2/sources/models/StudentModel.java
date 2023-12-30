package models;

import java.sql.*;

import providers.Database;
import schemas.StudentSchema;

public class StudentModel extends BaseModel<StudentSchema> {
    @Override
    public StudentSchema[] get() {
        try {
            final Database database = new Database();
            final int total = database.tableTotal("student");
            final ResultSet result = database.executeQuery("SELECT id, name, grade, major FROM student;");

            final StudentSchema[] students = new StudentSchema[total];
            int i = 0;
            while (result.next()) {
                students[i] = new StudentSchema(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("grade"),
                        result.getString("major"));

                i++;
            }

            database.close();

            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public StudentSchema getOne(int id) {
        try {
            final Database database = new Database();
            final ResultSet result = database
                    .executeQuery("SELECT id, name, grade, major FROM student WHERE id='" + id + "';");

            StudentSchema student = null;

            if (result.next()) {
                student = new StudentSchema(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("grade"),
                        result.getString("major"));
            }

            database.close();

            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(StudentSchema schema) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "INSERT INTO student (name, grade, major) VALUES ("
                            + "'" + schema.getName() + "', "
                            + "'" + schema.getGrade() + "', "
                            + "'" + schema.getMajor() + "'"
                            + ");");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(StudentSchema[] schemas) {
        try {
            final Database database = new Database();

            String query = "INSERT INTO student (name, grade, major) VALUES ";
            for (int i = 0; i < schemas.length; i++) {
                query = query + "("
                        + "'" + schemas[i].getName() + "', "
                        + "'" + schemas[i].getGrade() + "', "
                        + "'" + schemas[i].getMajor() + "'"
                        + ")";

                if (i != (schemas.length - 1)) {
                    query = query + ", ";
                } else {
                    query = query + ";";
                }
            }

            database.executeUpdate(query);

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change(int id, StudentSchema schema) {
        try {
            final Database database = new Database();
            database.executeUpdate(
                    "UPDATE student SET "
                            + "name='" + schema.getName() + "', "
                            + "grade='" + schema.getGrade() + "', "
                            + "major='" + schema.getMajor() + "' "
                            + "WHERE "
                            + "id='" + id + "'"
                            + ";");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            final Database database = new Database();
            database.executeUpdate("DELETE FROM student WHERE id='" + id + "'");

            database.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
