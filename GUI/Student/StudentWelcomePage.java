package GUI.Student;

import GUI.Admin.FoodListPageFolder.NewFoodListPage;

import javax.swing.*;

public class StudentWelcomePage extends JFrame {
    StudentWelcomePage(){
        initialize();
    }
    private void initialize(){
        add(new NewFoodListPage().NewFoodListPage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentWelcomePage();
    }
}
