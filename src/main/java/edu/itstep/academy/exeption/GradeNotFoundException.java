package edu.itstep.academy.exeption;

public class GradeNotFoundException extends RuntimeException {
    public GradeNotFoundException(Long id) {
        super("Grade id " + id + " not found");
    }
}
