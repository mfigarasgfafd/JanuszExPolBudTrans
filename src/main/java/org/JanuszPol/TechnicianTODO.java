package org.JanuszPol;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TechnicianTODO {
    private List<Problem> problems;

    public TechnicianTODO() {
        this.problems = new ArrayList<>();
    }

    public void addProblem(String modelName, String description) {
        this.problems.add(new Problem(modelName, description));
    }

    public Problem getProblemById(UUID id) {
        for (Problem problem : problems) {
            if (problem.getId().equals(id)) {
                return problem;
            }
        }
        return null;
    }

    public void solveProblem(Problem problem) {
        this.problems.remove(problem);
    }

    public static class Problem {
        private UUID id;
        private String modelName;
        private String description;
        private String requestTime;

        public Problem(String modelName, String description) {
            this.id = UUID.randomUUID();
            this.modelName = modelName;
            this.description = description;
            this.requestTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }

        public UUID getId() {
            return id;
        }

        public String getModelName() {
            return modelName;
        }

        public String getDescription() {
            return description;
        }

        public String getRequestTime() {
            return requestTime;
        }
    }

    // display all
    public void displayProblems() {
        for (Problem problem : problems) {
            System.out.println(problem.getId() + " - " + problem.getModelName() + " - " + problem.getDescription() + " - " + problem.getRequestTime());
        }
    }
}
