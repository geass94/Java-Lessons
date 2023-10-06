package ge.itestep.Lesson_Four;

import ge.itestep.Lesson_Four.dao.TaskDAO;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task();
        task1.setTask("შევასრულოთ დავალება");
        task1.setNote("აუცილებლად გამოვიყენოთ ნასწავლი მასალა");

        TaskDAO dao = new TaskDAO();
//        int idx = dao.createTask(task1)
//
//
//        ;

        Task task = dao.getById(2);

        System.out.println("Inserted index is: " + task.toString());
    }
}
