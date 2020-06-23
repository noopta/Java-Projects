package gradecalc;

import java.util.ArrayList;

public class ProjectStudent extends Student implements ResearchSubject {

    private Double milestoneWeight; // done
    private Double midtermWeight; // done
    private Double finalExamWeight; // done
    private Double finalUnrounded; // done
    private Double finalRounded; // done
    private boolean participating;
    private static final double MILESTONE_WEIGHT = 0.60;
    private static final double NUM_MILESTONES = 3.0;
    private static final double MIDTERM_WEIGHT = 0.20;
    private static final double EXAM_WEIGHT = 0.20;
    private static final double NINETY_FIVE = 95.00;
    private static final double HIGHEST_MARK = 100.00;
    private static final double RESEARCH_WEIGHT = 0.05;
    private static final double DECIMAL_BOUNDARY = 0.50;
    private static final double MAXIMUM_GRADE = 5.00;

    /**
     * constructor for the ProjectStudent class
     */
    public ProjectStudent() {
        super();
    }

    /**
     * sets the weight of the milestone variables
     */
    public void setMilestoneWeight() {
        int i;
        int counterValue = 0;
        Double convertedDouble = 0.0;
        ArrayList<Double> milestoneValues = new ArrayList<Double>();
        Double sumValue = 0.0;

        for (i = 0; i < getMilestoneGrades().size(); i++) {
            try {
                sumValue += getMilestoneGrades().get(i);
            } catch (Exception e) {
                Object o = getMilestoneGrades().get(i);
                Long convertToLong = (Long) o;
                counterValue += convertToLong.intValue();
            }
        }
        convertedDouble = Double.valueOf(counterValue);
        sumValue += convertedDouble;
        milestoneWeight = (sumValue / NUM_MILESTONES) * MILESTONE_WEIGHT;
    }

    /**
     * setter for the finalRounded member variable
     * 
     * @param inputDouble the final grade
     */
    public void setFinalRounded(Double inputDouble) {
        finalRounded = inputDouble;
    }

    /**
     * gets the weight of the milestone marks
     * 
     * @return the milestone weight
     */
    public Double getMilestoneWeight() {
        return milestoneWeight;
    }

    /**
     * setter for the midtermWeight member variable
     */
    public void setMidtermWeight() {
        midtermWeight = getMidtermGrade() * MIDTERM_WEIGHT;
    }

    /**
     * gets the total weight of the midterm weight
     * 
     * @return weight of the midterm
     */
    public Double getMidtermWeight() {
        return midtermWeight;
    }

    /**
     * sets the final exam weight
     */
    public void setFinalExamWeight() {
        finalExamWeight = getExamGrade() * EXAM_WEIGHT;
    }

    /**
     * gets the finalExamWeight member variable
     * 
     * @return the total weight of the final exam
     */
    public Double getFinalExamWeight() {
        return finalExamWeight;
    }

    /**
     * sets the total unrounded mark
     */
    public void setFinalUnrounded() {
        int tempCoversion = 0;
        double checker = 0.0;
        setMilestoneWeight();
        setMidtermWeight();
        setFinalExamWeight();
        finalUnrounded = getFinalExamWeight() + getMidtermWeight() + getMilestoneWeight();
        if (getIsParticipating() == true) {
            finalUnrounded = researchPerk();
        }
    }

    /**
     * overriden finalGrade method
     */
    @Override
    public double finalGrade() {
        int tempCoversion = 0;
        double checker = 0.0;
        setMilestoneWeight();
        setMidtermWeight();
        setFinalExamWeight();
        setFinalUnrounded();

        // double tempDouble = finalUnrounded;
        // int intPart = (int) tempDouble;
        // double decimalPart = tempDouble - intPart;
        // double decimalValue = (decimalPart * 100) % 10;

        // if (decimalValue >= 5.0) {
        // finalUnrounded = finalUnrounded + 0.1;
        // }

        double tempDouble = finalUnrounded;
        int intPart = (int) tempDouble;
        double decimalPart = tempDouble - intPart;

        if (decimalPart >= DECIMAL_BOUNDARY) {
            finalRounded = Math.ceil(finalUnrounded);
        } else {
            finalRounded = Math.floor(finalUnrounded);
        }

        return finalRounded;
    }

    /**
     * overriden toString method
     */
    @Override
    public String toString() {
        return ("Project student class");
    }

    /**
     * overrided setParticipating method from the interface
     */
    @Override
    public void setParticipating(boolean isParticipating) {
        participating = isParticipating;

    }

    /**
     * overriden researchPerk method from the interface
     */
    @Override
    public double researchPerk() {
        Double bonusMarks = 0.0;
        if ((finalUnrounded >= NINETY_FIVE)) {
            bonusMarks = HIGHEST_MARK;
            return bonusMarks;
        } else {
            bonusMarks = finalUnrounded + MAXIMUM_GRADE;
            return bonusMarks;
        }
    }
}
