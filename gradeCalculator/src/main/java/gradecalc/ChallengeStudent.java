package gradecalc;

public class ChallengeStudent extends Student {
    private Double examWeight; // done
    private Double projectWeight; // done
    private Double unroundedFinal; // done
    private Double roundedFinal; // done
    private static final double EXAM_WEIGHT = 0.50;
    private static final double PROJECT_WEIGHT = 0.50;
    private static final double MAX_GRADE = 100.00;
    private static final double DECIMAL_BOUNDARY = 0.50;

    /**
     * constructor for the challengeStudent class
     */
    public ChallengeStudent() {
        super();

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
     * sets the examWeight member variable
     */
    public void setExamWeight() {
        examWeight = getExamGrade() * EXAM_WEIGHT;
    }

    /**
     * sets the projectWeight member variable
     */
    public void setProjectWeight() {
        projectWeight = getProjectGrade() * PROJECT_WEIGHT;
    }

    /**
     * gets the examWeight member variable
     * 
     * @return the total exam weight
     */
    public double getExamWeight() {
        return examWeight;
    }

    /**
     * gets the projectWeight member variable
     * 
     * @return the total project weight
     */
    public Double getProjectWeight() {
        return projectWeight;
    }

    /**
     * sets the unrounded final student grade
     */
    public void setUnroundedFinal() {
        setProjectWeight();
        setExamWeight();
        unroundedFinal = getProjectWeight() + getExamWeight();
        if (unroundedFinal > MAX_GRADE) {
            unroundedFinal = MAX_GRADE;
        }
    }

    /**
     * overriden toString method
     */
    @Override
    public String toString() {
        return ("Challenge student class");
    }

    /**
     * overriden finalGrade method
     */
    @Override
    public double finalGrade() {
        setUnroundedFinal();
        double tempDouble = unroundedFinal;
        int intPart = (int) tempDouble;
        double decimalPart = tempDouble - intPart;

        if (decimalPart >= DECIMAL_BOUNDARY) {
            roundedFinal = Math.ceil(unroundedFinal);
        } else {
            roundedFinal = Math.floor(unroundedFinal);
        }
        return roundedFinal;
    }

}
