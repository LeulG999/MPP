package Lab4.prob_C;

    class Hourly extends Employee {
        private double hourlyWage;
        private double hoursPerWeek;

        public Hourly(int empId, double hourlyWage, double hoursPerWeek) {
            super(empId);
            this.hourlyWage = hourlyWage;
            this.hoursPerWeek = hoursPerWeek;
        }

        double calcGrossPay(int month, int year) {
            return hourlyWage * hoursPerWeek * 4;
        }
    }

