package Service;

import Repository.GradeRepository;
import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;

import java.util.List;

public class GradeService {
    GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int index) {
        return gradeRepository.getGrade(index);
    }

    public void updateGrade(Grade grade, int index) {
        gradeRepository.updateGrade(grade, index);
    }

    public void addGrade(Grade grade) {
        gradeRepository.addGrade(grade);
    }

    public List<Grade> getStudentGrades() {
        return gradeRepository.getStudentGrades();
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < gradeRepository.getStudentGrades().size(); i++) {
            if (gradeRepository.getGrade(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }

    public Grade getGradeById(String id) {
        int index = getGradeIndex(id);

        if (index == Constants.NOT_FOUND) {
            return new Grade();
        } else {
            return gradeRepository.getGrade(index);
        }
    }

    public void submitGrade(Grade grade) {
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND) {
            addGrade(grade);
        } else {
            updateGrade(grade, index);
        }
    }
}
