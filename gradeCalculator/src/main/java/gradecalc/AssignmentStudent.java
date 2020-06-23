package gradecalc;

public class AssignmentStudent extends Student implements ResearchSubject {
    private Double maxGrade;
    private Double assignmentWeight; // done
    private Double quizWeight; // done
    private Double finalWeight; // done
    private Double unroundedMark; // done
    private Double roundedFinal; // done
    private Boolean participating;
    private static final double EXAM_WEIGHT = 0.20;
    private static final double MAX_GRADE = 60.0;
    private static final double ASSIGNMENT_WEIGHT = 0.50;
    private static final double NUM_ASSIGNMENTS = 10.0;
    private static final double QUIZ_WEIGHT = 0.30;
    private static final double NUM_QUIZZES = 3.0;
    private static final double ROUNDING_BOUNDARY = 0.50;
    private static final double RESEARCH_WEIGHT = 0.05;
    private static final double HIGHEST_MARK = 100.00;
    private static final double NINETY_FIVE = 95.00;
    private static final double THREE_PERCENT = 3.00;

    /**
     * constructor for the AssignmentStudent class
     */
    public AssignmentStudent() {
        super();
        maxGrade = MAX_GRADE;
    }

    /**
     * setter for the roundedFinal member variable
     * 
     * @param inputGrade the final grade
     */
    public void setRoundedFinal(Double inputGrade) {
        roundedFinal = inputGrade;
    }

    /**
     * setter for the maxGrade member variable
     * 
     * @param inputGrade the max grade
     */
    public void setMaxGrade(Double inputGrade) {
        maxGrade = inputGrade;
    }

    /**
     * setter for the finalWeight member variable
     */
    public void setFinalWeight() {
        finalWeight = getExamGrade() * EXAM_WEIGHT;
    }

    /**
     * setter for the assignmentWeight member variable
     */
    public void setAssignmentWeight() {
        int i;
        Double sumOfDoubles = 0.0;
        int counterValue = 0;

        for (i = 0; i < getAssignmentGrades().size(); i++) {
            try {
                sumOfDoubles += getAssignmentGrades().get(i);
            } catch (Exception e) {
                Object o = getAssignmentGrades().get(i);
                Long convertToLong = (Long) o;
                counterValue = convertToLong.intValue();
                sumOfDoubles += Double.valueOf(counterValue);
            }
        }
        sumOfDoubles = (sumOfDoubles / NUM_ASSIGNMENTS) * ASSIGNMENT_WEIGHT;
        assignmentWeight = sumOfDoubles;
    }

    /**
     * sets the quizWeight member variable
     */
    public void setQuizWeight() {
        int i;
        Double sumOfDoubles = 0.0;
        int counterValue = 0;
        for (i = 0; i < getQuizGrades().size(); i++) {
            try {
                sumOfDoubles += getQuizGrades().get(i);
            } catch (Exception e) {
                Object o = getQuizGrades().get(i);
                Long convertToLong = (Long) o;
                counterValue = convertToLong.intValue();
                sumOfDoubles += Double.valueOf(counterValue);
            }
        }
        sumOfDoubles = (sumOfDoubles / NUM_QUIZZES) * QUIZ_WEIGHT;
        quizWeight = sumOfDoubles;
    }

    /**
     * gets the finalWeight member variable
     * 
     * @return the total weight of the exam mark
     */
    public Double getFinalWeight() {
        return finalWeight;
    }

    /**
     * gets the assignmentWeight member variable
     * 
     * @return the weight of all the assignment marks
     */
    public Double getAssignmentWeight() {
        return assignmentWeight;
    }

    /**
     * gets the quizWeight member variable
     * 
     * @return total weight of all the quizzes
     */
    public Double getQuizWeight() {
        return quizWeight;
    }

    /**
     * sets the final unrounded mark
     */
    public void setUnroundedMark() {
        setFinalWeight();
        setQuizWeight();
        setAssignmentWeight();

        unroundedMark = getFinalWeight() + getQuizWeight() + getAssignmentWeight();

        if (getIsParticipating() == true) {
            unroundedMark = researchPerk();
        }
    }

    /**
     * overriden finalGrade method
     */
    @Override
    public double finalGrade() {
        setUnroundedMark();
        if (unroundedMark > maxGrade) {
            unroundedMark = MAX_GRADE;
        }

        double tempDouble = unroundedMark;
        int intPart = (int) tempDouble;
        double decimalPart = tempDouble - intPart;

        if (decimalPart >= ROUNDING_BOUNDARY) {
            roundedFinal = Math.ceil(unroundedMark);
        } else {
            roundedFinal = Math.floor(unroundedMark);
        }
        return roundedFinal;
    }

    /**
     * overriden toString method
     */
    @Override
    public String toString() {
        return ("Assignment student class");
    }

    /**
     * overriden setParticipating method from the interface
     */
    @Override
    public void setParticipating(boolean isParticipating) {
        participating = isParticipating;

    }

    /**
     * ovverriden researchPerk method from the interface
     */
    @Override
    public double researchPerk() {
        Double bonusMarks = 0.0;
        if ((unroundedMark >= NINETY_FIVE)) {
            bonusMarks = HIGHEST_MARK;
            return bonusMarks;
        } else {
            bonusMarks = unroundedMark + THREE_PERCENT;
            return bonusMarks;
        }
    }
}
