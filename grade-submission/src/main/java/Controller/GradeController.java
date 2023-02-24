package Controller;

import Repository.GradeRepository;
import Service.GradeService;
import com.ltp.gradesubmission.Constants;
import com.ltp.gradesubmission.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    GradeRepository gradeRepository = new GradeRepository();
    GradeService gradeService = new GradeService();

    @GetMapping("/")
    public String gradeForm(Model model,@RequestParam(required = false) String id) {
        model.addAttribute("grade",gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) {
            return "form";
        }
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades",gradeRepository.getStudentGrades());
        return "grades";
    }


}
