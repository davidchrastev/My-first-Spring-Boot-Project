package Repository;

import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {

    private List<Grade> studentGrades = new ArrayList<>();

    public List<Grade> getStudentGrades() {
        return studentGrades;
    }

    public Grade getGrade(int index) {
        return studentGrades.get(index);
    }

    public void updateGrade(Grade grade, int index) {
        studentGrades.set(index, grade);
    }

    public void addGrade(Grade grade) {
        studentGrades.add(grade);
    }

    public void setStudentGrades(List<Grade> studentGrades) {
        this.studentGrades = studentGrades;
    }

}
